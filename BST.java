package apl2_ed2;

public class BST {
	private TreeNode root;
	private TreeNode left;
	private TreeNode right;
	
	public BST() {
		left = right = null;
	}
	
	public void insert(float key) {
		if (root == null) {
			root = new TreeNode(key);
		}
		else {
			createTree(root, key);
		}
	}
	
	private void createTree(TreeNode root, float key) {
		if (root == null) { 
			System.out.println("A árvore não foi criada ainda."); 
		} 
		else if (key < root.getKey()) {
			if (root.getLeft() == null) {
				root.setLeft(new TreeNode(key));
			}
			else {
				createTree(root.getLeft(), key); 
			}
		} 
		else if (key > root.getKey()) { 
			if (root.getRight() == null) {
				root.setRight(new TreeNode(key));; 
			}
			else {
				createTree(root.getRight(), key);
			}
		} 
	} 
	
	public void search(float key) {
		System.out.println(searchKey(root, key));
	}
	
	private float searchKey(TreeNode node, float key) { 
		if (node == null) { 
			return 0.0f; 
		} 
		else if (key == node.getKey()) {
			return node.getKey();
		} 
		else if (key < node.getKey()) { 
			return searchKey(node.getLeft(), key); 
		} 
		else { 
			return searchKey(node.getRight(), key); 
		} 
	}
	
	 public void inOrderTraversal() {
	        inOrderTraversal(root);
	    }

	 private void inOrderTraversal(TreeNode node) {
	        if (node != null) {
	            inOrderTraversal(node.getLeft());
	            System.out.print(node.getKey() + " ");
	            inOrderTraversal(node.getRight());
	        }
	 }
}
