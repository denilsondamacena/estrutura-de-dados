package view;

import java.util.Scanner;
import controller.Exercicio7Controller;

public class Exercicio7 {
	
	public static void main(String[] args) {
		Exercicio7Controller cont = new Exercicio7Controller();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Insira um número inteiro: ");
		int n = sc.nextInt();
		
		int resultado = cont.somaDigitos(n);
		System.out.println("A soma dos dígitos de " + n + " é: " + resultado);
		
		sc.close();
	}
}
