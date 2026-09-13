package controller;

public class Exercicio6Controller {
	
	public Exercicio6Controller() {
		super();
	}
	
	public int[] inverterVetor(int[] vt, int inicio, int fim) {
		
		//condição de parada: em vetores ímpares os índices se encontram
		//no centro (inicio == fim) já em vetores pares os índices se
		//encontram (inicio  > fim), quando isso ocorre o vetor está invertido
		if ( inicio >= fim ) {
			return vt;
		}
		
		//troca de posições
		int aux = vt[inicio];
		vt[inicio] = vt[fim];
		vt[fim] = aux;
		
		//a função chama a si mesma e aproxima os extremos (avança o inicio e recua o fim)
		return inverterVetor(vt, inicio + 1, fim - 1);
	}
}
