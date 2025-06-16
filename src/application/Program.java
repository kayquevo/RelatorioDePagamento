package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.RelatorioPagamentos;

public class Program
{
	public static void main(String[] args){
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<RelatorioPagamentos> list = new ArrayList<>();
		
		System.out.print("Insirá o local do arquivo : ");
		String localDoArquivo = sc.nextLine();
		
		File file = new File(localDoArquivo);
		
		try(BufferedReader br = new BufferedReader(new FileReader(file))){
			String line = br.readLine();
			
			while(line != null) {
				String[] campos = line.split(", ");
				double pagamento = Double.parseDouble(campos[0]);
				double conducao5 = Double.parseDouble(campos[1]);
				double caixinhaTotal = Double.parseDouble(campos[2]);
				double caixinhaConta = Double.parseDouble(campos[3]);
				double caixinhaEspecie = Double.parseDouble(campos[4]);
				
				RelatorioPagamentos rp = new RelatorioPagamentos(caixinhaTotal, caixinhaConta, caixinhaEspecie, conducao5,  pagamento);
				list.add(rp);				
				line = br.readLine();
			}
			
			for(RelatorioPagamentos rp : list) {
				System.out.println(rp);
				System.out.println();
			}
			double sum = 0.0;
			
			for(RelatorioPagamentos rp : list) {
				sum += rp.total();
			}
			System.out.println("***********************************");
			System.out.println("TOTAL MENSAL: " + sum);
			System.out.println("***********************************");
			
		}catch(IOException e) {
			System.out.println("Erro na leitura: " + e.getMessage());
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		sc.close();
	}

}	
