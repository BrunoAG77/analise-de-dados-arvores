package apl2_ed2;

import java.util.List;
import java.util.ArrayList;

public class TreeNode {
	private int key;
	private int year;
    private int idDir;
    private String nm_dir;
    private float apr1, rep1, aba1, apr2, rep2, aba2, apr3, rep3, aba3;
    private TreeNode left, right;

    // Construtor para armazenar todos os dados
    public TreeNode(int year, int idDir, String nm_dir, float apr1, float rep1, float aba1, float apr2, float rep2, float aba2, float apr3, float rep3, float aba3) {
    	this.year = year;
        this.idDir = idDir;
        this.nm_dir = nm_dir;
        this.apr1 = apr1;
        this.rep1 = rep1;
        this.aba1 = aba1;
        this.apr2 = apr2;
        this.rep2 = rep2;
        this.aba2 = aba2;
        this.apr3 = apr3;
        this.rep3 = rep3;
        this.aba3 = aba3;
    }

    // Métodos getters e setters
    public float getApr3() {
        return apr3;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
	
	
	public void setApr3(float apr3) {
		this.apr3 = apr3;
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
	
	public int getCd() {
		return idDir;
	}
	
    public int getYear() { return year; }
    public String getNmDir() { return nm_dir; }
    public float getApr1() { return apr1; }
    public float getRep1() { return rep1; }
    public float getAba1() { return aba1; }
    public float getApr2() { return apr2; }
    public float getRep2() { return rep2; }
    public float getAba2() { return aba2; }
    public float getRep3() { return rep3; }
    public float getAba3() { return aba3; }
    public int getKey() {return key;}
    public void setKey(int key) {this.key = key;}

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
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	public float visitar() {
		return Float.NaN;
	}
}
