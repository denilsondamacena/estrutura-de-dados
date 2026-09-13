package view;

import java.util.Scanner;
import controller.Exercicio3Controller;

public class Exercicio3{
	
	public static void main(String[] args){
		
		Exercicio3Controller cont = new Exercicio3Controller();
		Scanner sc = new Scanner(System.in);
		
		boolean valido =  false;
		
		while (valido != true){
			System.out.print("Insira o valor de N: ");
			int n = sc.nextInt();
			
			if(n >= 0 && n <= 12){
				int resultado = cont.exibirFatorial(n);
				
				System.out.println("O fatorial de " + n + " é: " + resultado);
				
				valido = true;
			} else {
				System.out.println("Número fora do limite. Por favor, insira um valor de 0 a 12.");
			}
		}
		
		sc.close();
	}
}
