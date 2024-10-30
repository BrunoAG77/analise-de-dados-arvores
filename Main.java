package apl2_ed2;

public class Main {
	public static void main(String[] args) {
		BST tree = new BST();
        	tree.insert(5.0f);
        	tree.insert(3.0f);
        	tree.insert(7.0f);
        	tree.insert(2.0f);
        	tree.insert(4.0f);
        	tree.insert(6.0f);
        	tree.insert(8.0f);
        	tree.search(4.0f);
        	System.out.println("Antes:");
        	tree.inOrder();
        	tree.remove(5.0f);
        	System.out.println("\nDepois:");
        	tree.inOrder();
        	tree.remove(8.0f);
        	System.out.println("\nDepois:");
        	tree.inOrder();
        	tree.remove(2.0f);
        	System.out.println("\nDepois:");
		tree.inOrder();
	}
}
