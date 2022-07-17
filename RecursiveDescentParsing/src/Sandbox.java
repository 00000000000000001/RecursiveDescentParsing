import java.util.Scanner;

public class Sandbox {
	
	static void print(String str){
		System.out.println(str);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner("A + B");
		
		print(sc.next());
		print(sc.next());
		print(sc.next());
		
		if (!sc.hasNext()) {
			print("ende");
		}
		
		sc.close();
	}
}
