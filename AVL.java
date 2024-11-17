package apl2_ed2;
//Bruno Antico Galin | 10417318 
//Gabriel Lazareti Cardoso | 10417353 
//Guilherme Martins Silva | 10417140 
//Ismael de Sousa e Silva | 10410870 
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AVL {
    private TreeNode root;

    private int height(TreeNode node) {
        return (node == null) ? 0 : node.getHeight();
    }

    private int getBalance(TreeNode node) {
        return (node == null) ? 0 : height(node.getLeft()) - height(node.getRight());
    }
    
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
                int id_year = Integer.parseInt(values[13]);
                insert(year, id_dir, nm_dir, apr1, rep1, aba1, apr2, rep2, aba2, apr3, rep3, aba3, id_year);
            }
        } catch (IOException e) {e.printStackTrace();}
        catch (NumberFormatException e) {System.out.println("Erro ao converter dados do CSV: " + e.getMessage());}
    }

    private TreeNode rotateRight(TreeNode y) {
        TreeNode x = y.getLeft();
        TreeNode T2 = x.getRight();

        x.setRight(y);
        y.setLeft(T2);

        y.setHeight(Math.max(height(y.getLeft()), height(y.getRight())) + 1);
        x.setHeight(Math.max(height(x.getLeft()), height(x.getRight())) + 1);

        return x;
    }

    private TreeNode rotateLeft(TreeNode x) {
        TreeNode y = x.getRight();
        TreeNode T2 = y.getLeft();

        y.setLeft(x);
        x.setRight(T2);

        x.setHeight(Math.max(height(x.getLeft()), height(x.getRight())) + 1);
        y.setHeight(Math.max(height(y.getLeft()), height(y.getRight())) + 1);

        return y;
    }

    public void insert(int year, int idDir, String nm_dir, float apr1, float rep1, float aba1, float apr2, float rep2, float aba2, float apr3, float rep3, float aba3, int id_year) {
        root = insertNode(root, year, idDir, nm_dir, apr1, rep1, aba1, apr2, rep2, aba2, apr3, rep3, aba3, id_year);
    }


    private TreeNode insertNode(TreeNode node, int year, int idDir, String nm_dir, float apr1, float rep1, float aba1, float apr2, float rep2, float aba2, float apr3, float rep3, float aba3, int id_year) {
        if (node == null) return new TreeNode(year, idDir, nm_dir, apr1, rep1, aba1, apr2, rep2, aba2, apr3, rep3, aba3, id_year);

        if (idDir < node.getIdYear()) node.setLeft(insertNode(node.getLeft(), year, idDir, nm_dir, apr1, rep1, aba1, apr2, rep2, aba2, apr3, rep3, aba3, id_year));
        else if (idDir > node.getIdYear()) node.setRight(insertNode(node.getRight(), year, idDir, nm_dir, apr1, rep1, aba1, apr2, rep2, aba2, apr3, rep3, aba3, id_year));
        else return node;
        
        node.setHeight(Math.max(height(node.getLeft()), height(node.getRight())) + 1);
        int balance = getBalance(node);
        
        if (balance > 1 && idDir < node.getLeft().getIdYear()) return rotateRight(node);
        if (balance < -1 && idDir > node.getRight().getIdYear()) return rotateLeft(node);

        if (balance > 1 && idDir > node.getLeft().getIdYear()) {
            node.setLeft(rotateLeft(node.getLeft()));
            return rotateRight(node);
        }

        if (balance < -1 && idDir < node.getRight().getIdYear()) {
            node.setRight(rotateRight(node.getRight()));
            return rotateLeft(node);
        }

        return node;
    }

    public void search(int key) {
    	TreeNode found = searchKey(root, key);
		System.out.println("Ano: " + found.getYear() +
				   ", ID Diretoria: " + found.getCd() +
                   ", Nome Diretoria: " + found.getNmDir() +
                   ", Anos: " + found.getYear() +
                   ", APR_1: " + found.getApr1() +
                   ", REP_1: " + found.getRep1() +
                   ", ABA_1: " + found.getAba1() +
                   ", APR_2: " + found.getApr2() +
                   ", REP_2: " + found.getRep2() +
                   ", ABA_2: " + found.getAba2() +
                   ", APR_3: " + found.getApr3() +
                   ", REP_3: " + found.getRep3() +
                   ", ABA_3: " + found.getAba3() +
                   ", ID Diretoria por Ano: " + found.getIdYear());
	}
	
	private TreeNode searchKey(TreeNode node, int key) { 
		if (node == null) return null; 
		else if (key == node.getIdYear()) return node;
		else if (key < node.getIdYear()) return searchKey(node.getLeft(), key); 
		else return searchKey(node.getRight(), key); 
	}

    public void remove(int key) {
        root = removeNode(root, key);
    }

    private TreeNode removeNode(TreeNode node, int key) {
        if (node == null) return null;

        if (key < node.getIdYear()) node.setLeft(removeNode(node.getLeft(), key));
        else if (key > node.getIdYear()) node.setRight(removeNode(node.getRight(), key));
        else {
            if (node.getLeft() == null || node.getRight() == null) node = (node.getLeft() != null) ? node.getLeft() : node.getRight();
            else {
                TreeNode temp = findMin(node.getRight());
                node.setKey(temp.getKey());
                node.setRight(removeNode(node.getRight(), temp.getIdYear()));
            }
        }

        if (node == null) return node;

        node.setHeight(Math.max(height(node.getLeft()), height(node.getRight())) + 1);

        int balance = getBalance(node);

        if (balance > 1 && getBalance(node.getLeft()) >= 0) return rotateRight(node);

        if (balance > 1 && getBalance(node.getLeft()) < 0) {
            node.setLeft(rotateLeft(node.getLeft()));
            return rotateRight(node);
        }

        if (balance < -1 && getBalance(node.getRight()) <= 0) return rotateLeft(node);

        if (balance < -1 && getBalance(node.getRight()) > 0) {
            node.setRight(rotateRight(node.getRight()));
            return rotateLeft(node);
        }

        return node;
    }

    private TreeNode findMin(TreeNode node) {
        while (node.getLeft() != null) node = node.getLeft();
        return node;
    }

    public void preOrder() {preOrder(root);}

	private void preOrder(TreeNode node) {
	    if (node != null) {
	        System.out.println("Ano: " + node.getYear() +
	        				   ", ID Diretoria: " + node.getCd() +
	                           ", Nome Diretoria: " + node.getNmDir() +
	                           ", APR_1: " + node.getApr1() +
	                           ", REP_1: " + node.getRep1() +
	                           ", ABA_1: " + node.getAba1() +
	                           ", APR_2: " + node.getApr2() +
	                           ", REP_2: " + node.getRep2() +
	                           ", ABA_2: " + node.getAba2() +
	                           ", APR_3: " + node.getApr3() +
	                           ", REP_3: " + node.getRep3() +
	                           ", ABA_3: " + node.getAba3() +
	                           ", ID Diretoria por Ano: " + node.getIdYear());
	        preOrder(node.getLeft());
	        preOrder(node.getRight());
	    }
	       
	}
	public float calcularMediaAprovacao() {
	    float somaAprovacao = 0;
	    int totalRegistros = 0;
	    TreeNode current = root;
	    somaAprovacao += current.getApr1() + current.getApr2() + current.getApr3();
	    totalRegistros += 3;
	    return totalRegistros > 0 ? somaAprovacao / totalRegistros : 0;
	}

	public float calcularMediaReprovacao() {
	    float somaReprovacao = 0;
	    int totalRegistros = 0;
	    TreeNode current = root;
	    somaReprovacao += current.getRep1() + current.getRep2() + current.getRep3();
	    totalRegistros += 3;
	    return totalRegistros > 0 ? somaReprovacao / totalRegistros : 0;
	}
	
	public float calcularMediaAbandono() {
	    float somaAbandono = 0;
	    int totalRegistros = 0;
	    TreeNode current = root;
	    somaAbandono += current.getAba1() + current.getAba2() + current.getAba3();
	    totalRegistros += 3;
	    return totalRegistros > 0 ? somaAbandono / totalRegistros : 0;
	}
	
	private void collectNodes(TreeNode node, List<TreeNode> nodes) {
        if (node == null) return;
        nodes.add(node);
        collectNodes(node.getLeft(), nodes);
        collectNodes(node.getRight(), nodes);
    }

    public List<TreeNode> getTopNMax(int n, String attribute) {
        if (root == null) {
            System.out.println("Árvore vazia!");
            return new ArrayList<>();
        }

        List<TreeNode> nodes = new ArrayList<>();
        collectNodes(root, nodes);
        List<TreeNode> topN = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            TreeNode maxNode = null;
            float maxValue = Float.NEGATIVE_INFINITY;

            for (TreeNode node : nodes) {
                float value = getValueByAttribute(node, attribute);
                if (value > maxValue && value > 0 && !topN.contains(node)) {
                    maxValue = value;
                    maxNode = node;
                }
            }

            if (maxNode != null) topN.add(maxNode);
        }
        return topN;
    }

    public List<TreeNode> getTopNMin(int n, String attribute) {
        if (root == null) {
            System.out.println("Árvore vazia!");
            return new ArrayList<>();
        }

        List<TreeNode> nodes = new ArrayList<>();
        collectNodes(root, nodes);
        List<TreeNode> topN = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            TreeNode minNode = null;
            float minValue = Float.POSITIVE_INFINITY;

            for (TreeNode node : nodes) {
                float value = getValueByAttribute(node, attribute);
                if (value < minValue && value > 0 && !topN.contains(node)) {
                    minValue = value;
                    minNode = node;
                }
            }

            if (minNode != null) topN.add(minNode);
        }
        return topN;
    }

    private float getValueByAttribute(TreeNode node, String attribute) {
        return switch (attribute) {
            case "APR_1" -> node.getApr1();
            case "APR_2" -> node.getApr2();
            case "APR_3" -> node.getApr3();
            case "REP_1" -> node.getRep1();
            case "REP_2" -> node.getRep2();
            case "REP_3" -> node.getRep3();
            case "ABA_1" -> node.getAba1();
            case "ABA_2" -> node.getAba2();
            case "ABA_3" -> node.getAba3();
            default -> throw new IllegalArgumentException("Atributo inválido: " + attribute);
        };
    }

    public void printNodes(List<TreeNode> nodes) {
        for (TreeNode node : nodes) {
        	System.out.println("Ano: " + node.getYear() +
 				   ", ID Diretoria: " + node.getCd() +
                    ", Nome Diretoria: " + node.getNmDir() +
                    ", APR_1: " + node.getApr1() +
                    ", REP_1: " + node.getRep1() +
                    ", ABA_1: " + node.getAba1() +
                    ", APR_2: " + node.getApr2() +
                    ", REP_2: " + node.getRep2() +
                    ", ABA_2: " + node.getAba2() +
                    ", APR_3: " + node.getApr3() +
                    ", REP_3: " + node.getRep3() +
                    ", ABA_3: " + node.getAba3() +
                    ", ID Diretoria por Ano: " + node.getIdYear());
        }
    }
}
