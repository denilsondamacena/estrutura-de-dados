package model.estrutura;

public class ListaAgenda {
    private NoDuplo inicio;

    public ListaAgenda() {
        this.inicio = null;
    }

    public void adicionar(String nome) {
        if (nome == null || nome.trim().isEmpty()) return;

        nome = nome.trim();
        char letra = Character.toUpperCase(nome.charAt(0));

        NoDuplo noLetra = obterOuCriarNoDuplo(letra);
        noLetra.setInicioListaSimples(inserirOrdenadoSimples(noLetra.getInicioListaSimples(), nome));
    }

    private NoDuplo obterOuCriarNoDuplo(char letra) {
        NoDuplo atual = inicio;
        NoDuplo anterior = null;

        while (atual != null && atual.getLetra() < letra) {
            anterior = atual;
            atual = atual.getProximo();
        }

        if (atual != null && atual.getLetra() == letra) {
            return atual;
        }

        NoDuplo novo = new NoDuplo(letra);

        if (anterior == null) {
            novo.setProximo(inicio);
            if (inicio != null) {
                inicio.setAnterior(novo);
            }
            inicio = novo;
        } else {
            novo.setProximo(atual);
            novo.setAnterior(anterior);
            anterior.setProximo(novo);
            if (atual != null) {
                atual.setAnterior(novo);
            }
        }

        return novo;
    }

    private NoSimples inserirOrdenadoSimples(NoSimples cabeca, String nome) {
        NoSimples novo = new NoSimples(nome);

        if (cabeca == null || nome.compareToIgnoreCase(cabeca.getNome()) < 0) {
            novo.setProximo(cabeca);
            return novo;
        }

        NoSimples atual = cabeca;
        while (atual.getProximo() != null && atual.getProximo().getNome().compareToIgnoreCase(nome) < 0) {
            atual = atual.getProximo();
        }

        novo.setProximo(atual.getProximo());
        atual.setProximo(novo);
        return cabeca;
    }

    public boolean localizar(String nome) {
        if (nome == null || nome.trim().isEmpty()) return false;

        char letra = Character.toUpperCase(nome.trim().charAt(0));

        NoDuplo atualDuplo = inicio;
        while (atualDuplo != null && atualDuplo.getLetra() < letra) {
            atualDuplo = atualDuplo.getProximo();
        }

        if (atualDuplo == null || atualDuplo.getLetra() != letra) {
            return false;
        }

        NoSimples atualSimples = atualDuplo.getInicioListaSimples();
        while (atualSimples != null) {
            if (atualSimples.getNome().equalsIgnoreCase(nome.trim())) {
                return true;
            }
            atualSimples = atualSimples.getProximo();
        }

        return false;
    }

    public boolean remover(String nome) {
        if (nome == null || nome.trim().isEmpty()) return false;

        char letra = Character.toUpperCase(nome.trim().charAt(0));

        NoDuplo noLetra = inicio;
        while (noLetra != null && noLetra.getLetra() < letra) {
            noLetra = noLetra.getProximo();
        }

        if (noLetra == null || noLetra.getLetra() != letra) {
            return false;
        }

        NoSimples atualSimples = noLetra.getInicioListaSimples();
        NoSimples anteriorSimples = null;
        boolean encontrado = false;

        while (atualSimples != null) {
            if (atualSimples.getNome().equalsIgnoreCase(nome.trim())) {
                encontrado = true;
                if (anteriorSimples == null) {
                    noLetra.setInicioListaSimples(atualSimples.getProximo());
                } else {
                    anteriorSimples.setProximo(atualSimples.getProximo());
                }
                break;
            }
            anteriorSimples = atualSimples;
            atualSimples = atualSimples.getProximo();
        }

        if (!encontrado) return false;

        if (noLetra.getInicioListaSimples() == null) {
            removerNoDuplo(noLetra);
        }

        return true;
    }

    private void removerNoDuplo(NoDuplo no) {
        if (no.getAnterior() != null) {
            no.getAnterior().setProximo(no.getProximo());
        } else {
            inicio = no.getProximo();
        }

        if (no.getProximo() != null) {
            no.getProximo().setAnterior(no.getAnterior());
        }

        no.setProximo(null);
        no.setAnterior(null);
    }

    public void exibirEstrutura() {
        if (inicio == null) {
            System.out.println("Lista vazia.");
            return;
        }

        NoDuplo atualDuplo = inicio;
        while (atualDuplo != null) {
            System.out.print("[ Letra " + atualDuplo.getLetra() + " ] -> ");
            NoSimples atualSimples = atualDuplo.getInicioListaSimples();
            while (atualSimples != null) {
                System.out.print(atualSimples.getNome() + (atualSimples.getProximo() != null ? " -> " : " -> [null]"));
                atualSimples = atualSimples.getProximo();
            }
            System.out.println();
            atualDuplo = atualDuplo.getProximo();
        }
    }
}
