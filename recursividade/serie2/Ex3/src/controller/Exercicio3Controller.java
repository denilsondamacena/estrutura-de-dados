package controller;

public class Exercicio3Controller {
	
	public Exercicio3Controller() {
		super();
	}
	
	public int encontrarPar(int[] vt, int tamanho) {
		
		//condição de parada: quando a posição a ser verificada for < 0
		//significa que todos os elementos foram analisados e retorna 0
		if (tamanho < 0 ) {
			return 0;
		} else {
			
			//se o elemento na posição atual for par (valor % 2 == 0)
			//soma 1 e chama a função para a posição anterior (tamanho - 1)
			//caso contrário, apenas continua a contagem com 0 + próxima chamada recursiva
			if (vt[tamanho] % 2 == 0 ) {
				return 1 + encontrarPar(vt, tamanho - 1);
			} else {
				return 0 + encontrarPar(vt, tamanho - 1);
			}
		}
	}
}
