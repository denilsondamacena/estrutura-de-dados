package model.estrutura;

public class TabelaHash<T> {
    private No<T>[] baldes;
    private int capacidade;

    public TabelaHash(int capacidade) {
        this.capacidade = capacidade;
        this.baldes = (No<T>[]) new No[capacidade];
    }

    private int hash(String chave) {
        int soma = 0;
        for (int i = 0; i < chave.length(); i++)
            soma = soma + chave.charAt(i);
        return Math.abs(soma) % this.capacidade;
    }

    public void put(String chave, T valor) {
        int indice = hash(chave);
        No<T> atual = this.baldes[indice];
        while (atual != null) {
            if (atual.getChave().equals(chave)) {
                atual.setValor(valor);
                return;
            }
            atual = atual.getProximo();
        }
        No<T> novo = new No<T>(chave, valor);
        novo.setProximo(this.baldes[indice]);
        this.baldes[indice] = novo;
    }

    public T get(String chave) {
        int indice = hash(chave);
        No<T> atual = this.baldes[indice];
        while (atual != null) {
            if (atual.getChave().equals(chave))
                return atual.getValor();
            atual = atual.getProximo();
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.capacidade; i++) {
            sb.append("[").append(i).append("] ");
            No<T> atual = this.baldes[i];
            while (atual != null) {
                sb.append(atual.getChave()).append("=").append(atual.getValor());
                atual = atual.getProximo();
                if (atual != null) sb.append(" -> ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
