package figuras;
import java.util.Vector;

import javax.swing.JPanel;

public class Grupo extends Figura{
	private Vector<Figura> grupo = new Vector<Figura>();
		
	public Grupo(Vector<Figura> figuras){
		grupo = figuras;
	}
	
	public Vector<Figura> getGrupo() {
		return this.grupo;
	}
	public void addFigGrupo(Figura figura) {
		this.grupo.add(figura);
	}
	
	public Figura getFiguraGUI() {
		return null;
	}
	
	public void desenhar(JPanel panel) {
		for(Figura figura : getGrupo()){
			figura.desenhar(panel);
		}		
	}	
}