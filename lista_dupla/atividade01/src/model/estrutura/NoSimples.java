package model.estrutura;

public class NoSimples {
    private String nome;
    private NoSimples proximo;

    public NoSimples(String nome) {
        this.nome = nome;
        this.proximo = null;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public NoSimples getProximo() {
        return proximo;
    }

    public void setProximo(NoSimples proximo) {
        this.proximo = proximo;
    }
}
