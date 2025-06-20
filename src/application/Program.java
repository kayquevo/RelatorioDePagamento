package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Pagamento;

public class Program
{
	public static void main(String[] args){
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Pagamento> list = new ArrayList<>();
		
		String localDoPasta = "C:\\temp\\dadosDePagamento"; 
		
		File pasta = new File(localDoPasta);
		File[] files = pasta.listFiles(File::isFile);
		
		System.out.println("ESCOLHA UM ARQUIVO: ");
		
		for(int i = 0; i < files.length; i++) {
			System.out.println("[" + (i + 1) + "] " + files[i].getName());
		}
		
		try {
			System.out.println();
			System.out.print("Digite o número correspondente: ");
			int escolha = sc.nextInt();
				
			File caminho = files[escolha - 1];
			
			boolean addFile = new File(localDoPasta + "//Relatorio").mkdir();
			String addTXT = localDoPasta + "//Relatorio//resultado.txt";
			
			
			try(BufferedReader br = new BufferedReader(new FileReader(caminho))){
				String line = br.readLine();
				
				while(line != null) {
					String[] campos = line.split(", ");
					
				    Double valorTotal = Double.parseDouble(campos[0]);
					int dia = Integer.parseInt(campos[1]);
					
					Pagamento p = new Pagamento(valorTotal, dia);
					list.add(p);
					line = br.readLine();
				}
				try(BufferedWriter bw = new BufferedWriter(new FileWriter(addTXT))){
					double pgORvl = 0.0;
					double cond = 0.0;
					double cx = 0.0;
					
					for(Pagamento p : list) {
						bw.write("**************************");
						bw.newLine();
						bw.write("DIA " + p.getDia());
						bw.newLine();
						bw.write("Vale/Pagamento: " + p.getPagamento(p.getCaixinha()));
						bw.newLine();
						bw.write("Condução: " + p.getConducao());
						bw.newLine(); bw.newLine();
						bw.write("Caixinha: " + p.getCaixinha());
						bw.newLine();
						bw.write("Total recebido: " + p.getValorTotal());
						bw.newLine();bw.newLine();
						
						pgORvl += p.getPagamento(p.getCaixinha()); 
						cond += p.getConducao();
						cx += p.getCaixinha();
						
						bw.write("**************************");
						bw.newLine();
						bw.write("Pg/Vl. " + String.format("%.0f", pgORvl) 
								+ " + cx." + String.format("%.0f", cx) 
								+ " + condução." + String.format("%.0f", cond));
						bw.newLine();
						bw.write("**************************");
					}
					
				}catch(IOException e) {
					System.out.println("Erro na saida: " + e.getMessage());
				}
			}catch(IOException e) {
				System.out.println("Erro na leitura: " + e.getMessage());
			}
			
			try(BufferedReader br = new BufferedReader(new FileReader(addTXT))){
				String line = br.readLine();
				while(line != null) {
					System.out.println(line);
					line = br.readLine();
				}
				
			}catch(IOException e) {
				System.out.println("Falha na leitura: " + e.getMessage());
			}
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Documento selecionado não existe.");
		}catch(InputMismatchException e) {
			System.out.println("Valor digitado incompatível.");
		}
		sc.close();
	}

}	
