package controller;

import model.estrutura.ListaDupla;

public class ListaController {
    private ListaDupla<String> lista;

    public ListaController() {
        this.lista = new ListaDupla<>();
    }

    public void inserir(String valor) {
        lista.inserirNaOrdem(valor);
    }

    public boolean remover(String valor) {
        return lista.remover(valor);
    }

    public void listarCrescente() {
        lista.imprimirCrescente();
    }

    public void listarDecrescente() {
        lista.imprimirDecrescente();
    }

    public int obterTotal() {
        return lista.getTotal();
    }
}
