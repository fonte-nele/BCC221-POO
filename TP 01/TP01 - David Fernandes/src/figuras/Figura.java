package figuras;

import javax.swing.JPanel;

public abstract class Figura{
	protected int x;
	protected int y;
	
	public abstract Figura getFiguraGUI();
	
	public abstract void desenhar(JPanel panel);
}
