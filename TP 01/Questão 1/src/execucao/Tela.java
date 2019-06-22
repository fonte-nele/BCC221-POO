package execucao;

import editor.Figura;
import editor.Linha;
import editor.Circunferencias;
import editor.Quadrado;
import editor.Triangulo;
import javax.swing.*;
import java.awt.*;

public class Tela extends JPanel
{
    //Resolução Warning!
	private static final long serialVersionUID = 1L;

	
    
    public static void main(String[] args) 
    {
        Tela tela = new Tela();
        JFrame application = new JFrame("Desenhos geométricos");
        application.add(tela);
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.setSize(700,700);
        application.setVisible(true);
    }
    
    public void paintComponent(Graphics g)
    {
		Figura figr = new Circunferencias();
    	figr.desenhar(g);
		
		Figura figura = new Linha();
    	figura.desenhar(g);
    	
    	Figura fig = new Triangulo();
    	fig.desenhar(g);
    	
    	Figura fig2 = new Quadrado();
    	fig2.desenhar(g);
    }
}