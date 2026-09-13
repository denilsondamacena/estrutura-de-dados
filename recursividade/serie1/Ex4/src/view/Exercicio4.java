package view;

import java.util.Scanner;
import java.util.Random;
import controller.Exercicio4Controller;

public class Exercicio4{
	
	public static void main(String[] args){
		
		Exercicio4Controller cont = new Exercicio4Controller();
		Random random = new Random();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Digite a quantidade de posições do vetor: ");
		int n = sc.nextInt();
		
		int[] vt = new int[n];
		
		for(int i = 0; i < n; i++){
			vt[i] = random.nextInt(-100, 100);
		}
		
		int resultado = cont.exibirTotalNegativos(vt, n - 1);
		
		System.out.print("Vetor: ");
		
		for(int i = 0; i < n; i++){
			System.out.print(vt[i] + "|");
		}
		
		System.out.println("\nTotal de valores negativos no vetor: " + resultado);
		
		sc.close();
	}
}
