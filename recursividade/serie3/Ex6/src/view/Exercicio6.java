package view;

import java.util.Scanner;
import controller.Exercicio6Controller;

public class Exercicio6 {
	
	public static void main(String[] args) {
		Exercicio6Controller cont = new Exercicio6Controller();
		Scanner sc = new Scanner(System.in);
		
		boolean valido = false;
		int n = 0;
		
		while(!valido) {
			System.out.print("Insira um número inteiro positivo maior ou igual a 1: ");
			n = sc.nextInt();
			
			if (n >= 1) {
				valido = true;
				System.out.printf("Resultado da soma para N = %d: %.6f\n", n, cont.Soma(n));
			} else {
				System.out.println("Valor inválido. O número deve ser maior ou igual a 1.\n");
			}
			
			sc.close();
		}
	}
}
