package controller;

import model.estrutura.ListaEncadeadaSimples;
import model.estrutura.No;

public class ListaController {
    private ListaEncadeadaSimples<Integer> lista;

    public ListaController() {
        this.lista = new ListaEncadeadaSimples<>();
    }

    public void adicionarNoFim(Integer valor) {
        lista.inserirFim(valor);
    }

    public void adicionarNaOrdem(Integer valor) {
        lista.inserirNaOrdem(valor);
    }

    public void ordenarLista() {
        if (lista.getTotal() == 0) {
            throw new IllegalArgumentException("Não é possível ordenar uma lista vazia.");
        }

        No<Integer> inicio = lista.getInicio();
        if (inicio.getProximo() == null) {
            return;
        }

        boolean trocou;
        do {
            trocou = false;
            No<Integer> atual = inicio;

            while (atual.getProximo() != null) {
                if (atual.getValor().compareTo(atual.getProximo().getValor()) > 0) {
                    Integer temp = atual.getValor();
                    atual.setValor(atual.getProximo().getValor());
                    atual.getProximo().setValor(temp);
                    trocou = true;
                }
                atual = atual.getProximo();
            }
        } while (trocou);
    }

    public Integer[] exportarParaArray() {
        return lista.toArray(Integer.class);
    }

    public void exibirLista() {
        lista.imprimir();
    }
}
