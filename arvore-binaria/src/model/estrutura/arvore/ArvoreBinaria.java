package model.estrutura.arvore;

import model.estrutura.lista.ListaEncadeadaSimples;

public class ArvoreBinaria<T extends Comparable<T>> {

    private No<T> raiz;
    private int tamanho = 0;

    //add: Adiciona um novo No na arvore;
    //ordem: Retorna uma lista encadeada de elementos na ordem
    //preOrdem: Retorna uma lista encadeada de elementos na pre-ordem
    //posOrdem: Retorna uma lista encadeada de elementos na pos-ordem
    //remove: Remove um elemento da arvore

    public ArvoreBinaria() {
        this.raiz = null;
    }

    public void add(T valor) {
        No<T> novo = new No<T>(valor);
        tamanho++;
        if (raiz == null) {
            this.raiz = novo;
            return;
        }

        No<T> atual = this.raiz;
        while(true) {
            if (novo.getValor().compareTo(atual.getValor()) < 0) {
                if (atual.getMenor() != null) {
                    atual = atual.getMenor();
                } else {
                    atual.setMenor( novo );
                    break;
                }
            } else {
                if (atual.getMaior() != null) {
                    atual = atual.getMaior();
                } else {
                    atual.setMaior( novo );
                    break;
                }
            }
        }
    }

    public ListaEncadeadaSimples<T> ordem() {
        ListaEncadeadaSimples<T> lista = new ListaEncadeadaSimples<>();
        No<T> atual = this.raiz;
        ordem( atual, lista );
        return lista;
    }
    public ListaEncadeadaSimples<T> preOrdem() {
        ListaEncadeadaSimples<T> lista = new ListaEncadeadaSimples<>();
        No<T> atual = this.raiz;
        preOrdem( atual, lista );
        return lista;
    }
    public ListaEncadeadaSimples<T> posOrdem() {
        ListaEncadeadaSimples<T> lista = new ListaEncadeadaSimples<>();
        No<T> atual = this.raiz;
        posOrdem( atual, lista );
        return lista;
    }

    private void ordem(No<T> atual, ListaEncadeadaSimples<T> lista) {
        if (atual != null) {
            ordem(atual.getMenor(), lista );
            lista.append( atual.getValor() );
            ordem(atual.getMaior(), lista );
        }
    }

    private void preOrdem(No<T> atual, ListaEncadeadaSimples<T> lista) {
        if (atual != null) {
            lista.append( atual.getValor() );
            preOrdem(atual.getMenor(), lista );
            preOrdem(atual.getMaior() , lista );
        }
    }

    private void posOrdem(No<T> atual, ListaEncadeadaSimples<T> lista) {
        if (atual != null) {
            posOrdem(atual.getMenor(), lista );
            posOrdem(atual.getMaior() , lista );
            lista.append( atual.getValor() );
        }
    }

    public boolean remove(T valor) {
        //buscar o No na árvore
        No<T> atual = this.raiz;
        No<T> paiAtual = null;
        while(atual != null) {
            if (atual.getValor().equals(valor)) {
                break;
            }else if (valor.compareTo(atual.getValor()) < 0){ //valor procurado
                    //é menor que o atual
                paiAtual = atual;
                atual = atual.getMenor();
            }else{
                paiAtual = atual;
                atual = atual.getMaior();
            }
        }

        //verifica se existe o No
        if (atual == null)
            return false;

        //No tem 2 filhos ou No tem somente filho à direita
        if (atual.getMaior() != null) {
            No<T> substituto = atual.getMaior();
            No<T> paiSubstituto = atual;
            while(substituto.getMenor() != null) {
                paiSubstituto = substituto;
                substituto = substituto.getMenor();
            }
            substituto.setMenor(atual.getMenor());
            if (paiAtual != null) {
                // não é a raiz: o pai passa a apontar para o substituto
                if (atual.getValor().compareTo(paiAtual.getValor()) < 0) {
                    //atual < paiAtual
                    paiAtual.setMenor(substituto);
                } else {
                    paiAtual.setMaior(substituto);
                }
            } else {
                //se não tem paiAtual, então é a raiz
                this.raiz = substituto;
            }

            //removeu o No da árvore: se o substituto veio do fundo do ramo,
            //o pai dele herda o filho maior do substituto, e o substituto
            //herda o ramo maior do No removido
            if (paiSubstituto != atual) {
                paiSubstituto.setMenor(substituto.getMaior());
                substituto.setMaior(atual.getMaior());
            }

        } else if (atual.getMenor() != null) {
            //tem filho só à esquerda
            No<T> substituto = atual.getMenor();
            No<T> paiSubstituto = atual;
            while(substituto.getMaior() != null){
                paiSubstituto = substituto;
                substituto = substituto.getMaior();
            }
            if (paiAtual != null) {
                if (atual.getValor().compareTo(paiAtual.getValor()) < 0) {
                    //atual < paiAtual
                    paiAtual.setMenor(substituto);
                } else {
                    paiAtual.setMaior(substituto);
                }
            } else {
                //se for a raiz
                this.raiz = substituto;
            }

            //removeu o No da árvore: espelho do caso anterior
            if (paiSubstituto != atual){
                paiSubstituto.setMaior(substituto.getMenor());
                substituto.setMenor(atual.getMenor());
            }

        } else { //não tem filho
            if (paiAtual != null) {
                if (atual.getValor().compareTo(paiAtual.getValor()) < 0)
                { //atual < paiAtual
                    paiAtual.setMenor(null);
                } else {
                    paiAtual.setMaior(null);
                }
            } else { //é a raiz
                this.raiz = null;
            }
        }

        tamanho--;
        return true;
    }
}
