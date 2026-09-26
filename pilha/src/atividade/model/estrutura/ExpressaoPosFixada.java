package model.estrutura;

public class ExpressaoPosFixada {

    public double avaliar(String expressao) throws Exception {
        if (expressao == null || expressao.trim().isEmpty()) {
            throw new IllegalArgumentException("A expressão não pode ser vazia.");
        }

        Stack<Double> pilha = new Stack<>();
        String[] tokens = expressao.trim().split("\\s+");

        for (String token : tokens) {
            if (ehOperador(token)) {
                Double b = pilha.pop();
                Double a = pilha.pop();

                if (a == null || b == null) {
                    throw new IllegalStateException("Expressão malformada: faltam operandos para o operador '" + token + "'.");
                }

                double resultado = executarOperacao(a, b, token);
                pilha.push(resultado);
            } else {
                try {
                    double numero = Double.parseDouble(token);
                    pilha.push(numero);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Símbolo inválido na expressão: " + token);
                }
            }
        }

        Double resultadoFinal = pilha.pop();
        if (resultadoFinal == null) {
            throw new IllegalStateException("Expressão malformada: nenhum resultado gerado.");
        }

        if (pilha.pop() != null) {
            throw new IllegalStateException("Expressão malformada: operandos em excesso.");
        }

        return resultadoFinal;
    }

    private boolean ehOperador(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    private double executarOperacao(double a, double b, String operador) {
        switch (operador) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                if (b == 0.0) {
                    throw new ArithmeticException("Divisão por zero.");
                }
                return a / b;
            default:
                throw new UnsupportedOperationException("Operador desconhecido: " + operador);
        }
    }
}
