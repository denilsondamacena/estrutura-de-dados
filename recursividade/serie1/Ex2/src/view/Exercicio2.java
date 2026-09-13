package view;

import java.util.Scanner;
import java.util.Random;
import controller.Exercicio2Controller;

public class Exercicio2{
	
	public static void main(String[] args){
		
		Exercicio2Controller cont = new Exercicio2Controller();
		Random random = new Random();
		
		int[] vt =  new int[20];
		
		for(int i = 0; i < 20; i++){
			vt[i] = random.nextInt(100);
		}
		
		int tamanho = vt.length;
		
		System.out.print("Vetor: ");
		
		for(int i = 0; i < 20; i++){
			System.out.print(vt[i] + "|");
		}
		
		//confere se o vetor não está vazio
		if (tamanho > 0){
			int menorValor = cont.procurarMenorValor(vt, tamanho -1, vt[tamanho -1]);
		
		System.out.println("\nO menor valor no vetor é: " + menorValor);
		
		} else {
			System.out.println("\nVetor vazio. Não há menor valor.");
		}
	}
}
