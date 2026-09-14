package controller; 

public class Exercicio7Controller {
	
	public Exercicio7Controller(){
		super();
	}
	
	public int somaDigitos(int n) {
		
		//converte negativos para positivo
		if (n < 0) {
			n = -n;
		}
		
		//condição de parada: quando o número for menor que 10
		//resta apenas um dígito que é retornado diretamente
		if (n < 10) {
			return n;
		} else {
			
			//o resto de n % 10 obtém o último dígito do número, a divisão de n / 10 remove
			// o último dígito, retorna a soma do último dígito com o restante do número
			return (n % 10) + somaDigitos(n / 10);
		}
	}
}
