package model.estrutura.grafo;

import java.util.HashMap;
import java.util.Map;

public class GrafoMatriz {
    private int[][] matriz;
    private String[] labels;
    private Map<String, Integer> indice;

    public GrafoMatriz(String[] labels) {
        this.labels = labels;
        this.matriz = new int[labels.length][labels.length];
        this.indice = new HashMap<String, Integer>();
        for (int i = 0; i < labels.length; i++)
            this.indice.put(labels[i], i);
    }

    public void link(String label1, String label2) {
        int i = this.indice.get(label1);
        int j = this.indice.get(label2);
        this.matriz[i][j] = 1;
        this.matriz[j][i] = 1;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < this.labels.length; i++) {
            builder.append(this.labels[i]).append(": ");
            for (int j = 0; j < this.labels.length; j++)
                if (this.matriz[i][j] == 1)
                    builder.append(this.labels[j]).append(" ");
            builder.append("\r\n");
        }
        return builder.toString();
    }
}
