package view;

import java.util.Scanner;
import controller.Exercicio1Controller;

public class Exercicio1 {
	
	public static void main(String[] args) {
		
		Exercicio1Controller cont = new Exercicio1Controller();
		Scanner sc = new Scanner(System.in);
		
		int n1, n2;
		
		System.out.print("Insira o valor de A: ");
		n1 = sc.nextInt();
		
		System.out.print("Insira o valor de B: ");
		n2 = sc.nextInt();
		
		System.out.println("A multiplicação de " + n1 + " * " + n2 + " é: " + cont.somaMultiplicacao(n1, n2));
		
		sc.close();
	}
}
