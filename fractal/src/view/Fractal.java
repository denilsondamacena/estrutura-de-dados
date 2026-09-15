package view;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.FractalController;

public class Fractal extends JPanel {
	
	private FractalController controlador = new FractalController();
	private int nivel;
	
	public Fractal(int nivel) {
		super();
		this.nivel = nivel;
		this.setBackground(Color.WHITE);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.CYAN);
		double lado = Math.min(this.getWidth(), this.getHeight()) * 0.55;
		double altura = lado * Math.sqrt(3) / 2;
		double xTopo = this.getWidth() / 2.0;
		double yTopo = this.getHeight() / 2.0 - altura * 2 / 3;
		double xDir = xTopo + lado / 2;
		double xEsq = xTopo - lado / 2;
		double yBase = yTopo + altura;
		this.controlador.koch(g, this.nivel, xTopo, yTopo, xDir, yBase);
		this.controlador.koch(g, this.nivel, xDir, yBase, xEsq, yBase);
		this.controlador.koch(g, this.nivel, xEsq, yBase, xTopo, yTopo);
	}
	
	public static void main(String[] args) {
		int nivel = 0;
		if (args.length > 0) {
			nivel = Integer.parseInt(args[0]);
		}
		JFrame janela = new JFrame("Floco de Koch - nivel " + nivel);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.add(new Fractal(nivel));
		janela.setSize(700, 700);
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);
	}
}
