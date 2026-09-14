package view;

import java.util.Scanner;
import controller.Exercicio2Controller;

public class Exercicio2 {
	
	public static void main(String[] args) {
		Exercicio2Controller cont = new Exercicio2Controller();
		Scanner sc = new Scanner(System.in);
		boolean valido = false;
		
		int n1 = 0;
		int n2 = 0;
		
		while (!valido) {
			System.out.print("Insira o número principal de 10 a 999999: ");
			n1 = sc.nextInt();
			
			System.out.print("Insira o dígito a ser buscado de 0 a 9: ");
			n2 = sc.nextInt();
			
			if (n1 >= 10 && n1 <= 999999 && n2 >= 0 && n2 <= 9) {
				valido = true;
				System.out.println("O número " + n2 + " aparece " + cont.retornarVezes(n1, n2) + " vez(es) em " + n1 + ".");
			} else {
				System.out.println("Entrada inválida. O primeiro número deve estar entre 10 e 999999 e o segundo entre 0 e 9.\n");
			}
		}
		
		sc.close();
	}
}
		
