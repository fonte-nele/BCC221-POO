
package figura;
import java.util.LinkedList;

public class Grupo extends Figura {
	
	private LinkedList<Figura> lista = new LinkedList<Figura>();
	
	public void escolherFigura(int opcao, int a, int b, char c){		
		Figura figura;
		switch(opcao){
			case 1: figura = new Retangulo(a, b, c);
					this.lista.add(figura);
					
					return;
					
			case 2: figura = new Triangulo(a, b, c);					
					this.lista.add(figura);
					
					return;
					
			case 3: figura = new Circulo(a, b, c);					
					this.lista.add(figura);
		}
		
	}
	public void escolherFigura(int a, char c){
		Figura figura;
		
		figura = new Linha(a, c);					
		this.lista.add(figura);
		
		return;
	}
	
	public void desenhar() {
		for(Figura figura : this.lista)
			figura.desenhar();
	}	
}