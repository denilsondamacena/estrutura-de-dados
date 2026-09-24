package view;

import controller.AgendaController;

public class MainView {
    public static void main(String[] args) {
        AgendaController controller = new AgendaController();

        System.out.println("=== 1. INSERINDO ELEMENTOS ===");
        controller.adicionarPessoa("Jose");
        controller.adicionarPessoa("Abel");
        controller.adicionarPessoa("Otavio");
        controller.adicionarPessoa("Angelo");
        controller.adicionarPessoa("Joao");
        controller.adicionarPessoa("Arnaldo");
        controller.adicionarPessoa("Odair");
        controller.adicionarPessoa("Juan");

        System.out.println("\n=== 2. ESTRUTURA RESULTANTE ===");
        controller.exibirLista();

        System.out.println("\n=== 3. BUSCA DE ELEMENTOS ===");
        System.out.println("Localizar 'Jose': " + (controller.localizarPessoa("Jose") ? "Encontrado" : "Não encontrado"));
        System.out.println("Localizar 'Marcos': " + (controller.localizarPessoa("Marcos") ? "Encontrado" : "Não encontrado"));

        System.out.println("\n=== 4. REMOÇÃO PONTUAL ('Jose') ===");
        controller.removerPessoa("Jose");
        controller.exibirLista();

        System.out.println("\n=== 5. REMOÇÃO COMPLETA DE UMA LETRA ('Odair' e 'Otavio') ===");
        controller.removerPessoa("Odair");
        controller.removerPessoa("Otavio");
        controller.exibirLista();
    }
}
