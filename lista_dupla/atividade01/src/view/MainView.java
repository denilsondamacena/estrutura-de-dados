package view;

import controller.AgendaController;

public class MainView {
    public static void main(String[] args) {
        AgendaController controller = new AgendaController();

        System.out.println("=== 1. INSERINDO NOMES ===");
        controller.adicionarPessoa("Jose");
        controller.adicionarPessoa("Abel");
        controller.adicionarPessoa("Otavio");
        controller.adicionarPessoa("Angelo");
        controller.adicionarPessoa("Joao");
        controller.adicionarPessoa("Arnaldo");
        controller.adicionarPessoa("Odair");
        controller.adicionarPessoa("Juan");

        System.out.println("\n=== 2. ESTRUTURA ATUAL ===");
        controller.exibirLista();

        System.out.println("\n=== 3. TESTE DE BUSCA ===");
        System.out.println("Buscar 'Jose': " + (controller.localizarPessoa("Jose") ? "Encontrado" : "Não encontrado"));
        System.out.println("Buscar 'Carlos': " + (controller.localizarPessoa("Carlos") ? "Encontrado" : "Não encontrado"));

        System.out.println("\n=== 4. TESTE DE REMOÇÃO SIMPLES ===");
        System.out.println("Removendo 'Jose'...");
        controller.removerPessoa("Jose");
        controller.exibirLista();

        System.out.println("\n=== 5. REMOÇÃO COMPLETA DA LETRA O ===");
        System.out.println("Removendo 'Odair' e 'Otavio'...");
        controller.removerPessoa("Odair");
        controller.removerPessoa("Otavio");
        controller.exibirLista();
    }
}
