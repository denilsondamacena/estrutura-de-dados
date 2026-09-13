package controller;

public class Exercicio1Controller {
	
	public Exercicio1Controller() {
		super();
	}
	
	public int SomaNaturais( int n ) {
		
		if  ( n < 0 ) {
			return 0;
			//quando o valor de n for menor que 0, 
			//a condição de parada retorna 0
		} else {
			return n + SomaNaturais( n - 1 );
		} //a função chama a si mesma diminuindo 1 de n a cada chamada
		//e os valores são somandos durante o retorno das chamadas
		//exemplo: n valendo 4 | 4,3,2,1,0,-1 -> 0+0+1+3+6=10
	}
}
