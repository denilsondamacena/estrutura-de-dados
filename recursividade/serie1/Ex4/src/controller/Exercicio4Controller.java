package controller;

public class Exercicio4Controller{
	
	public Exercicio4Controller(){
		super();
	}
	
	public int exibirTotalNegativos(int[] vt, int n){
		
		//condição de parada: quando n for menor que 0
		//todas as posições de vt foram verificadas
		if(n < 0){
			return 0;
		} else {
			
			//a função verifica a posição anterior de vt
			// utilizando n - 1 na próxima chamada recursiva
			int totalNegativos = exibirTotalNegativos(vt, n - 1);
			
			//verifica se o valor da posição atual é negativo
			//se sim, adiciona 1 ao total de negativos
			if(vt[n] < 0){
				return 1 + totalNegativos;
			} else {
				return totalNegativos;
			}
		}
	}
}
