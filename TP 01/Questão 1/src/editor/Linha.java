package editor;

import java.awt.*;

public class Linha extends Figura
{    
	public void desenhar(Graphics g)
	{ 
		g.setColor(Color.BLACK);
        g.drawLine(50,65,50,200);  
        
        g.setColor(Color.BLACK);
        g.drawLine(200,300,310,380);
        
        g.setColor(Color.BLACK);
        g.drawLine(100, 350, 120, 420);
        g.drawLine(0, 0, 50, 25);
     }
}