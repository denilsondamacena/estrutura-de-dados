package controller;

public class Exercicio1Controller {
	
	public Exercicio1Controller() {
		super();
	}
	
	public int somaMultiplicacao( int n1, int n2 ) {
		
		//condição de parada: quando o multiplicador n2 chega a 1
		//retorna o próprio valor de n1 para finalizar as somas
		//se n2 for 0, o resultado retornado é 0
		if ( n2 == 0 ) {
			return 0;
		}
		
		if ( n2 == 1 ) {
			return n1;
		} else {
			
			//soma n1 ao resultado da multiplicação de n1 por (n2-1)
			return n1 + somaMultiplicacao( n1, --n2 );
		}
	}
}
