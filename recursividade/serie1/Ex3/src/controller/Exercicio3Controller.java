package controller;

public class Exercicio3Controller{
	
	public Exercicio3Controller(){
		super();
	}
	
	public int exibirFatorial(int n){
		
		//condição de parada: quando n = 0
		//deve retornar 1, pois 0! = 1
		if (n == 0){
			return 1;
		} else {
			
			//o fatorial de n é calculado multiplicando
			// n pelo fatorial do número anterior, n - 1
			return n * exibirFatorial(n - 1);
		}
	}
}
