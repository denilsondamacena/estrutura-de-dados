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
			System.out.print("Insira um número maior que zero e ímpar: ");
			n = sc.nextInt();
			
			if (n > 0 && n % 2 != 0) {
				valido = true;
			} else {
				System.out.println("Valor inválido. Insira um número maior que zero e ímpar.");
			}
		}
		
		System.out.println("O fatorial duplo de " + n + " é " + cont.Fatorial(n));
		
		sc.close();
	}
}
