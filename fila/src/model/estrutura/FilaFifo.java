package model.estrutura;

public class FilaFifo<T> {
	private No<T> inicio = null;
	
	//enqueue: adiciona um elemento no final da fila
	//dequeue? retira  o primeiro elemento da fila
	//last? localiza o último nó (uso interno)
	
	private No<T> last() {
		if(this.inicio == null)
			throw new IllegalStateException( "Não existe elemento na fila.");
		No<T> buffer = this.inicio;
		while(buffer.getProximo() != null)
			buffer = buffer.getProximo();
		return buffer;
	}
	
	public void enqueue(T elemento) {
		No<T> buffer = new No<>(elemento);
		if(this.inicio == null) {
			this.inicio = buffer;
		} else {
			this.last().setProximo(buffer);
		}
	}
	
	public T dequeue() {
		if(this.inicio == null) {
			return null;
		}
		No<T> primeiro = this.inicio;
		this.inicio = primeiro.getProximo();
		return primeiro.getValor();
	}
	
	@Override
	public String toString() {
		if(this.inicio == null) {
			return "[]";
		}
		
		StringBuilder builder = new StringBuilder("[");
		No<T> buffer = this.inicio;
		builder.append(buffer.getValor());
		while(buffer.getProximo() != null) {
			builder.append(",");
			buffer = buffer.getProximo();
			builder.append(buffer.getValor());
		}
		builder.append("]");
		return builder.toString();
	}
}
