package figuras;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Circulo extends Figura{
	private int raio;

	public Circulo(){
		setX(0);
		setY(0);
		setRaio(0);
	}

	public Circulo(int x, int y, int raio){
		setX(x);
		setY(y);
		setRaio(raio);
	}

	public int getX(){
		return super.x;
	}
	public void setX(int x){
		super.x = x;
	}

	public int getY(){
		return super.y;
	}
	public void setY(int y){
		super.y = y;
	}

	public int getRaio(){
		return this.raio;
	}
	public void setRaio(int raio){
		this.raio = raio;
	}

	public Figura getFiguraGUI(){
		String x, y, r;
		int X, Y, R;

		x = JOptionPane.showInputDialog("X do centro");
		y = JOptionPane.showInputDialog("Y do centro");
		r = JOptionPane.showInputDialog("Raio");

		X = Integer.parseInt(x);
		Y = Integer.parseInt(y);
		R = Integer.parseInt(r);

		Figura c = new Circulo(X, Y, R);

		return c;
	}

	public void desenhar(JPanel panel) {
		panel.getGraphics().drawOval(getX() - getRaio(), getY() - getRaio(), getRaio()*2, getRaio()*2);
	}
}
