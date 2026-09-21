package view;

import controller.SiteController;
import java.io.File;
import java.util.ArrayList;
import model.SiteModel;

public class SiteView {
    public static void main(String[] args) {
        try {
            String diretorioRaiz = "site_teste";
            montarSiteTeste(diretorioRaiz);

            SiteModel model = new SiteModel(diretorioRaiz);
            SiteController controller = new SiteController(model);
            controller.processar();

            System.out.println("\n[1] PAGINAS ALCANCAVEIS A PARTIR DO INDEX.HTML:");
            ArrayList<String> alc = model.getPaginasAlcancaveis();
            ArrayList<Integer> profs = model.getProfundidades();
            for (int i = 0; i < alc.size(); i++) {
                System.out.println(" -> " + new File(alc.get(i)).getName() + " | Profundidade (Cliques): " + profs.get(i));
            }

            // 2. Páginas órfãs
            System.out.println("\n[2] PAGINAS ORFAS (Existem no disco, mas nao referenciadas):");
            ArrayList<String> orfas = model.getPaginasOrfas();
            if (orfas.isEmpty()) {
                System.out.println(" (Nenhuma pagina orfa encontrada)");
            } else {
                for (int i = 0; i < orfas.size(); i++) {
                    System.out.println(" -> " + new File(orfas.get(i)).getName());
                }
            }

            // 3. Links quebrados
            System.out.println("\n[3] LINKS QUEBRADOS (Referencias inexistentes):");
            ArrayList<String> origens = model.getLinksQuebradosOrigem();
            ArrayList<String> destinos = model.getLinksQuebradosDestino();
            if (origens.isEmpty()) {
                System.out.println(" (Nenhum link quebrado encontrado)");
            } else {
                for (int i = 0; i < origens.size(); i++) {
                    System.out.println(" Na pagina [" + new File(origens.get(i)).getName() + "] -> Aponta para inexistente: [" + destinos.get(i) + "]");
                }
            }

            // 4. Ciclo
            System.out.println("\n[4] CICLO ENCONTRADO:");
            ArrayList<String> ciclo = model.getCaminhoCiclo();
            if (ciclo.isEmpty()) {
                System.out.println(" (Nenhum ciclo encontrado)");
            } else {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < ciclo.size(); i++) {
                    sb.append(new File(ciclo.get(i)).getName());
                    if (i < ciclo.size() - 1) sb.append(" -> ");
                }
                System.out.println(" " + sb.toString());
            }

            // 5. Cadeia mais profunda
            System.out.println("\n[5] CADEIA MAIS PROFUNDA A PARTIR DO INDEX.HTML:");
            ArrayList<String> cadeia = model.getCadeiaMaisProfunda();
            StringBuilder sbCadeia = new StringBuilder();
            for (int i = 0; i < cadeia.size(); i++) {
                sbCadeia.append(new File(cadeia.get(i)).getName());
                if (i < cadeia.size() - 1) sbCadeia.append(" -> ");
            }
            System.out.println(" " + sbCadeia.toString());

        } catch (Exception e) {
            System.err.println("Erro durante a execucao do programa: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Método auxiliar para gerar automaticamente o site de teste exigido nas regras
    private static void montarSiteTeste(String caminhoRaiz) {
        try {
            File raiz = new File(caminhoRaiz);
            if (!raiz.exists()) {
                raiz.mkdir();
            }

            File subDir = new File(raiz, "conteudo");
            if (!subDir.exists()) {
                subDir.mkdir();
            }

            // 1. index.html (Raiz) -> Aponta para pagina_a.html, pagina_b.html e link quebrado
            java.nio.file.Files.write(new File(raiz, "index.html").toPath(), 
                "<html><body><a href='pagina_a.html'>A</a> <a href='conteudo/pagina_b.html'>B</a> <a href='inexistente.html'>Quebrado</a></body></html>".getBytes());

            // 2. pagina_a.html  Aponta para pagina_c.html 
            java.nio.file.Files.write(new File(raiz, "pagina_a.html").toPath(), 
                "<html><body><a href='pagina_c.html'>C</a> <a href='conteudo/pagina_b.html'>B Direto</a></body></html>".getBytes());

            // 3. conteudo/pagina_b.html 
            java.nio.file.Files.write(new File(subDir, "pagina_b.html").toPath(), 
                "<html><body>Pagina B em subdiretorio</body></html>".getBytes());

            // 4. pagina_c.html Fecha ciclo apontando de volta para index.html
            java.nio.file.Files.write(new File(raiz, "pagina_c.html").toPath(), 
                "<html><body><a href='index.html'>Voltar ao Index</a></body></html>".getBytes());

            // 5. orfao.html Página órfã (nenhum link aponta para ela)
            java.nio.file.Files.write(new File(raiz, "orfao.html").toPath(), 
                "<html><body>Sou uma pagina orfa</body></html>".getBytes());

        } catch (Exception e) {
            System.err.println("Aviso ao montar site de teste: " + e.getMessage());
        }
    }
}
