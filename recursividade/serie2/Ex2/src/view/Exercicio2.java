package view; 

import java.util.Scanner;
import controller.Exercicio2Controller;

public class Exercicio2 {
	
	public static void main(String[] args) {
		
		Exercicio2Controller cont = new Exercicio2Controller();
		Scanner sc = new Scanner(System.in);
		
		int n1, n2;
		
		System.out.print("Insira o valor do dividendo A: ");
		n1 = sc.nextInt();
		
		System.out.print("Insira o valor do divisor B: ");
		n2 = sc.nextInt();
		
		System.out.println("O resto da divisão de " + n1 + " por " + n2 + " é: " + cont.restoDivisao(n1, n2));
		
		sc.close();	
	}
}
