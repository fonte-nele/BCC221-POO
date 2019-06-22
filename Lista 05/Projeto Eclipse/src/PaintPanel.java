import java.awt.Point;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JPanel;

public class PaintPanel extends JPanel
{
	//Resolver Warning!
	private static final long serialVersionUID = 1L;
	
	private int cont=0;
	private Point pontos[] = new Point[10000];
	
	public PaintPanel()
	{
		addMouseMotionListener(
				new MouseMotionAdapter()
				{
					public void mouseDragged(MouseEvent evento)
					{
						if(cont < pontos.length)
						{
							pontos[cont] = evento.getPoint();
							cont++;
							repaint();
						}
					}
				});
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		for(int i=0; i<cont; i++)
		{
			g.setColor(Color.BLUE);
			g.fillOval(pontos[i].x, pontos[i].y, 4, 4);
		}
	}
}
