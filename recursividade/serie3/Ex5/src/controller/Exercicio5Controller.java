package controller;

public class Exercicio5Controller {
	
	public Exercicio5Controller() {
		super();
	}
	
	public int Fibonacci(int n) {
		
		//condição de parada: os dois primeiros termos da série (posições 1 e 2) valem 1
		if (n == 1 || n == 2) {
			return 1;
		} else {
			
			//função chama si mesma e cada termo subsquente é a soma dos dois termos anteriores
			return Fibonacci(n - 1) + Fibonacci(n - 2);
		}
	}
}
