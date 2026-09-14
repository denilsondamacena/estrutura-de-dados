package controller;

public class Exercicio4Controller {
	
	public Exercicio4Controller() {
		super();
	}
	
	public String converterBinario(int n) {
		
		//condição de parada: quando as divisões inteiras sucessivas por 2
		//chegarem a 0 encerra a cadeia recursiva retornando uma String vazia
		if (n == 0) {
			return "";
		} else {
			
			//função chama si mesma passando a divisão inteira de (n / 2) para
			//processar os bits mais relavantes primeiro e depois concatena o resto
			//da divisão atual (n % 2) convetido em String no final do resultado
			return converterBinario(n / 2) + String.valueOf(n % 2);
		}
	}
}
