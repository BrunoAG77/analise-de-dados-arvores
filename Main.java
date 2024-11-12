package apl2_ed2;

import java.io.*;

public class Main {
	public static void main(String[] args) {
		BST tree = new BST();
        String filepath = "df_ide_por_diretoria1.csv";
        tree.loadCSV(filepath);
        System.out.println("\nInserção na BST:");
        tree.preOrder();
        System.out.println("\nBusca na BST:");
        tree.search(10101);
        tree.remove(10101);
        tree.remove(10102);
        tree.remove(10104);
        System.out.println("\nRemoção na BST:");
        tree.preOrder();
	}
}
