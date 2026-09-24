package view;

import controller.ListaController;

public class MainView {
    public static void main(String[] args) {
        ListaController controller = new ListaController();

        System.out.println("=== 1. INSERINDO NOMES DESORDENADOS ===");
        controller.inserir("Bruno");
        controller.inserir("amanda");
        controller.inserir("Carlos");
        controller.inserir("diego");
        controller.inserir("Beatriz");

        System.out.println("Total de elementos: " + controller.obterTotal());

        System.out.println("\n=== 2. IMPRESSÃO EM ORDEM CRESCENTE ===");
        controller.listarCrescente();

        System.out.println("\n=== 3. IMPRESSÃO EM ORDEM DECRESCENTE ===");
        controller.listarDecrescente();

        System.out.println("\n=== 4. TESTES DE REMOÇÃO ===");
        System.out.println("Removendo 'amanda' (primeiro): " + controller.remover("amanda"));
        System.out.println("Removendo 'diego' (último): " + controller.remover("diego"));
        System.out.println("Removendo 'Bruno' (meio): " + controller.remover("Bruno"));

        System.out.println("\n=== 5. ESTADO FINAL DA LISTA ===");
        System.out.println("Total restante: " + controller.obterTotal());
        controller.listarCrescente();
        controller.listarDecrescente();
    }
}
