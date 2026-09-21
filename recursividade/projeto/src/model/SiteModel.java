package model;

import java.util.ArrayList;

public class SiteModel {
    private String raizDir;
    private ArrayList<String> arquivosDisco;
    private ArrayList<String> paginasAlcancaveis;
    private ArrayList<Integer> profundidades;
    private ArrayList<String> paginasOrfas;
    private ArrayList<String> linksQuebradosOrigem;
    private ArrayList<String> linksQuebradosDestino;
    private ArrayList<String> caminhoCiclo;
    private ArrayList<String> cadeiaMaisProfunda;

    public SiteModel(String raizDir) {
        super();
        this.raizDir = raizDir;
        this.arquivosDisco = new ArrayList<>();
        this.paginasAlcancaveis = new ArrayList<>();
        this.profundidades = new ArrayList<>();
        this.paginasOrfas = new ArrayList<>();
        this.linksQuebradosOrigem = new ArrayList<>();
        this.linksQuebradosDestino = new ArrayList<>();
        this.caminhoCiclo = new ArrayList<>();
        this.cadeiaMaisProfunda = new ArrayList<>();
    }

    public String getRaizDir() {
        return raizDir;
    }

    public ArrayList<String> getArquivosDisco() {
        return arquivosDisco;
    }

    public ArrayList<String> getPaginasAlcancaveis() {
        return paginasAlcancaveis;
    }

    public ArrayList<Integer> getProfundidades() {
        return profundidades;
    }

    public ArrayList<String> getPaginasOrfas() {
        return paginasOrfas;
    }

    public ArrayList<String> getLinksQuebradosOrigem() {
        return linksQuebradosOrigem;
    }

    public ArrayList<String> getLinksQuebradosDestino() {
        return linksQuebradosDestino;
    }

    public ArrayList<String> getCaminhoCiclo() {
        return caminhoCiclo;
    }

    public ArrayList<String> getCadeiaMaisProfunda() {
        return cadeiaMaisProfunda;
    }
}
