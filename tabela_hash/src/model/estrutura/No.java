package model.estrutura;

public class No<T> {
    private String chave;
    private T valor;
    private No<T> proximo;

    public No(String chave, T valor) {
        this.chave = chave;
        this.valor = valor;
        this.proximo = null;
    }

    public String getChave() { return this.chave; }
    public T getValor() { return this.valor; }
    public void setValor(T valor) { this.valor = valor; }
    public No<T> getProximo() { return this.proximo; }
    public void setProximo(No<T> proximo) { this.proximo = proximo; }
}
