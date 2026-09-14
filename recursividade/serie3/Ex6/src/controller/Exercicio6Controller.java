package controller; 

public class Exercicio6Controller {
	
	public Exercicio6Controller() {
		super();
	}
	
	public double Fatorial(int n) {
		
		//condição de parada: o fatorial de 1 e 0 é 1
		if (n <= 1) {
			return 1.0;
		} else {
			
			//a função chama si mesma e multiplica n pelo fatorial de (n - 1)
			return n * Fatorial(n - 1);
		}
	}
	
	
	//função recursiva para calcular a soma da série
	public double Soma(int n) {
		
		//condição de parada: quando n chega em 1, retorna o primeiro termo da série ( 1/1! = 1.0)
		if (n == 1) {
			return 1.0;
		} else {
			
			//a função chama si mesma, soma o termo atual (1 / n!) com a soma dos termos
			//anteriores (S(n - 1))
			return (1.0 / Fatorial(n)) + Soma(n - 1);
		}
	}
}
