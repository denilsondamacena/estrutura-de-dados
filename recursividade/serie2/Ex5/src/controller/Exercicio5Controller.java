package controller;

public class Exercicio5Controller {
	
	public Exercicio5Controller() {
		super();
	}
	
	public int MDC(int x, int y) {
		
		
		//condição de parada: quando os valores são iguais
		//encontramos o MDC (MDC(x, x) = x)
		if ( x == y ) {
			return x;
			
			//se x for maior que y MDC(x, y) = MDC(x - y, y)
		} else if (x > y) {
			return MDC(x - y, y);
			
			//se x for menor que y MDC(x, y) = MDC(y, x) inverte os parâmetros
		} else {
			return MDC(y, x);
		}
	}
}
