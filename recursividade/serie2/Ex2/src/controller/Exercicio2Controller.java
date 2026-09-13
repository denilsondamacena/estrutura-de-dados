package controller;

public class Exercicio2Controller {
	
	public Exercicio2Controller() {
		super();
	}
	
	public int restoDivisao(int n1, int n2) {
		
		//condição de parada: quando o dividendo n1 for menor
		// que o divisor n2 não será possível subtrair n2 sem
		//obter um resultado negativo, o valor restante em n1
		//é o próprio resto da divisão
		if (n1 < n2) {
			return n1;
		} else {
			
			//a função chama a si mesma, subtrai o divisor n2 do
			//dividendo n1 e repassa a nova sobra para a próxima chamada
			return restoDivisao(n1 - n2, n2);
		}
	}
}
