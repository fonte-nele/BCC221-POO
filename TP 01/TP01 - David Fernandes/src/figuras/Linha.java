package figuras;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Linha extends Figura{
	private int x;
	private int y;
	
	public Linha(){
		setXa(0);
		setYa(0);
		setXb(0);
		setYb(0);
	}
	
	public Linha(int xa, int ya, int xb, int yb) {
		setXa(xa);
		setYa(ya);
		setXb(xb);
		setYb(yb);
	}

	public int getXa(){
		return super.x;
	}
	public void setXa(int x){
		super.x = x;
	}
	
	public int getYa(){
		return super.y;
	}
	public void setYa(int y){
		super.y = y;
	}
	
	public int getXb(){
		return this.x;
	}
	public void setXb(int x){
		this.x = x;
	}
	
	public int getYb(){
		return this.y;
	}
	public void setYb(int y){
		this.y = y;
	}
	
	public Figura getFiguraGUI() {
		String xa, ya, xb, yb;
		int XA, YA, XB, YB;
		
		xa = JOptionPane.showInputDialog("X inicial");
		ya = JOptionPane.showInputDialog("Y inicial");
		xb = JOptionPane.showInputDialog("X final");
		yb = JOptionPane.showInputDialog("Y final");
		
		XA = Integer.parseInt(xa);
		YA = Integer.parseInt(ya);
		XB = Integer.parseInt(xb);
		YB = Integer.parseInt(yb);
		
		Figura c = new Linha(XA, YA, XB, YB);
		
		return c;
	}
	
	public void desenhar(JPanel panel) {
		panel.getGraphics().drawLine(getXa(), getYa(), getXb(), getYb());
	}
}
