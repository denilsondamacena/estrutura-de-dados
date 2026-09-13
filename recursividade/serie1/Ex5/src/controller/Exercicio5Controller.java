package controller;

public class Exercicio5Controller{
	
	public Exercicio5Controller(){
		super();
	}
	
	public double somarSequencia(int n){
		
		//condição de parada: quando n = 1 a função retorna 1
		//encerrando a recursividade
		if(n == 1){
			return 1.0;
		} else {
			
			//a cada chamada diminui 1 em n, somando o termo 1/n ao
			//resultado anterior. aplicado o cast solicitado no exercicio
			return 1.0 / (double) n + somarSequencia(n - 1);
		}
	}
}
