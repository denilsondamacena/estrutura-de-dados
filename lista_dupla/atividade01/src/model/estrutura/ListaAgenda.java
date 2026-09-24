package model.estrutura;

public class ListaAgenda<T> {
    private NoDuplo<T> inicio;

    public ListaAgenda() {
        this.inicio = null;
    }

    private char extrairLetra(T elemento) {
        return Character.toUpperCase(elemento.toString().trim().charAt(0));
    }

    public void adicionar(T elemento) {
        if (elemento == null || elemento.toString().trim().isEmpty()) return;

        char letra = extrairLetra(elemento);
        NoDuplo<T> noLetra = obterOuCriarNoDuplo(letra);
        noLetra.setInicioListaSimples(inserirOrdenadoSimples(noLetra.getInicioListaSimples(), elemento));
    }

    private NoDuplo<T> obterOuCriarNoDuplo(char letra) {
        NoDuplo<T> atual = inicio;
        NoDuplo<T> anterior = null;

        while (atual != null && atual.getLetra() < letra) {
            anterior = atual;
            atual = atual.getProximo();
        }

        if (atual != null && atual.getLetra() == letra) {
            return atual;
        }

        NoDuplo<T> novo = new NoDuplo<>(letra);

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

    private NoSimples<T> inserirOrdenadoSimples(NoSimples<T> cabeca, T elemento) {
        NoSimples<T> novo = new NoSimples<>(elemento);

        if (cabeca == null || elemento.toString().compareToIgnoreCase(cabeca.getValor().toString()) < 0) {
            novo.setProximo(cabeca);
            return novo;
        }

        NoSimples<T> atual = cabeca;
        while (atual.getProximo() != null && 
               atual.getProximo().getValor().toString().compareToIgnoreCase(elemento.toString()) < 0) {
            atual = atual.getProximo();
        }

        novo.setProximo(atual.getProximo());
        atual.setProximo(novo);
        return cabeca;
    }

    public boolean localizar(T elemento) {
        if (elemento == null || elemento.toString().trim().isEmpty()) return false;

        char letra = extrairLetra(elemento);
        NoDuplo<T> atualDuplo = inicio;

        while (atualDuplo != null && atualDuplo.getLetra() < letra) {
            atualDuplo = atualDuplo.getProximo();
        }

        if (atualDuplo == null || atualDuplo.getLetra() != letra) {
            return false;
        }

        NoSimples<T> atualSimples = atualDuplo.getInicioListaSimples();
        while (atualSimples != null) {
            if (atualSimples.getValor().toString().equalsIgnoreCase(elemento.toString().trim())) {
                return true;
            }
            atualSimples = atualSimples.getProximo();
        }

        return false;
    }

    public boolean remover(T elemento) {
        if (elemento == null || elemento.toString().trim().isEmpty()) return false;

        char letra = extrairLetra(elemento);
        NoDuplo<T> noLetra = inicio;

        while (noLetra != null && noLetra.getLetra() < letra) {
            noLetra = noLetra.getProximo();
        }

        if (noLetra == null || noLetra.getLetra() != letra) {
            return false;
        }

        NoSimples<T> atualSimples = noLetra.getInicioListaSimples();
        NoSimples<T> anteriorSimples = null;
        boolean encontrado = false;

        while (atualSimples != null) {
            if (atualSimples.getValor().toString().equalsIgnoreCase(elemento.toString().trim())) {
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

    private void removerNoDuplo(NoDuplo<T> no) {
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

        NoDuplo<T> atualDuplo = inicio;
        while (atualDuplo != null) {
            System.out.print("[ Letra " + atualDuplo.getLetra() + " ] -> ");
            NoSimples<T> atualSimples = atualDuplo.getInicioListaSimples();
            while (atualSimples != null) {
                System.out.print(atualSimples.getValor() + (atualSimples.getProximo() != null ? " -> " : " -> [null]"));
                atualSimples = atualSimples.getProximo();
            }
            System.out.println();
            atualDuplo = atualDuplo.getProximo();
        }
    }
}
