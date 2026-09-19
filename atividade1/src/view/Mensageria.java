package view;

import controller.MensageriaController;
import model.estrutura.Pagina;

public class Mensageria {
    public static void main(String[] args) {
		try { 
			MensageriaController fila = new MensageriaController();

			for (int i = 1; i <= 5; i++) {
				fila.adicionar(new Pagina(String.valueOf(i)));
			}
			System.out.println("adicionar 1..5 \t| total L = " + fila.total());

			for (int i = 0; i < 3; i++) {
				Pagina pag = fila.ler();
				System.out.println("ler -> id=" + (pag != null ? pag.getId() : "null") + " \t| total L = " + fila.total());
			}

			fila.adicionar(new Pagina("6"));
			fila.adicionar(new Pagina("7"));
			System.out.println("adicionar 6, 7 \t| total L = " + fila.total());

			while (!fila.vazia()) {
				Pagina pag = fila.ler();
				System.out.println("ler -> id=" + (pag != null ? pag.getId() : "null") + " \t| total L = " + fila.total());
			}
			
			try {
        Pagina pagVazia = fila.ler();
        System.out.println("ler -> id=" + (pagVazia != null ? pagVazia.getId() : "null") + " \t| total L = " + fila.total());
      } catch (IllegalArgumentException e) {
        System.out.println("ler -> null \t| total L = " + fila.total() + " <- fila vazia, sem quebrar");
      }
			
		} catch (Exception e) {
        e.printStackTrace();
        }
    }
}
