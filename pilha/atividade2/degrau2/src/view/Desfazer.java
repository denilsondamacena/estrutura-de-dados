package view;

import controller.Agente;
import model.Mensagem;

public class Desfazer {
    public static void main(String[] args) {
        String[] conversa = {
            "/desfaz",
            "/escreve Eu",
            "/escreve gosto",
            "/escreve de",
            "/escreve Java",
            "/desfaz",
            "/desfaz",
            "/escreve muito",
            "/escreve de",
            "/escreve pilhas",
        };
        Agente agente = new Agente();
        for (int i = 0; i < conversa.length; i++)
            agente.receber(new Mensagem(i + 1, conversa[i]));
        agente.processarTudo();
    }
}
