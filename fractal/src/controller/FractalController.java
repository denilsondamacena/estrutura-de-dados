package controller;

import java.awt.Graphics;

public class FractalController {
	
	private static final double RAIZ3 = Math.sqrt(3);
	
	public FractalController() {
		super();
	}
	
	public void koch(Graphics g, int nivel, double x1, double y1, double x2, double y2) {
		//parada: no nível 0 o segmento não se divide mais - e desenhado
		if (nivel == 0) {
			g.drawLine((int) x1, (int) y1, (int) x2, (int) y2);
			return;
		}
		//recorrencia: o segmento vira quatro, com 1/3 do comprimento cada
		double dx = (x2 - x1) / 3;
		double dy = (y2 - y1) / 3;
		double xa = x1 + dx;
		double ya = y1 + dy;
		double xb = x1 + dx * 2;
		double yb = y1 + dy * 2;
		double xc = xa + dx / 2 + dy * RAIZ3 / 2;
		double yc = ya - dx * RAIZ3 / 2 + dy / 2;
		koch(g, nivel - 1, x1, y1, xa, ya);
		koch(g, nivel - 1, xa, ya, xc, yc);
		koch(g, nivel - 1, xc, yc, xb, yb);
		koch(g, nivel - 1, xb, yb, x2, y2);
	}
}
