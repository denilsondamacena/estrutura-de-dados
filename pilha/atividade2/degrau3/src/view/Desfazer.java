package view;

import controller.Agente;
import model.Mensagem;

public class Desfazer {
    public static void main(String[] args) {
        String[] conversa = {
            "/escreve Estrutura",
            "/escreve de",
            "/escreve Dados",
            "/escreve com",
            "/salva",
            "/desfaz",
            "/escreve com",
            "/escreve Java",
            "/desfaz",
            "/desfaz",
            "/refaz",
            "/escreve Python",
            "/refaz",
        };
        Agente agente = new Agente();
        for (int i = 0; i < conversa.length; i++)
            agente.receber(new Mensagem(i + 1, conversa[i]));
        agente.processarTudo();
    }
}
