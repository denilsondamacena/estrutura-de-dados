package view;

import controller.CalculadoraController;

public class CalculadoraView {

    public static void main(String[] args) {
        CalculadoraController controller = new CalculadoraController();

        String[] expressoes = {
            "3 4 +",            // Válida: 3 + 4 = 7.0
            "3 4 + 5 *",        // Válida: (3 + 4) * 5 = 35.0
            "15 7 1 1 + - /",   // Válida: 15 / (7 - (1 + 1)) = 3.0
            "3 +",              // Malformada: falta operando
            "5 2 3 +",          // Malformada: sobram operandos
            "10 0 /"            // Divisão por zero
        };

        for (String exp : expressoes) {
            try {
                String resultado = controller.calcular(exp);
                System.out.println("Expressão: \"" + exp + "\"  =>  Resultado: " + resultado);
            } catch (Exception e) {
                System.out.println("Expressão: \"" + exp + "\"  =>  Erro: " + e.getMessage());
            }
        }
    }
}
