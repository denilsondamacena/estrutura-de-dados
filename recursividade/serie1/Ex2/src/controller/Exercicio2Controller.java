package controller;

public class Exercicio2Controller{
	
	public Exercicio2Controller(){
		super();
	}
	
	public int procurarMenorValor(int[] vt, int tamanho, int valorUltimaPosicao){
		
		//condição de parada: quando tamanho for = -1
		//significa que todas as posições de vt foram verificadas
		if(tamanho == -1){
			return valorUltimaPosicao;
			
		} else {
			
			//compara  o valor da posição atual com o menor valor encontrado
			//caso seja menor, atualiza valorUltimaPosicao
			if (vt[tamanho] < valorUltimaPosicao){
				valorUltimaPosicao = vt[tamanho];
			}
			
			//chamada recursiva, diminuindo o índice para verificar 
			//a próxima posição do vetor
			return procurarMenorValor(vt, tamanho -1, valorUltimaPosicao);
		}
	}
}
