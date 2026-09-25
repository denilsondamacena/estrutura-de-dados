package view;

import controller.ListaController;
import java.util.Arrays;

public class MainView {
    public static void main(String[] args) {
        ListaController controller = new ListaController();
        int[] sequencia = {8, 4, 7, 1, 0, 3, 5, 2};

        System.out.println("1. POPULANDO A LISTA (DESORDENADA)");
        try {
            for (int num : sequencia) {
                controller.adicionarNoFim(num);
            }
            System.out.print("Estado inicial da lista: ");
            controller.exibirLista();
        } catch (IllegalArgumentException e) {
            System.out.println("Erro capturado na inserção: " + e.getMessage());
        }

        System.out.println("\n2. ORDENANDO A LISTA VIA CONTROLLER");
        try {
            controller.ordenarLista();
            System.out.print("Lista após ordenação: ");
            controller.exibirLista();
        } catch (IllegalArgumentException e) {
            System.out.println("Erro na ordenação: " + e.getMessage());
        }

        System.out.println("\n3. CONVERTENDO PARA ARRAY (toArray)");
        try {
            Integer[] vetor = controller.exportarParaArray();
            System.out.println("Array gerado com sucesso: " + Arrays.toString(vetor));
        } catch (IllegalArgumentException e) {
            System.out.println("Erro na conversão para array: " + e.getMessage());
        }

        System.out.println("\n4. TESTANDO INSERÇÃO DIRETA NA ORDEM");
        ListaController controllerOrdenado = new ListaController();
        try {
            for (int num : sequencia) {
                controllerOrdenado.adicionarNaOrdem(num);
            }
            System.out.print("Lista preenchida com inserirNaOrdem(): ");
            controllerOrdenado.exibirLista();
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao inserir na ordem: " + e.getMessage());
        }

        System.out.println("\n5. TESTES DE TRATAMENTO DE EXCEÇÕES (TRY / CATCH)");

        try {
            System.out.println("Tentando inserir valor nulo...");
            controllerOrdenado.adicionarNaOrdem(null);
        } catch (IllegalArgumentException e) {
            System.out.println("-> Sucesso: Exceção capturada com a mensagem: \"" + e.getMessage() + "\"");
        }

        try {
            System.out.println("Tentando ordenar uma lista vazia...");
            ListaController controllerVazio = new ListaController();
            controllerVazio.ordenarLista();
        } catch (IllegalArgumentException e) {
            System.out.println("-> Sucesso: Exceção capturada com a mensagem: \"" + e.getMessage() + "\"");
        }
    }
}
