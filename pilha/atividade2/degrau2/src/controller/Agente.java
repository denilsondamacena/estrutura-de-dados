package controller;

import model.Mensagem;
import model.estrutura.FilaFifo;
import model.estrutura.Stack;

public class Agente {

    private FilaFifo<Mensagem> entrada = new FilaFifo<>();
    private Stack<String> desfazer = new Stack<>();
    private StringBuilder anotacao = new StringBuilder();

    public void receber(Mensagem m) {
        this.entrada.enqueue(m);
    }

    public void processarTudo() {
        Mensagem m = this.entrada.dequeue();
        while (m != null) {
            String resposta = this.processar(m.getTexto());
            System.out.println(String.format("m%02d %-18s| %-28s| %s",
                m.getNumero(), m.getTexto(), "\"" + this.anotacao + "\"", resposta).stripTrailing());
            m = this.entrada.dequeue();
        }
    }

    private String processar(String texto) {
        if (texto.startsWith("/escreve ")) {
            String palavra = texto.substring(9);
            if (this.anotacao.length() > 0)
                this.anotacao.append(" ");
            this.anotacao.append(palavra);
            this.desfazer.push(palavra);
            return "";
        }
        String palavra = this.desfazer.pop();     // /desfaz
        if (palavra == null)
            return "nada a desfazer";
        int tamanho = this.anotacao.length() - palavra.length();
        if (tamanho > 0)
            tamanho--;                            // o espaco antes da palavra
        this.anotacao.setLength(tamanho);
        return "";
    }
}
