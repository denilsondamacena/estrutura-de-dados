package model.estrutura;

public class ListaDupla<T> {
    private No<T> inicio;
    private No<T> fim;
    protected int total;

    public ListaDupla() {
        this.inicio = null;
        this.fim = null;
        this.total = 0;
    }

    public int getTotal() {
        return total;
    }

    private int comparar(T v1, T v2) {
        return v1.toString().compareToIgnoreCase(v2.toString());
    }

    public void inserirNaOrdem(T valor) {
        if (valor == null) return;

        No<T> novo = new No<>(valor);

        if (inicio == null) {
            inicio = novo;
            fim = novo;
            total++;
            return;
        }

        if (comparar(valor, inicio.getValor()) <= 0) {
            novo.setProximo(inicio);
            inicio.setAnterior(novo);
            inicio = novo;
            total++;
            return;
        }

        if (comparar(valor, fim.getValor()) >= 0) {
            novo.setAnterior(fim);
            fim.setProximo(novo);
            fim = novo;
            total++;
            return;
        }

        No<T> atual = inicio;
        while (atual != null && comparar(valor, atual.getValor()) > 0) {
            atual = atual.getProximo();
        }

        novo.setProximo(atual);
        novo.setAnterior(atual.getAnterior());
        atual.getAnterior().setProximo(novo);
        atual.setAnterior(novo);
        total++;
    }

    public void imprimirCrescente() {
        if (inicio == null) {
            System.out.println("Lista vazia.");
            return;
        }

        No<T> atual = inicio;
        System.out.print("Crescente: [inicio] <-> ");
        while (atual != null) {
            System.out.print(atual.getValor() + (atual.getProximo() != null ? " <-> " : " <-> [fim]"));
            atual = atual.getProximo();
        }
        System.out.println();
    }

    public void imprimirDecrescente() {
        if (fim == null) {
            System.out.println("Lista vazia.");
            return;
        }

        No<T> atual = fim;
        System.out.print("Decrescente: [fim] <-> ");
        while (atual != null) {
            System.out.print(atual.getValor() + (atual.getAnterior() != null ? " <-> " : " <-> [inicio]"));
            atual = atual.getAnterior();
        }
        System.out.println();
    }

    public boolean remover(T valor) {
        if (valor == null || inicio == null) return false;

        No<T> atual = inicio;
        while (atual != null && !atual.getValor().toString().equalsIgnoreCase(valor.toString())) {
            atual = atual.getProximo();
        }

        if (atual == null) {
            return false;
        }

        if (inicio == fim) {
            inicio = null;
            fim = null;
        } else if (atual == inicio) {
            inicio = inicio.getProximo();
            inicio.setAnterior(null);
        } else if (atual == fim) {
            fim = fim.getAnterior();
            fim.setProximo(null);
        } else {
            atual.getAnterior().setProximo(atual.getProximo());
            atual.getProximo().setAnterior(atual.getAnterior());
        }

        atual.setProximo(null);
        atual.setAnterior(null);
        total--;
        return true;
    }
}
