package controller;

import model.estrutura.TabelaHash;

public class TabelaHashController {
    public TabelaHashController() {
        super();
    }

    public TabelaHash<String> teste() {
        TabelaHash<String> agenda = new TabelaHash<String>(8);
        agenda.put("ana", "3251-0001");
        agenda.put("bruno", "3251-0002");
        agenda.put("carla", "3251-0003");
        return agenda;
    }
}
