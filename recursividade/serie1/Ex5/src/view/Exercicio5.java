package view;

import java.util.Scanner;
import controller.Exercicio5Controller;

public class Exercicio5{
	
	public static void main(String[] args){
		
		Exercicio5Controller cont = new Exercicio5Controller();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Insira um valor para N: ");
		int n = sc.nextInt();
		
		if(n >= 1){
			double resultado = cont.somarSequencia(n);
			
			System.out.print("Resultado da série: 1");
			
			for(int i = 2; i <= n; i++){
				System.out.print(" + 1/" + i);
			}
			
			System.out.println();
			System.out.printf("Resultado: %.2f%n", resultado);
		
		} else {
			
			System.out.println("Valor inválido. Insira um número maior ou igual a 1.");
		}
		
		sc.close();
	}
}
