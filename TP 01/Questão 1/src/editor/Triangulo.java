package editor;

import java.awt.Color;
import java.awt.Polygon;
import java.awt.Graphics;

public class Triangulo extends Figura
{
    public void desenhar(Graphics g)
    {
    	g.setColor(Color.MAGENTA);
        Polygon poligono = new Polygon();
        
        poligono.addPoint(315,50);
        poligono.addPoint(250, 200);
        poligono.addPoint(380, 200);
        g.fillPolygon(poligono);
    }
}