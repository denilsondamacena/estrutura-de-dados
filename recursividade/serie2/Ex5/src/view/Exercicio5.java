package view;

import java.util.Scanner;
import controller.Exercicio5Controller;

public class Exercicio5 {
	
	public static void main(String[] args) {
		Exercicio5Controller cont = new Exercicio5Controller();
		Scanner sc = new Scanner(System.in);
		
		boolean valido = false;
		int n1 = 0, n2 = 0;
		
		while (!valido) {
			System.out.print("Insira o primeiro valor positivo para x: ");
			n1 = sc.nextInt();
			
			System.out.print("Insira o segundo valor positivo para y: ");
			n2 = sc.nextInt();
			
			if (n1 > 0 && n2 > 0) {
				valido = true;
				System.out.println("O MDC entre " + n1 + " e " + n2 + " é: " + cont.MDC(n1, n2));
			} else {
				System.out.println("Valores inválidos. Os dois valores precisam ser maiores do que zero.");
			}
		}
		sc.close();
	}
}
