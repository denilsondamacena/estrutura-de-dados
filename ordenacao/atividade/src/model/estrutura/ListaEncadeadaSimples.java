package model.estrutura;

import java.lang.reflect.Array;

public class ListaEncadeadaSimples<T extends Comparable<T>> {
    private No<T> inicio;
    private int total;

    public ListaEncadeadaSimples() {
        this.inicio = null;
        this.total = 0;
    }

    public No<T> getInicio() {
        return inicio;
    }

    public void setInicio(No<T> inicio) {
        this.inicio = inicio;
        int count = 0;
        No<T> aux = inicio;
        while (aux != null) {
            count++;
            aux = aux.getProximo();
        }
        this.total = count;
    }

    public int getTotal() {
        return total;
    }

    public void inserirFim(T valor) {
        if (valor == null) {
            throw new IllegalArgumentException("O valor a ser inserido não pode ser nulo.");
        }

        No<T> novo = new No<>(valor);
        if (inicio == null) {
            inicio = novo;
        } else {
            No<T> atual = inicio;
            while (atual.getProximo() != null) {
                atual = atual.getProximo();
            }
            atual.setProximo(novo);
        }
        total++;
    }

    public void inserirNaOrdem(T valor) {
        if (valor == null) {
            throw new IllegalArgumentException("O valor para ordenação não pode ser nulo.");
        }

        No<T> novo = new No<>(valor);

        if (inicio == null || valor.compareTo(inicio.getValor()) < 0) {
            novo.setProximo(inicio);
            inicio = novo;
            total++;
            return;
        }

        No<T> atual = inicio;
        while (atual.getProximo() != null && atual.getProximo().getValor().compareTo(valor) < 0) {
            atual = atual.getProximo();
        }

        novo.setProximo(atual.getProximo());
        atual.setProximo(novo);
        total++;
    }

    public T[] toArray(Class<T> clazz) {
        if (clazz == null) {
            throw new IllegalArgumentException("A classe do tipo não pode ser nula.");
        }

        T[] array = clazz.cast(Array.newInstance(clazz, this.total));
        No<T> atual = inicio;
        int i = 0;

        while (atual != null) {
            array[i++] = atual.getValor();
            atual = atual.getProximo();
        }

        return array;
    }

    public void imprimir() {
        if (inicio == null) {
            System.out.println("Lista vazia.");
            return;
        }

        No<T> atual = inicio;
        while (atual != null) {
            System.out.print(atual.getValor() + (atual.getProximo() != null ? " -> " : " -> null\n"));
            atual = atual.getProximo();
        }
    }
}
