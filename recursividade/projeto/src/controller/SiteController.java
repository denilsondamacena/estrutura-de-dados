package controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.SiteModel;

public class SiteController {
    private SiteModel model;
    private static final Pattern LINK_PATTERN = Pattern.compile("<a\\s+[^>]*href\\s*=\\s*[\"']([^\"']+)[\"'][^>]*>", Pattern.CASE_INSENSITIVE);

    public SiteController(SiteModel model) {
        super();
        this.model = model;
    }

    public void processar() throws IOException {
        varrerDiretorio(new File(model.getRaizDir()));

        File indexFile = new File(model.getRaizDir(), "index.html");
        if (!indexFile.exists()) {
            throw new IOException("Arquivo index.html nao encontrado na raiz informada.");
        }

        String indexCaminho = indexFile.getCanonicalPath();
        ArrayList<String> trilhaAtual = new ArrayList<>();
        trilhaAtual.add(indexCaminho);

        analisarGrafoRecursivo(indexCaminho, 0, trilhaAtual);

        for (String arqDisco : model.getArquivosDisco()) {
            if (arqDisco.endsWith(".html") && !model.getPaginasAlcancaveis().contains(arqDisco)) {
                model.getPaginasOrfas().add(arqDisco);
            }
        }
    }

    private void varrerDiretorio(File diretorio) {
        File[] lista = diretorio.listFiles();
        if (lista != null) {
            for (int i = 0; i < lista.length; i++) {
                File f = lista[i];
                if (f.isDirectory()) {
                    varrerDiretorio(f);
                } else if (f.isFile() && f.getName().endsWith(".html")) {
                    try {
                        model.getArquivosDisco().add(f.getCanonicalPath());
                    } catch (IOException e) {
                    }
                }
            }
        }
    }

    private void analisarGrafoRecursivo(String paginaAtualPath, int profundidadeAtual, ArrayList<String> trilha) throws IOException {
        int idx = model.getPaginasAlcancaveis().indexOf(paginaAtualPath);
        if (idx == -1) {
            model.getPaginasAlcancaveis().add(paginaAtualPath);
            model.getProfundidades().add(profundidadeAtual);
        } else {
            int profRegistrada = model.getProfundidades().get(idx);
            if (profundidadeAtual < profRegistrada) {
                model.getProfundidades().set(idx, profundidadeAtual);
            }
        }

        if (trilha.size() > model.getCadeiaMaisProfunda().size()) {
            model.getCadeiaMaisProfunda().clear();
            for (int i = 0; i < trilha.size(); i++) {
                model.getCadeiaMaisProfunda().add(trilha.get(i));
            }
        }

        File arquivo = new File(paginaAtualPath);
        if (!arquivo.exists()) return;
        
        String conteudo = new String(Files.readAllBytes(arquivo.toPath()));
        Matcher matcher = LINK_PATTERN.matcher(conteudo);

        while (matcher.find()) {
            String linkRelativo = matcher.group(1);
            
            if (linkRelativo.startsWith("http://") || linkRelativo.startsWith("https://") || linkRelativo.startsWith("#")) {
                continue;
            }

            File arquivoDestino = new File(arquivo.getParentFile(), linkRelativo);
            String destinoCanonical;
            try {
                destinoCanonical = arquivoDestino.getCanonicalPath();
            } catch (IOException e) {
                continue;
            }

            if (!arquivoDestino.exists()) {
                if (!model.getLinksQuebradosOrigem().contains(paginaAtualPath) || 
                    !model.getLinksQuebradosDestino().get(model.getLinksQuebradosOrigem().indexOf(paginaAtualPath)).equals(linkRelativo)) {
                    model.getLinksQuebradosOrigem().add(paginaAtualPath);
                    model.getLinksQuebradosDestino().add(linkRelativo);
                }
                continue;
            }

            int posCiclo = trilha.indexOf(destinoCanonical);
            if (posCiclo != -1) {
                if (model.getCaminhoCiclo().isEmpty()) {
                    for (int i = posCiclo; i < trilha.size(); i++) {
                        model.getCaminhoCiclo().add(trilha.get(i));
                    }
                    model.getCaminhoCiclo().add(destinoCanonical);
                }
                continue;
            }

            trilha.add(destinoCanonical);
            analisarGrafoRecursivo(destinoCanonical, profundidadeAtual + 1, trilha);
            trilha.remove(trilha.size() - 1);
        }
    }
}
