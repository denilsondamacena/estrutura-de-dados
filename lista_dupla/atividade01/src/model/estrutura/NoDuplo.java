package model.estrutura;

public class NoDuplo {
    private char letra;
    private NoSimples inicioListaSimples;
    private NoDuplo anterior;
    private NoDuplo proximo;

    public NoDuplo(char letra) {
        this.letra = letra;
        this.inicioListaSimples = null;
        this.anterior = null;
        this.proximo = null;
    }

    public char getLetra() {
        return letra;
    }

    public NoSimples getInicioListaSimples() {
        return inicioListaSimples;
    }

    public void setInicioListaSimples(NoSimples inicioListaSimples) {
        this.inicioListaSimples = inicioListaSimples;
    }

    public NoDuplo getAnterior() {
        return anterior;
    }

    public void setAnterior(NoDuplo anterior) {
        this.anterior = anterior;
    }

    public NoDuplo getProximo() {
        return proximo;
    }

    public void setProximo(NoDuplo proximo) {
        this.proximo = proximo;
    }
}
