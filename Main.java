package apl2_ed2;
//Bruno Antico Galin | 10417318 
//Gabriel Lazareti Cardoso | 10417353 
//Guilherme Martins Silva | 10417140 
//Ismael de Sousa e Silva | 10410870 
import java.io.*;
import java.util.concurrent.TimeUnit;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.lang.NullPointerException;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		Scanner scan = new Scanner(System.in);
		String filepath = "df_ide_por_diretoria.csv";
		boolean running = true, runningbst = true, runningavl = true;
		while (running) {
			System.out.println("Escolha a árvore para trabalhar (AVL ou BST ou sair(ESC)):");
			String arvore = scan.nextLine().toUpperCase();
			if (arvore.equals("BST")) {
				System.out.println("Espera de 5 segundos para calcular o tempo de execução da BST.");
				BST bstt = new BST();
				bstt.loadCSV(filepath);
				long startTimebst = System.nanoTime();
		        TimeUnit.SECONDS.sleep(5);
		        long endTimebst = System.nanoTime();
		        long timeElapsedbst = endTimebst - startTimebst;
				System.out.println("Árvore BST carregada com dados do arquivo.");
				System.out.println("Tempo de Execução: " + timeElapsedbst/1000 + " nanossegundos.");
				while (runningbst) {
					System.out.println("\nEscolha uma operação:");
					System.out.println("1 - Inserir");
					System.out.println("2 - Buscar");
					System.out.println("3 - Remover");
					System.out.println("4 - Exibir (Pré-ordem)");
					System.out.println("5 - Média (Aprovação)");
					System.out.println("6 - Média (Reprovação)");
					System.out.println("7 - Média (Abandono)");
					System.out.println("8 - Maior (Aprovação)");
					System.out.println("9 - Maior (Reprovação)");
					System.out.println("10 - Maior (Abandono)");
					System.out.println("11 - Menor (Aprovação)");
					System.out.println("12 - Menor (Reprovação)");
					System.out.println("13 - Menor (Abandono)");
					System.out.println("14 - Sair");

					String opcao = scan.nextLine();
					if (opcao.equals("1")) {
						try {
							System.out.println("Digite o ano: ");
							int year = scan.nextInt();
							System.out.println("Digite o ID da Diretoria: ");
							int id_dir = scan.nextInt();
							scan.nextLine();
							System.out.println("Digite o Nome da Diretoria: ");
							String nm_dir = scan.nextLine();
							System.out.println("Digite a Aprovação 1: ");
							float apr1 = scan.nextFloat();
							System.out.println("Digite a Reprovação 1: ");
							float rep1 = scan.nextFloat();
							System.out.println("Digite o Abandono 1: ");
							float aba1 = scan.nextFloat();
							System.out.println("Digite a Aprovação 2: ");
							float apr2 = scan.nextFloat();
							System.out.println("Digite a Reprovação 2: ");
							float rep2 = scan.nextFloat();
							System.out.println("Digite o Abandono 2: ");
							float aba2 = scan.nextFloat();
							System.out.println("Digite a Aprovação 3: ");
							float apr3 = scan.nextFloat();
							System.out.println("Digite a Reprovação 3: ");
							float rep3 = scan.nextFloat();
							System.out.println("Digite o Abandono 3: ");
							float aba3 = scan.nextFloat();
							System.out.println("Digite o ID da Diretoria por ano: ");
							int id_year = scan.nextInt();
							bstt.insert(year, id_dir, nm_dir, apr1, rep1, aba1, apr2, rep2, aba2, apr3, rep3, aba3,id_year);
						}
						catch (InputMismatchException e) {System.out.println("Tente novamente.");}
					}

					else if (opcao.equals("2")) {
						try {
							System.out.println("Insira o valor (chave) a ser buscado:");
							int key = scan.nextInt();
							bstt.search(key);
						}
						catch (InputMismatchException e) {System.out.println("Tente novamente.");}
						catch (NullPointerException e) {System.out.println("Valor já removido. Tente novamente.");}
					}

					else if (opcao.equals("3")) {
						try {
							System.out.println("Insira o valor (chave) a ser removido:");
							int key = scan.nextInt();
							bstt.remove(key);
							System.out.println("Valor removido.");
						}
						catch (InputMismatchException e) {System.out.println("Tente novamente.");}
					}

					else if (opcao.equals("4")) {
						System.out.println("Exibindo árvore em pré-ordem:");
						bstt.preOrder();
					}
					
					else if (opcao.equals("5")) {
						bstt.calcularMediaAprovacao();
					}
					
					else if (opcao.equals("6")) {
						bstt.calcularMediaReprovacao();
					}
					
					else if (opcao.equals("7")) {
						bstt.calcularMediaAbandono();
					}
					
					else if (opcao.equals("8")) {
						List<TreeNode> maxApr1 = bstt.getTopNMax(5, "APR_1");
						System.out.println("Top 5 maiores valores de aprovação para o ensino infantil (APR_1):");
						bstt.printNodes(maxApr1);
						List<TreeNode> maxApr2 = bstt.getTopNMax(5, "APR_2");
						System.out.println("\nTop 5 maiores valores de reprovação para o ensino fundamental (APR_2):");
						bstt.printNodes(maxApr2);
						List<TreeNode> maxApr3 = bstt.getTopNMax(5, "APR_3");
						System.out.println("\nTop 5 maiores valores de abandono para o ensino médio (APR_3):");
						bstt.printNodes(maxApr3);
					}
					
					else if (opcao.equals("9")) {
						List<TreeNode> maxRep1 = bstt.getTopNMax(5, "REP_1");
						System.out.println("Top 5 maiores valores de reprovação para o ensino infantil (REP_1):");
						bstt.printNodes(maxRep1);
						List<TreeNode> maxRep2 = bstt.getTopNMax(5, "REP_2");
						System.out.println("\nTop 5 maiores valores de reprovação para o ensino fundamental (REP_2):");
						bstt.printNodes(maxRep2);
						List<TreeNode> maxRep3 = bstt.getTopNMax(5, "REP_3");
						System.out.println("\nTop 5 maiores valores de abandono para o ensino médio (REP_3):");
						bstt.printNodes(maxRep3);
					}
					
					else if (opcao.equals("10")) {
						List<TreeNode> maxAba1 = bstt.getTopNMax(5, "ABA_1");
						System.out.println("Top 5 maiores valores de abandono para o ensino infantil (APR_1):");
						bstt.printNodes(maxAba1);
						List<TreeNode> maxAba2 = bstt.getTopNMax(5, "ABA_2");
						System.out.println("\nTop 5 maiores valores de abandono para o ensino fundamental (APR_2):");
						bstt.printNodes(maxAba2);
						List<TreeNode> maxAba3 = bstt.getTopNMax(5, "ABA_3");
						System.out.println("\nTop 5 maiores valores de abandono para o ensino médio (ABA_3):");
						bstt.printNodes(maxAba3);
					}
					
					else if (opcao.equals("11")) {
						List<TreeNode> minApr1 = bstt.getTopNMin(5, "APR_1");
						System.out.println("Top 5 menores valores de aprovação para o ensino infantil (APR_1):");
						bstt.printNodes(minApr1);
						List<TreeNode> minApr2 = bstt.getTopNMin(5, "APR_2");
						System.out.println("\nTop 5 menores valores de aprovação para o ensino fundamental (APR_2):");
						bstt.printNodes(minApr2);
						List<TreeNode> minApr3 = bstt.getTopNMin(5, "APR_3");
						System.out.println("\nTop 5 menores valores de aprovação para o ensino médio (APR_3):");
						bstt.printNodes(minApr3);
					}
					
					else if (opcao.equals("12")) {
						List<TreeNode> minRep1 = bstt.getTopNMin(5, "REP_1");
						System.out.println("Top 5 menores valores de reprovação para o ensino infantil (REP_1):");
						bstt.printNodes(minRep1);
						List<TreeNode> minRep2 = bstt.getTopNMin(5, "REP_2");
						System.out.println("\nTop 5 menores valores de reprovação para o ensino fundamental (REP_2):");
						bstt.printNodes(minRep2);
						List<TreeNode> minRep3 = bstt.getTopNMin(5, "REP_3");
						System.out.println("\nTop 5 menores valores de reprovação para o ensino médio (REP_3):");
						bstt.printNodes(minRep3);
					}
					
					else if (opcao.equals("13")) {
						List<TreeNode> minAba1 = bstt.getTopNMin(5, "ABA_1");
						System.out.println("Top 5 menores valores de abandono para o ensino infantil (ABA_1):");
						bstt.printNodes(minAba1);
						List<TreeNode> minAba2 = bstt.getTopNMin(5, "ABA_2");
						System.out.println("\nTop 5 menores valores de abandono para o ensino fundamental (ABA_2):");
						bstt.printNodes(minAba2);
						List<TreeNode> minAba3 = bstt.getTopNMin(5, "ABA_3");
						System.out.println("\nTop 5 menores valores de abandono para o ensino médio (ABA_3):");
						bstt.printNodes(minAba3);
					}

					else if (opcao.equals("14")) {
						System.out.println("BST Encerrada.");
						runningbst = false;
					}

					else System.out.println("Escolha inválida. Tente novamente.");
				}
			} else if (arvore.equals("AVL")) {
				System.out.println("Espera de 5 segundos para calcular o tempo de execução da BST.");
				AVL avlt = new AVL();
				avlt.loadCSV(filepath);
				long startTimeavl = System.nanoTime();
		        TimeUnit.SECONDS.sleep(5);
		        long endTimeavl = System.nanoTime();
		        long timeElapsedavl = (endTimeavl - startTimeavl);
				System.out.println("Árvore AVL carregada com dados do arquivo.");
				System.out.println("Tempo de Execução: " + timeElapsedavl + " nanossegundos.");

				while (runningavl) {
					System.out.println("\nEscolha uma operação:");
					System.out.println("1 - Inserir");
					System.out.println("2 - Buscar");
					System.out.println("3 - Remover");
					System.out.println("4 - Exibir (Pré-ordem)");
					System.out.println("5 - Média (Aprovação)");
					System.out.println("6 - Média (Reprovação)");
					System.out.println("7 - Média (Abandono)");
					System.out.println("8 - Maior (Aprovação)");
					System.out.println("9 - Maior (Reprovação)");
					System.out.println("10 - Maior (Abandono)");
					System.out.println("11 - Menor (Aprovação)");
					System.out.println("12 - Menor (Reprovação)");
					System.out.println("13 - Menor (Abandono)");
					System.out.println("14 - Sair");

					String opcao = scan.nextLine();
					if (opcao.equals("1")) {
						try {
							System.out.println("Digite o ano: ");
							int year = scan.nextInt();
							System.out.println("Digite o ID da Diretoria: ");
							int id_dir = scan.nextInt();
							scan.nextLine();
							System.out.println("Digite o Nome da Diretoria: ");
							String nm_dir = scan.nextLine();
							System.out.println("Digite a Aprovação 1: ");
							float apr1 = scan.nextFloat();
							System.out.println("Digite a Reprovação 1: ");
							float rep1 = scan.nextFloat();
							System.out.println("Digite o Abandono 1: ");
							float aba1 = scan.nextFloat();
							System.out.println("Digite a Aprovação 2: ");
							float apr2 = scan.nextFloat();
							System.out.println("Digite a Reprovação 2: ");
							float rep2 = scan.nextFloat();
							System.out.println("Digite o Abandono 2: ");
							float aba2 = scan.nextFloat();
							System.out.println("Digite a Aprovação 3: ");
							float apr3 = scan.nextFloat();
							System.out.println("Digite a Reprovação 3: ");
							float rep3 = scan.nextFloat();
							System.out.println("Digite o Abandono 3: ");
							float aba3 = scan.nextFloat();
							System.out.println("Digite o ID da Diretoria por ano: ");
							int id_year = scan.nextInt();
							avlt.insert(year, id_dir, nm_dir, apr1, rep1, aba1, apr2, rep2, aba2, apr3, rep3, aba3, id_year);
						}
						catch (InputMismatchException e) {System.out.println("Tente novamente.");}
					}

					else if (opcao.equals("2")) {
						try {
							System.out.println("Insira o valor (chave) a ser buscado:");
							int key = scan.nextInt();
							avlt.search(key);
						}
						catch (InputMismatchException e) {System.out.println("Tente novamente.");}
					}

					else if (opcao.equals("3")) {
						try {
							System.out.println("Insira o valor (chave) a ser removido:");
							int key = scan.nextInt();
							avlt.remove(key);
							System.out.println("Valor removido.");
						}
						catch (InputMismatchException e) {System.out.println("Tente novamente.");}
						catch (NullPointerException e) {System.out.println("Valor já removido. Tente novamente.");}
					}

					else if (opcao.equals("4")) {
						System.out.println("Exibindo árvore em pré-ordem:");
						avlt.preOrder();
					}
					
					else if (opcao.equals("5")) {
						avlt.calcularMediaAprovacao();
					}
					
					else if (opcao.equals("6")) {
						avlt.calcularMediaReprovacao();
					}
					
					else if (opcao.equals("7")) {
						avlt.calcularMediaAbandono();
					}

					else if (opcao.equals("8")) {
						List<TreeNode> maxApr1 = avlt.getTopNMax(5, "APR_1");
						System.out.println("Top 5 maiores valores de aprovação para o ensino infantil (APR_1):");
						avlt.printNodes(maxApr1);
						List<TreeNode> maxApr2 = avlt.getTopNMax(5, "APR_2");
						System.out.println("\nTop 5 maiores valores de aprovação para o ensino fundamental (APR_2):");
						avlt.printNodes(maxApr2);
						List<TreeNode> maxApr3 = avlt.getTopNMax(5, "APR_3");
						System.out.println("\nTop 5 maiores valores de aprovação para o ensino médio (APR_3):");
						avlt.printNodes(maxApr3);
					}
					
					else if (opcao.equals("9")) {
						List<TreeNode> maxRep1 = avlt.getTopNMax(5, "REP_1");
						System.out.println("Top 5 maiores valores de reprovação para o ensino infantil (REP_1):");
						avlt.printNodes(maxRep1);
						List<TreeNode> maxRep2 = avlt.getTopNMax(5, "REP_2");
						System.out.println("\nTop 5 maiores valores de reprovação para o ensino fundamental (REP_2):");
						avlt.printNodes(maxRep2);
						List<TreeNode> maxRep3 = avlt.getTopNMax(5, "REP_3");
						System.out.println("\nTop 5 maiores valores de reprovação para o ensino médio (REP_3):");
						avlt.printNodes(maxRep3);
					}
					
					else if (opcao.equals("10")) {
						List<TreeNode> maxAba1 = avlt.getTopNMax(5, "ABA_1");
						System.out.println("Top 5 maiores valores de abandono para o ensino infantil (APR_1):");
						avlt.printNodes(maxAba1);
						List<TreeNode> maxAba2 = avlt.getTopNMax(5, "ABA_2");
						System.out.println("\nTop 5 maiores valores de abandono para o ensino fundamental (APR_2):");
						avlt.printNodes(maxAba2);
						List<TreeNode> maxAba3 = avlt.getTopNMax(5, "ABA_3");
						System.out.println("\nTop 5 maiores valores de abandono para o ensino médio (ABA_3):");
						avlt.printNodes(maxAba3);
					}
					
					else if (opcao.equals("11")) {
						List<TreeNode> minApr1 = avlt.getTopNMin(5, "APR_1");
						System.out.println("Top 5 menores valores de aprovação para o ensino infantil (APR_1):");
						avlt.printNodes(minApr1);
						List<TreeNode> minApr2 = avlt.getTopNMin(5, "APR_2");
						System.out.println("\nTop 5 menores valores de aprovação para o ensino fundamental (APR_2):");
						avlt.printNodes(minApr2);
						List<TreeNode> minApr3 = avlt.getTopNMin(5, "APR_3");
						System.out.println("\nTop 5 menores valores de aprovação para o ensino médio (APR_3):");
						avlt.printNodes(minApr3);
					}
					
					else if (opcao.equals("12")) {
						List<TreeNode> minRep1 = avlt.getTopNMin(5, "REP_1");
						System.out.println("Top 5 menores valores de reprovação para o ensino infantil (REP_1):");
						avlt.printNodes(minRep1);
						List<TreeNode> minRep2 = avlt.getTopNMin(5, "REP_2");
						System.out.println("\nTop 5 menores valores de reprovação para o ensino fundamental (REP_2):");
						avlt.printNodes(minRep2);
						List<TreeNode> minRep3 = avlt.getTopNMin(5, "REP_3");
						System.out.println("\nTop 5 menores valores de reprovação para o ensino médio (REP_3):");
						avlt.printNodes(minRep3);
					}
					
					else if (opcao.equals("13")) {
						List<TreeNode> minAba1 = avlt.getTopNMin(5, "ABA_1");
						System.out.println("Top 5 menores valores de abandono para o ensino infantil (ABA_1):");
						avlt.printNodes(minAba1);
						List<TreeNode> minAba2 = avlt.getTopNMin(5, "ABA_2");
						System.out.println("\nTop 5 menores valores de abandono para o ensino fundamental (ABA_2):");
						avlt.printNodes(minAba2);
						List<TreeNode> minAba3 = avlt.getTopNMin(5, "ABA_3");
						System.out.println("\nTop 5 menores valores de abandono para o ensino médio (ABA_3):");
						avlt.printNodes(minAba3);
					}

					else if (opcao.equals("14")) {
						System.out.println("AVL Encerrada.");
						runningavl = false;
					}

					else {
						System.out.println("Escolha inválida. Tente novamente.");
					}
				}
			}
			else if (arvore.equals("ESC")) {
				System.out.println("Programa encerrado.");
				running = false;
			}
			
			else System.out.println("Opção inválida. Tente novamente.");
		}
		scan.close();
	}
}
