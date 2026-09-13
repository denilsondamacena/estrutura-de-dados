package view;

import java.util.Scanner;

import controller.Exercicio1Controller;

public class Exercicio1 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Exercicio1Controller cont = new Exercicio1Controller();
		
		System.out.print("Insira o valor de N: ");
		int n = sc.nextInt();
		
		int resultado = cont.SomaNaturais(n);
		
		System.out.println("A soma de " + n + " + seus primeiros números naturais é = " + resultado);
	}
}
