import figura.Circulo;
import figura.Figura;
import figura.Grupo;
import figura.IFigura;
import figura.Linha;
import figura.Retangulo;
import figura.Triangulo;

public class Principal{
	
	public static void main(String args[])
	{
                //Grupo g = new Figura();
                
                //g.escolherFigura(1, 10, 10, 'X');
                
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