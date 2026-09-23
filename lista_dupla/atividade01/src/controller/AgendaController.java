package controller;

import model.estrutura.ListaAgenda;

public class AgendaController {
    private ListaAgenda listaAgenda;

    public AgendaController() {
        this.listaAgenda = new ListaAgenda();
    }

    public void adicionarPessoa(String nome) {
        listaAgenda.adicionar(nome);
    }

    public boolean localizarPessoa(String nome) {
        return listaAgenda.localizar(nome);
    }

    public boolean removerPessoa(String nome) {
        return listaAgenda.remover(nome);
    }

    public void exibirLista() {
        listaAgenda.exibirEstrutura();
    }
}
