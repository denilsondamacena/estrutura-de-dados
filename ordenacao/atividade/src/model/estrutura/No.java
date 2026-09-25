package model.estrutura;

public class No<T> {
    private T valor;
    private No<T> proximo;

    public No(T valor) {
        if (valor == null) {
            throw new IllegalArgumentException("O valor do nó não pode ser nulo.");
        }
        this.valor = valor;
        this.proximo = null;
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        if (valor == null) {
            throw new IllegalArgumentException("O valor do nó não pode ser nulo.");
        }
        this.valor = valor;
    }

    public No<T> getProximo() {
        return proximo;
    }

    public void setProximo(No<T> proximo) {
        this.proximo = proximo;
    }
}
