package controller;

import model.Mensagem;
import model.estrutura.FilaFifo;
import model.estrutura.Stack;

public class Agente {
    public static final int LIMITE = 3;

    private FilaFifo<Mensagem> entrada = new FilaFifo<>();
    private Stack<String> desfazer = new Stack<>();
    private Stack<String> refazer = new Stack<>();
    private StringBuilder anotacao = new StringBuilder();

    public void receber(Mensagem m) {
        this.entrada.enqueue(m);
    }

    public void processarTudo() {
        while (!this.entrada.isEmpty()) {
            Mensagem m = this.entrada.dequeue();
            String resultado = this.processar(m.getTexto());
            System.out.println(String.format("m%02d %-20s| %-32s| D=%d R=%d  %s",
                m.getNumero(), m.getTexto(), "\"" + this.anotacao + "\"",
                this.desfazer.tamanho(), this.refazer.tamanho(), resultado).stripTrailing());
        }
    }

    private String processar(String texto) {
        if (texto.startsWith("/escreve "))
            return this.escreve(texto.substring("/escreve ".length()));
        if (texto.equals("/desfaz"))
            return this.desfaz();
        if (texto.equals("/refaz"))
            return this.refaz();
        return this.salva();
    }

    private String escreve(String palavra) {
        if (this.desfazer.tamanho() >= LIMITE)
            return "historico cheio - use /salva";
        this.acrescentar(palavra);
        this.desfazer.push(palavra);
        this.refazer.limpar();          // escrita nova invalida o que estava no refazer
        return "";
    }

    private String desfaz() {
        String palavra = this.desfazer.pop();
        if (palavra == null)
            return "nada a desfazer";
        this.retirar(palavra);
        this.refazer.push(palavra);
        return "";
    }

    private String refaz() {
        String palavra = this.refazer.pop();
        if (palavra == null)
            return "nada a refazer";
        this.acrescentar(palavra);
        this.desfazer.push(palavra);
        return "";
    }

    private String salva() {
        this.desfazer.limpar();
        this.refazer.limpar();
        return "salvo";
    }

    private void acrescentar(String palavra) {
        if (this.anotacao.length() > 0)
            this.anotacao.append(" ");
        this.anotacao.append(palavra);
    }

    // tira a ultima palavra (e o espaco antes dela, se houver)
    private void retirar(String palavra) {
        int novo = this.anotacao.length() - palavra.length();
        if (novo > 0)
            novo--;
        this.anotacao.setLength(novo);
    }
}
