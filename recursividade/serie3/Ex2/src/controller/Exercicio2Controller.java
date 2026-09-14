package controller;

public class Exercicio2Controller {
	
	public Exercicio2Controller() {
		super();
	}
	
	public int retornarVezes(int n1, int n2) {
		
		//condição de parada: quando resta apenas 1 dígito
		//(n1 < 10) verifica se ele é igual ao dígito buscado (n2)
		//se for igual, retorna 1, senão, retorna 0
		if (n1 < 10) {
			if (n1 == n2) {
				return 1;
			} else {
				return 0;
			}
		} else {
			//recursividade: n1 % 10 isola o último dígito atual
			//do número, se for igual a n2 adiciona 1 à contagem e chama 
			//a função para o restante (n1 / 10) e se for diferente
			//adiciona 0 e continua a verificação no restante do número
			if (n1 % 10 == n2) {
				return 1 + retornarVezes(n1 / 10, n2);
			} else {
				return 0 + retornarVezes(n1 / 10, n2);
			}
		}
	}
}
