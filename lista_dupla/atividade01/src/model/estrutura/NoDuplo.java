package model.estrutura;

public class NoDuplo<T> {
    private Character letra;
    private NoSimples<T> inicioListaSimples;
    private NoDuplo<T> anterior;
    private NoDuplo<T> proximo;

    public NoDuplo(Character letra) {
        this.letra = letra;
        this.inicioListaSimples = null;
        this.anterior = null;
        this.proximo = null;
    }

    public Character getLetra() {
        return letra;
    }

    public void setLetra(Character letra) {
        this.letra = letra;
    }

    public NoSimples<T> getInicioListaSimples() {
        return inicioListaSimples;
    }

    public void setInicioListaSimples(NoSimples<T> inicioListaSimples) {
        this.inicioListaSimples = inicioListaSimples;
    }

    public NoDuplo<T> getAnterior() {
        return anterior;
    }

    public void setAnterior(NoDuplo<T> anterior) {
        this.anterior = anterior;
    }

    public NoDuplo<T> getProximo() {
        return proximo;
    }

    public void setProximo(NoDuplo<T> proximo) {
        this.proximo = proximo;
    }
}
