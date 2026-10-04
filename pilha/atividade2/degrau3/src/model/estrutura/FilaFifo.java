package model.estrutura;

// FilaFifo do cap. 5 com o enqueue em O(1) (exercicio 1): guarda tambem o
// ultimo no. Caso especial: quando o dequeue esvazia a fila, fim volta a null.

public class FilaFifo<T> {
    private No<T> inicio = null;
    private No<T> fim    = null;

    public boolean isEmpty() {
        return this.inicio == null;
    }

    public void enqueue(T elemento) {
        No<T> novo = new No<>(elemento);
        if (this.inicio == null) {
            this.inicio = novo;
        } else {
            this.fim.setProximo(novo);
        }
        this.fim = novo;
    }

    public T dequeue() {
        if (this.inicio == null) {
            return null;
        }
        No<T> primeiro = this.inicio;
        this.inicio = primeiro.getProximo();
        if (this.inicio == null) {
            this.fim = null;
        }
        primeiro.setProximo(null);
        return primeiro.getValor();
    }
}
