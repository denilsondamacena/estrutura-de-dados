package view;

import java.util.Scanner;
import controller.Exercicio6Controller;

public class Exercicio6{
	
	public static void main(String[] args){
		
		Exercicio6Controller cont = new Exercicio6Controller();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Insira o primeiro número natural: ");
		int n1 = sc.nextInt();
		
		System.out.print("Insira o segundo número natural: ");
		int n2 = sc.nextInt();
		
		if(n1 >= 0 && n2 >= 0){
			int resultado = cont.somarNaturais(n1, n2);
			
			System.out.println("Resultado: " + resultado);
			
		} else {
			
			System.out.println("Os valores devem ser números naturais.");
	
		}
		
		sc.close();
	}
}
