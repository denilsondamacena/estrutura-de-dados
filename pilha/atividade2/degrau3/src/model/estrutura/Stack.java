package model.estrutura;

/*
 * Stack do cap. 5 com as consultas do exercicio 3.
 *
 * push:    empilha no topo
 * pop:     desempilha do topo (null se vazia)
 * tamanho: quantos elementos -- O(1) pelo contador, sem percorrer
 * limpar:  desempilha tudo
 *
 * Serve as duas pilhas do agente. O limite do desfazer NAO mora aqui: quem o
 * aplica e o agente, consultando tamanho() antes do push. Pilha cheia recusa;
 * jogar fora o fundo exigiria tirar pelo lado oposto ao que entrou, e isso ja
 * nao seria pilha (seria o deque do cap. 5).
 */
public class Stack<T> {
    private No<T> ultimo = null;
    private int tamanho = 0;

    public boolean isEmpty() {
        return this.ultimo == null;
    }

    public int tamanho() {
        return this.tamanho;
    }

    public void push(T elemento) {
        No<T> novo = new No<>(elemento);
        novo.setAnterior(this.ultimo);
        this.ultimo = novo;
        this.tamanho++;
    }

    public T pop() {
        if (this.ultimo == null)
            return null;
        No<T> elemento = this.ultimo;
        this.ultimo = elemento.getAnterior();
        elemento.setAnterior(null);
        this.tamanho--;
        return elemento.getValor();
    }

    public void limpar() {
        while (!this.isEmpty())
            this.pop();
    }
}
