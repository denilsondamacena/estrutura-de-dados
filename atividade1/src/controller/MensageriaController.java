package controller;

import model.estrutura.No;
import model.estrutura.Pagina;

public class MensageriaController {
    private No<Pagina> p;
    private int totalNos;

    public MensageriaController() {
		super();
        this.p = null;
        this.totalNos = 0;
    }

    public boolean vazia() {
        return p == null;
    }

    public int total() {
        return totalNos;
    }

    public void adicionar(Pagina pagina) {
        No<Pagina> novo = new No<>(pagina);
        
        if (vazia()) {
            novo.setProximo(novo);
            novo.setAnterior(novo);
            p = novo;
        } else {
            No<Pagina> ultimo = p.getAnterior();
            
            ultimo.setProximo(novo);
            novo.setAnterior(ultimo);
            
            novo.setProximo(p);
            p.setAnterior(novo);
        }
        totalNos++;
    }

    public Pagina ler() throws IllegalArgumentException {
        if (vazia()) {
            throw new IllegalArgumentException("A fila está vazia. Não há páginas para ler.");
        }

        Pagina paginaRetorno = p.getValor();

        if (p.getProximo() == p) {
            p = null;
        } else {
            No<Pagina> anterior = p.getAnterior();
            No<Pagina> proximo = p.getProximo();

            anterior.setProximo(proximo);
            proximo.setAnterior(anterior);

            p = proximo;
        }

        totalNos--;
        return paginaRetorno;
    }
}
