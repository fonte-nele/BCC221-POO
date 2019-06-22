
import figura.*;

public class Principal
{
	
	public static void main(String args[]){
		Figura t = new Triangulo(10, 10, 'A');
		t.desenhar();
                System.out.print("\n");
                
                Figura r = new Retangulo(10, 5, 'X');
		r.desenhar();
                  System.out.print("\n");
                  
                Figura c = new Circulo(3, 3, '0');
		c.desenhar();
                System.out.print("\n\n");
                  
                Figura l = new Linha(10, '-');
		l.desenhar();
                System.out.print("\n");
	}
}