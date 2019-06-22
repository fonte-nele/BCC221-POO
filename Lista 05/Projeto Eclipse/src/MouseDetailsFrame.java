import java.awt.BorderLayout;
//import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MouseDetailsFrame extends JFrame
{
	//Resolver Warning!
	private static final long serialVersionUID = 1L;
	
	private String detalhes;
	private JLabel status;
	
	public MouseDetailsFrame()
	{
		super("Mouse cliques e bot�es");
		status = new JLabel("Clique o mouse");
		add(status, BorderLayout.SOUTH );
		addMouseListener(new MouseClickHandler());
	}
	private class MouseClickHandler extends MouseAdapter
	{
		public void mouseClicked(MouseEvent evento)
		{
			//int xPos = evento.getX();
			//int yPos = evento.getY();
			detalhes = String.format("Cliques: %d veze(s)",evento.getClickCount());
			if(evento.isMetaDown())
			{
				detalhes += " com bot�o direito do mouse";
			}
			else
			{
				if(evento.isAltDown())
				{
					detalhes += " com bot�o central do mouse";
				}
				else
				{
					detalhes += " com bot�o esquerdo do mouse";
				}			
			}
			status.setText(detalhes);
		}
	}
}
