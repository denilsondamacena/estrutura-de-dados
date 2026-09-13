package controller;

public class Exercicio4Controller {
	
	public Exercicio4Controller() {
		super();
	}
	
	public int Fatorial( int n ) {
		
		//condição de parada: quando N = 1, retorna 1 para
		//encerrar as multiplicações
		if( n == 1 ) {
			return 1;
		} else {
			
			//a função chama si mesma, multiplica o valor atual de N
			//pelo fatorial duplo do próximo ímpar anterior (n - 2)
			return n * Fatorial(n - 2);
		}
	}
}
