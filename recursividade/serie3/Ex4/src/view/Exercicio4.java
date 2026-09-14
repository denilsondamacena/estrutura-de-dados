package view;

import java.util.Scanner;
import controller.Exercicio4Controller;

public class Exercicio4 {
	
	public static void main(String[] args) {
		Exercicio4Controller cont = new Exercicio4Controller();
		Scanner sc = new Scanner(System.in);
		
		boolean valido = false;
		int n = 0;
		
		while (!valido) {
			System.out.print("Insira um valor inteiro entre 0 e 2000: ");
			n = sc.nextInt();
			
			if (n >= 0 && n <= 2000) {
				valido = true;
				
				String resultado;
				if (n == 0) {
					resultado = "0";
				} else {
					resultado = cont.converterBinario(n);
				}
				
				System.out.println("Em binário, o número " + n + " é: " + resultado);
			} else {
				System.out.println("Valor inválido. Insira um número de 0 a 2000.\n");
			}
			
			sc.close();
		}
	}
}
