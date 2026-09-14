package controller;

public class Exercicio3Controller {
	
	public Exercicio3Controller() {
		super();
	}
	
	public String inverterTexto(String txt, int tamanho) {
		
		//condição de parada: quando o tamanho da cadeia restante
		//for 0 ou a String estiver vazia, encerra a cadeia recursiva retornando
		//uma String vazia
		if (tamanho == 0) {
			return "";
		} else {
			
			//isola o primeiro caractere da String atual
			String primeiraLetra = txt.substring(0, 1);
			
			//chama a função para o restante da palavra (txt.substring(1))
			//e concatena a primeira letra isolada ao final do retorno
			return inverterTexto(txt.substring(1), tamanho - 1) + primeiraLetra;
		}
	}
}
