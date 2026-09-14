package controller;

public class Exercicio1Controller {
	
	public Exercicio1Controller() {
		super();
	}
	
	public int quantidadeDigitos(int n) {
		
		//trata valores negativos convertendo para positivo
		if (n < 0) {
			n = -n;
		}
		
		//condição de parada: quando o valor é menor que 10
		//resta apenas 1 dígito e retorna 1 para finalizar a contagem
		if (n < 10) {
			return 1;
		} else {
			
			//função chama si mesma, adiciona 1 à contagem e remove
			//o último dígito dividindo o valor por 10
			return 1 + quantidadeDigitos(n / 10);
		}
	}
}
