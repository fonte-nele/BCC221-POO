package editor;

import java.awt.Color;
import java.awt.Graphics;

public class Quadrado extends Figura
{
    public void desenhar(Graphics g)
    {
    	g.setColor(Color.GREEN);
        g.fillRect(300, 300, 150, 150);
    }
}

