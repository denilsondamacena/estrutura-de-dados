package view;

import controller.TabelaHashController;
import model.estrutura.TabelaHash;

public class Agenda {
    public static void main(String[] args) {
        TabelaHashController controller = new TabelaHashController();
        TabelaHash<String> agenda = controller.teste();

        System.out.print(agenda);
        System.out.println("busca ana -> " + agenda.get("ana"));
        System.out.println("busca davi -> " + agenda.get("davi"));
    }
}
