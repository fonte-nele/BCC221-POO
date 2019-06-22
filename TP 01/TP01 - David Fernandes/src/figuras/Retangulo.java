package figuras;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Retangulo extends Figura{
	private int width;
	private int height;
	
	public Retangulo(){
		setX(0);
		setY(0);
		setWidth(0);
		setHeight(0);
	}
	
	public Retangulo(int x, int y, int height, int width) {
		setX(x);
		setY(y);
		setWidth(height);
		setHeight(width);
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
	
	public int getWidth(){
		return this.width;
	}
	public void setWidth(int width){
		this.width = width;
	}
	
	public int getHeight(){
		return this.height;
	}
	public void setHeight(int height){
		this.height = height;
	}
	
	public Figura getFiguraGUI() {
		String xa, ya, xb, yb;
		int XA, YA, XB, YB;
		
		xa = JOptionPane.showInputDialog("X do centro");
		ya = JOptionPane.showInputDialog("Y do centro");
		xb = JOptionPane.showInputDialog("Tamanho da base");
		yb = JOptionPane.showInputDialog("Tamanho da altura");
		
		XA = Integer.parseInt(xa);
		YA = Integer.parseInt(ya);
		XB = Integer.parseInt(xb);
		YB = Integer.parseInt(yb);
		
		Figura r = new Retangulo(XA, YA, XB, YB);		
		
		return r;
	}
	
	public void desenhar(JPanel panel) {
		panel.getGraphics().drawRect(getX() - getWidth()/2, getY() - getHeight()/2, getWidth(), getHeight());
	}
}
