package controller;

public class Exercicio6Controller{
	
	public Exercicio6Controller(){
		super();
	}
	
	public int somarNaturais(int n1, int n2){
		
		//condição de parada: quando n2 = 0 significa que todas
		// as unidades de n2 foram transferidas para n1
		if(n2 == 0){
			return n1;
		} else {
			
			//a cada chamada incrementa 1 em n1 e retira 1 de n2 
			n1++;
			n2--;
			
			return somarNaturais(n1, n2);
		}
	}
}
