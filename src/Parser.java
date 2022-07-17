import java.util.Scanner;
import java.util.regex.Pattern;

public class Parser {
	String equation;
	String nextToken;
	TreeNode resultTree;
	Scanner sc;
	
	public Parser(String string) {
		equation = string;
		sc = new Scanner(equation);
	}

	void scanToken() {
		if (sc.hasNext()) {
			nextToken = sc.next();
		} else {
			nextToken = "";
		}
	}
	
	TreeNode parseS() {
		TreeNode a = parseF();
		while (true) {
			if (nextToken.equals("+")) {
				scanToken();
				TreeNode b = parseF();
				a = new Union(a,b);
			} else if (nextToken.equals("-")) {
				scanToken();
				TreeNode b = parseF();
				a = new Subtract(a,b);
			} else if (nextToken.equals("&")) {
				scanToken();
				TreeNode b = parseF();
				a = new Intersect(a,b);
			} else {
				return a;
			}
		}
		
	}
	
	TreeNode parseF() {
		if (Pattern.matches("\\w+", nextToken)) {
			TreeNode a =  new ID(nextToken);
			scanToken();
			return a;
		} else if (nextToken.equals("(")) {
			scanToken();
			TreeNode a = parseS();
			if (a == null) {
				return null;
			}
			if (nextToken.equals(")")) {
				scanToken();
				return a;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}
	
	public static void main(String[] args) {
		Parser parser = new Parser("A + ( B - C ) & A");
		
		parser.scanToken();
		parser.resultTree = parser.parseS();
		
		if (parser.nextToken != "") {
			System.out.println("Input-String fehlerhaft. Enthält: " + parser.nextToken);
		}
		
		System.out.println(parser.resultTree.toString());
		
		System.out.println(parser.resultTree.eval());
		
	}
	
}
