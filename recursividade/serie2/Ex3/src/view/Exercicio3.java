package view;

import java.util.Scanner;
import controller.Exercicio3Controller;

public class Exercicio3 {
	
	public static void main(String[] args) {
		
		Exercicio3Controller cont = new Exercicio3Controller();
		Scanner sc = new Scanner(System.in);
		
		int[] vt = new int[10];
		int tamanho = vt.length;
		
		System.out.println("Insira " + tamanho + " números naturais diferentes de zero: ");
		
		for (int i = 0; i < tamanho; i++) {
			System.out.print("Elemento [" + i + "]: ");
			int valor = sc.nextInt();
			
			while (valor <= 0) {
				System.out.print("Valor inválido! Insira um número natural maior que zero.");
				valor = sc.nextInt();
			}
			
			vt[i] = valor;
		}
		
		System.out.print("\nVetor: ");
		
		for (int i : vt) {
			System.out.print(i + " ");
		}
		
		int totalPares = cont.encontrarPar(vt, tamanho - 1);
		
		System.out.println("\nExistem " + totalPares + " números pares no vetor.");
		
		sc.close();
	}
}
