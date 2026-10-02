package view;

import controller.BuscaBinariaController;

public class BuscaBinaria {
    public static void main(String[] args) {
        int[] vetor = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
        BuscaBinariaController busca = new BuscaBinariaController();

        System.out.println("iterativa, 23 -> " + busca.buscar(vetor, 23));
        System.out.println("iterativa, 40 -> " + busca.buscar(vetor, 40));
        System.out.println("recursiva, 23 -> " + busca.buscarRecursivo(vetor, 23));
        System.out.println("recursiva, 91 -> " + busca.buscarRecursivo(vetor, 91));
    }
}
