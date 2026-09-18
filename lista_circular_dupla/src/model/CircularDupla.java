package model.estrutura;

import model.estrutura.No;

public class CircularDupla<T> {
	private No<T> ultimo_elemento = null;
	private int totalElementos = 0;
	
	public void append(T elemento) {
		No<T> novo = new No<>(elemento);
		if (this.ultimo_elemento == null) {
			this.ultimo_elemento = novo;
			novo.setProximo(novo);
			novo.setAnterior(novo);
		} else {
			No<T> buffer_ultimo = this.ultimo_elemento;
			No<T> buffer_proximo = this.ultimo_elemento.getProximo();
			novo.setAnterior(buffer_ultimo);
			novo.setProximo(buffer_proximo);
			buffer_proximo.setAnterior(novo);
			buffer_ultimo.setProximo(novo);
			this.ultimo_elemento = novo;
		}
		
		this.totalElementos++;
		System.out.println("Elemento inserido. Total de elementos: " + this.totalElementos);
	}
	
	public No<T> getLast() throws IllegalArgumentException {
		if (this.ultimo_elemento == null) {
			throw new IllegalArgumentException("Não existe item na lista.");
		}
		return this.ultimo_elemento;
	}
	
	public void remove(No<T> remover) throws IllegalArgumentException {
		// Trata erro de referência nula
		if (remover == null) {
			throw new IllegalArgumentException("O nó a ser removido não pode ser nulo.");
		}
		
		// Trata tentativa de remoção em lista vazia
		if (this.ultimo_elemento == null) {
			throw new IllegalArgumentException("A lista está vazia.");
		}
		
		No<T> anterior = remover.getAnterior();
		No<T> proximo = remover.getProximo();
		
		// Trata inconsistência de ponteiros (nó corrompido ou já desconectado)
		if (anterior == null || proximo == null) {
			throw new IllegalArgumentException("O nó fornecido não possui referências válidas.");
		}
		
		// Caso: apenas um elemento na lista
		if (this.ultimo_elemento == remover && anterior == remover && proximo == remover) {
			this.ultimo_elemento = null;
		} else {
			anterior.setProximo(proximo);
			proximo.setAnterior(anterior);
			if (this.ultimo_elemento == remover) {
				this.ultimo_elemento = anterior;
			}
		}
		
		// Limpeza dos ponteiros do nó removido
		remover.setProximo(null);
		remover.setAnterior(null);
		remover.setValor(null);
		
		this.totalElementos--;
		System.out.println("Elemento removido. Total de elementos: " + this.totalElementos);
	}
	
	public void remover() throws IllegalArgumentException {
		remove(getLast());
	}
	
	public int getTotalElementos() {
		return this.totalElementos;
	}
	
	@Override
	public String toString() {
		if (this.ultimo_elemento == null) {
			return "[]";
		}
		StringBuilder builder = new StringBuilder("[");
		No<T> buffer = this.ultimo_elemento;
		builder.append(buffer.getValor());
		while (buffer.getProximo() != this.ultimo_elemento) {
			builder.append(",");
			buffer = buffer.getProximo();
			builder.append(buffer.getValor());
		}
		builder.append("]");
		return builder.toString();
	}
}
