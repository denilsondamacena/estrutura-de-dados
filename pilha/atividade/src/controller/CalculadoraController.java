package controller;

import model.estrutura.ExpressaoPosFixada;

public class CalculadoraController {

    private ExpressaoPosFixada expressaoModel;

    public CalculadoraController() {
        this.expressaoModel = new ExpressaoPosFixada();
    }

    public String calcular(String expressao) throws Exception {
        double resultado = this.expressaoModel.avaliar(expressao);
        return String.valueOf(resultado);
    }
}
