package view;

import java.util.Scanner;
import controller.Exercicio5Controller;

public class Exercicio5 {
	
	public static void main(String[] args) {
		Exercicio5Controller cont = new Exercicio5Controller();
		Scanner sc = new Scanner(System.in);
		
		boolean valido = false;
		int n = 0;
		
		while(!valido) {
			System.out.print("Insira a posição da série de Fibonacci de 1 a 20: ");
			n = sc.nextInt();
			
			if (n >= 1 && n <= 20) {
				valido = true;
				System.out.println("O termo " + n + " da série de Fibonacci é: " + cont.Fibonacci(n));
			} else {
				System.out.println("Valor inválido. O valor deve estar entre 1 e 20.\n");
			}
			
			sc.close();
		}
	}
}
