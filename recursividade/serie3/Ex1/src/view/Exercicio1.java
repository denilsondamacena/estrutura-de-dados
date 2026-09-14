package view;

import java.util.Scanner;
import controller.Exercicio1Controller;

public class Exercicio1 {
	
	public static void main(String[] args) {
		Exercicio1Controller cont = new Exercicio1Controller();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Insira um valor inteiro: ");
		int n = sc.nextInt();
		
		System.out.println("O número " + n + " possui " + cont.quantidadeDigitos(n) + " dígito(s)");
		
		sc.close();
	}
}
