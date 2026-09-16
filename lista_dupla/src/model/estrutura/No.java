package model.estrutura;

public class No<T> {
	
	private T valor;
	private No<T> proximo;
	private No<T> anterior;
	
	public No(T valor) {
		this.proximo = null;
		this.anterior = null;
		this.valor = valor;
	}
	
	public T getValor() {
		return valor;
	}
	
	public void setValor(T valor) {
		this.valor = valor;
	}
	
	public void setProximo(No<T> proximo) {
		this.proximo = proximo;
	}
	
	//correção: faltava getProximo()
	public No<T> getProximo() {
		return proximo;
	}
	
	public No<T> getAnterior() {
		return anterior;
	}
	
	public void setAnterior(No<T> anterior) {
		this.anterior = anterior;
	}
	
	@Override
	public String toString() {
		return valor.toString();
	}
}
