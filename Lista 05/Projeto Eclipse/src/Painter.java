import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Painter
{
	public static void main(String args[])
	{
		JFrame app = new JFrame("Um simples programa de desenhar");
		
		PaintPanel paint = new PaintPanel();
		paint.setBackground(Color.WHITE);
		app.add(paint,BorderLayout.CENTER);
		
		app.add(new JLabel("Pressione o mouse para desenhar"),BorderLayout.SOUTH);
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setSize(500,250);
		app.setVisible(true);
	}
}
