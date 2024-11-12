package apl2_ed2;

import java.io.*;

public class BST {
	private TreeNode root;

    public void loadCSV(String filePath) {
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] values = line.split(";");
                int year = Integer.parseInt(values[1]);
                int id_dir = Integer.parseInt(values[2]);
                String nm_dir = values[3].trim();
                float apr1 = Float.parseFloat(values[4]);
                float rep1 = Float.parseFloat(values[5]);
                float aba1 = Float.parseFloat(values[6]);
                float apr2 = Float.parseFloat(values[7]);
                float rep2 = Float.parseFloat(values[8]);
                float aba2 = Float.parseFloat(values[9]);
                float apr3 = Float.parseFloat(values[10]);
                float rep3 = Float.parseFloat(values[11]);
                float aba3 = Float.parseFloat(values[12]);
                insert(year, id_dir, nm_dir, apr1, rep1, aba1, apr2, rep2, aba2, apr3, rep3, aba3);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (NumberFormatException e) {
            System.out.println("Erro ao converter dados do CSV: " + e.getMessage());
        }
    }

    public void insert(int year, int id_dir, String nm_dir, float apr1, float rep1, float aba1, float apr2, float rep2, float aba2, float apr3, float rep3, float aba3) {
        TreeNode newNode = new TreeNode(year, id_dir, nm_dir, apr1, rep1, aba1, apr2, rep2, aba2, apr3, rep3, aba3);
        if (root == null) {
            root = newNode;
        } else {
            insertNode(root, newNode);
        }
    }

    private void insertNode(TreeNode current, TreeNode newNode) {
        if (newNode.getCd() < current.getCd()) {
            if (current.getLeft() == null) {
                current.setLeft(newNode);
            } else {
                insertNode(current.getLeft(), newNode);
            }
        } else if (newNode.getCd() > current.getCd()) {
            if (current.getRight() == null) {
                current.setRight(newNode);
            } else {
                insertNode(current.getRight(), newNode);
            }
        }
        else if (newNode.getCd() == current.getCd() && newNode.getYear() != current.getYear()) {
        }
    }
	
	public void search(int key) {
		System.out.println("Ano: " + root.getYear() +
				   ", ID Diretoria: " + searchKey(root, key) +
                   ", Nome Diretoria: " + root.getNmDir() +
                   ", Anos: " + root.getYear() +
                   ", APR_1: " + root.getApr1() +
                   ", REP_1: " + root.getRep1() +
                   ", ABA_1: " + root.getAba1() +
                   ", APR_2: " + root.getApr2() +
                   ", REP_2: " + root.getRep2() +
                   ", ABA_2: " + root.getAba2() +
                   ", APR_3: " + root.getApr3() +
                   ", REP_3: " + root.getRep3() +
                   ", ABA_3: " + root.getAba3());
	}
	
	private int searchKey(TreeNode node, int key) { 
		if (node == null) { 
			return 0; 
		} 
		else if (key == node.getCd()) {
			return node.getCd();
		} 
		else if (key < node.getCd()) { 
			return searchKey(node.getLeft(), key); 
		} 
		else { 
			return searchKey(node.getRight(), key); 
		} 
	}
	
	public void remove(int key) {
		root = removeKey(root,key);
	}
	
	private TreeNode removeKey(TreeNode root, int key) {
		if (root == null) return null;
		if (key < root.getCd()) {
			root.setLeft(removeKey(root.getLeft(), key));
		} 
		else if (key > root.getCd()) {
			root.setRight(removeKey(root.getRight(), key));
		} 
		else {
			if (root.getLeft() == null && root.getRight() == null) {
				return null;
			}
			else if (root.getLeft() == null) {
				return root.getRight();
			}
			else if (root.getRight() == null) {
				return root.getLeft();
			}
			else {
				int min = findMin(root.getRight());
				root.setKey(min);
				root.setRight(removeKey(root.getRight(), min));
			}
		}
		return root;
	}
	
	private int findMin(TreeNode node) {
		while (node.getLeft() != null) {
			node = node.getLeft();
		}
		return node.getCd();
	}
	
	public void preOrder() {
	    preOrder(root);
	}

	private void preOrder(TreeNode node) {
	    if (node != null) {
	        System.out.println("Ano: " + node.getYear() +
	        				   ", ID Diretoria: " + node.getCd() +
	                           ", Nome Diretoria: " + node.getNmDir() +
	                           ", Anos: " + node.getYear() +
	                           ", APR_1: " + node.getApr1() +
	                           ", REP_1: " + node.getRep1() +
	                           ", ABA_1: " + node.getAba1() +
	                           ", APR_2: " + node.getApr2() +
	                           ", REP_2: " + node.getRep2() +
	                           ", ABA_2: " + node.getAba2() +
	                           ", APR_3: " + node.getApr3() +
	                           ", REP_3: " + node.getRep3() +
	                           ", ABA_3: " + node.getAba3());
	        preOrder(node.getLeft());
	        preOrder(node.getRight());
	    }
	}
}
