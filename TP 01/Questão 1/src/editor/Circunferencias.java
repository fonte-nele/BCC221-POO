package editor;

import java.awt.Color;
import java.awt.Graphics;

public class Circunferencias extends Figura
{
    public void desenhar(Graphics g)
    {
    	g.setColor(Color.WHITE);
        g.fillRect(0, 0, 700, 700);
        g.setColor(Color.RED);
        g.fillOval(100, 80, 150, 150);
        g.setColor(Color.PINK);
        g.fillOval(120, 105, 30, 30);
        g.setColor(Color.BLUE);       
    }
}