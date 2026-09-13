package view;

import java.util.Scanner;
import controller.Exercicio6Controller;

public class Exercicio6 {
	
	private static void exibirVetor(int[] vt) {
		for (int valor : vt) {
			System.out.print(valor + " ");
		}
	}
	
	public static void main(String[] args) {
		Exercicio6Controller cont = new Exercicio6Controller();
		Scanner sc = new Scanner(System.in);
		
		int[] vetorPar = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		int[] vetorImpar = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110};
		
		System.out.println("Teste com vetor par de 10 posições");
		System.out.print("Original: ");
		exibirVetor(vetorPar);
		
		cont.inverterVetor(vetorPar, 0, vetorPar.length - 1);
		
		System.out.print("\nInvertido: ");
		exibirVetor(vetorPar);
		
		System.out.println("\nTeste com vetor ímpar de 11 posições");
		System.out.print("Original: ");
		exibirVetor(vetorImpar);
		
		cont.inverterVetor(vetorImpar, 0, vetorImpar.length - 1);
		
		System.out.print("\nInvertido: ");
		exibirVetor(vetorImpar);
		
		sc.close();
	}
}
