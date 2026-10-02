package controller;

public class BuscaBinariaController {
    public BuscaBinariaController() {
        super();
    }

    public int buscar(int[] vetor, int chave) {
        int inicio = 0;
        int fim = vetor.length - 1;
        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;
            if (vetor[meio] == chave)
                return meio;
            else if (chave < vetor[meio])
                fim = meio - 1;
            else
                inicio = meio + 1;
        }
        return -1;
    }

    public int buscarRecursivo(int[] vetor, int chave) {
        return buscar(vetor, chave, 0, vetor.length - 1);
    }

    private int buscar(int[] vetor, int chave, int inicio, int fim) {
        if (inicio > fim)
            return -1;
        int meio = (inicio + fim) / 2;
        if (vetor[meio] == chave)
            return meio;
        else if (chave < vetor[meio])
            return buscar(vetor, chave, inicio, meio - 1);
        else
            return buscar(vetor, chave, meio + 1, fim);
    }
}
