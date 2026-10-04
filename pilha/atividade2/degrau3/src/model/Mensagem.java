package model;

public class Mensagem {
    private int numero;
    private String texto;

    public Mensagem(int numero, String texto) {
        this.numero = numero;
        this.texto = texto;
    }

    public int getNumero() {
        return numero;
    }
    public String getTexto() {
        return texto;
    }
}
