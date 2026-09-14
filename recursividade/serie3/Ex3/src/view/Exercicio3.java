package view;

import java.util.Scanner;
import controller.Exercicio3Controller;

public class Exercicio3 {
	
	public static void main(String[] args) {
		Exercicio3Controller cont = new Exercicio3Controller();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Insira a cadeia de caracteres: ");
		String texto = sc.nextLine();
		
		int tamanho = texto.length();
		
		String resultado = cont.inverterTexto(texto, tamanho);
		System.out.println("Invertendo \"" + texto + "\" fica: " + resultado);
		
		sc.close();
	}
}
