package editor;

import java.awt.Graphics;

public class Figura 
{ 
    private Figura figura;
    
    public void desenhar(Graphics g)
    {
        figura = new Figura();
        
        figura = new Circunferencias();
        figura.desenhar(g);
        
        figura = new Linha();
        figura.desenhar(g);
        
        figura = new Quadrado();
        figura.desenhar(g);
        
        figura = new Triangulo();
        figura.desenhar(g);
        
    }
}