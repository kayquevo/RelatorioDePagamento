package application;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Dia20;
import entities.Dia5;
import entities.RelatorioPagamentos;

public class Program
{
	public static void main(String[] args){
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<RelatorioPagamentos> list = new ArrayList<>();
		
		double pagamento = 1190.00;
		double conducao5 = 120.00;
		double conducao20 = 160.00;
		double vale = 865.00;
		
		try {
				System.out.println("FOLHA DE PAGAMENTO : ");
				System.out.println("***********************************");
				System.out.println("Dia 5");
				
				System.out.print("Valor total da caixinha: ");
				double totalCaixinha = sc.nextDouble();
				
				System.out.print("Caixinha recebida na conta: ");
				double caixinhaConta = sc.nextDouble();
				System.out.print("Valor recebido em espécie: ");
				double caixinhaEspecie = sc.nextDouble();
				
				RelatorioPagamentos rp = new Dia5(totalCaixinha,caixinhaConta,caixinhaEspecie, conducao5, pagamento);
				list.add(rp);
				
					Date now = new Date();
				
					Calendar dia20 = Calendar.getInstance();
					dia20.set(Calendar.DAY_OF_MONTH, 20);
					
					if(now.after(dia20.getTime())){
						System.out.println();
						System.out.println("***********************************");
						System.out.println("Dia 20");
						System.out.print("Valor total da caixinha: ");
						totalCaixinha = sc.nextDouble();
						
						System.out.print("Caixinha recebida na conta: ");
						caixinhaConta = sc.nextDouble();
						System.out.print("Valor recebido em espécie: ");
						caixinhaEspecie = sc.nextDouble();
						
						rp = new Dia20(totalCaixinha,caixinhaConta,caixinhaEspecie, conducao20, vale);
						list.add(rp);
					}						
			}catch(InputMismatchException e) {
				System.out.println("Caracter inválido!");
			}catch(Exception e) {
				System.out.println("Erro inesperado: " + e.getMessage());
			}
		
				System.out.println();
	
				for(RelatorioPagamentos relatorio : list) {
					System.out.println(relatorio);
				}
				
				double sum = 0.0;
				
				for(RelatorioPagamentos relatorio : list) {
					sum += relatorio.total();
				}
				System.out.println();
				System.out.println("***********************************");
				System.out.println("TOTAL MENSAL: " + sum);
				System.out.println("***********************************");

			
			

		sc.close();
	}

}	
//2.276 (1.190 (extra 200) 120, 766)

//Pagamento: 1190
//caixinha: 766
//condução: 120
//extra: 200