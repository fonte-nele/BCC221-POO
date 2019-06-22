package figuras;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Triangulo extends Figura{
	private int x[] = new int[3];
	private int y[] = new int[3];
	
	public Triangulo(){
		setX(null);
		setY(null);
	}
	
	public Triangulo(int x[], int y[]){
		setX(x);
		setY(y);
	}
	
	public int[] getX(){
		return this.x;
	}
	public void setX(int []x){
		this.x = x;
	}
	
	public int[] getY(){
		return this.y;
	}
	public void setY(int []y){
		this.y = y;
	}
	
	public Figura getFiguraGUI(){
		String xa, ya, xb, yb, xc, yc;
		int x[] = new int[3];
		int y[] = new int[3];

		JOptionPane.showMessageDialog(null, "Insira a coordenada dos 3 pontos");
		xa = JOptionPane.showInputDialog("XA");
		ya = JOptionPane.showInputDialog("YA");
		xb = JOptionPane.showInputDialog("XB");
		yb = JOptionPane.showInputDialog("YB");
		xc = JOptionPane.showInputDialog("XC");
		yc = JOptionPane.showInputDialog("YC");

		x[0] = Integer.parseInt(xa);
		y[0] = Integer.parseInt(ya);
		x[1] = Integer.parseInt(xb);
		y[1] = Integer.parseInt(yb);
		x[2] = Integer.parseInt(xc);
		y[2] = Integer.parseInt(yc);

		Figura t = new Triangulo(x, y);
		
		return t;
	}
	
	public void desenhar(JPanel panel) {
		panel.getGraphics().drawPolygon(getX(), getY(), getX().length);

	}
}
