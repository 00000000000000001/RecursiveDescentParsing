
public class Subtract extends TreeNode {
	
	public Subtract(TreeNode a, TreeNode b) {
		super(a, b);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString(){
		return "(" + left.toString() + " - " + right.toString() + ")"; // recursive calls to print the sub-trees
	}

	@Override
	public Menge eval() {
		// TODO Auto-generated method stub
		return null;
	}
}
