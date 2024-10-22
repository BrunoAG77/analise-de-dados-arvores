package apl2_ed2;

public class TreeNode {
	private float key; 
	private TreeNode parent; 
	private TreeNode left; 
	private TreeNode right; 
	
	public TreeNode(float key) { 
		this.key = key;
		left = right = null;
	} 

	public TreeNode(float key, TreeNode parent) { 
		this.key = key; 
		this.parent = parent; 
		this.left = null; 
		this.right = null;
	}
	
	public TreeNode getLeft() {
		return left;
	}
	
	public TreeNode getRight() {
		return right;
	}
	
	public TreeNode getParent() {
		return parent;
	}
	
	public float getKey() {
		return key;
	}
	
	public void setLeft(TreeNode left) {
		this.left = left;
	}
	
	public void setRight(TreeNode right) {
		this.right = right;
	}
	
	public void setParent(TreeNode parent) {
		this.parent = parent;
	}
	
	public void setKey(float key) {
		this.key = key;
	}
	
	public TreeNode getRoot(TreeNode Parent) {
		return parent;
	}

	public boolean isRoot() { 
		return parent == null;
	} 

	public boolean isLeaf() { 
		return left == null && right == null; 
	} 

	public int getDegree() { 
		int degree = 0; 
		if (left != null) ++degree; 
		if (right != null) ++degree; 
		return degree;
	} 
	
	public int getLevel() {
		if (isRoot()) return 0;
		return parent.getLevel() + 1;
	} 
	
	public int getHeight() {
		if (isLeaf()) return 0;
		return Math.max(left == null ? 0 : left.getHeight(), right == null ? 0 : right.getHeight());
	} 
	
	public float visitar() {
		return Float.NaN;
	}
}
