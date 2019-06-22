import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MouseTrackerFrame extends JFrame
{
	//Resolver Warning!
	private static final long serialVersionUID = 1L;

	private JPanel mouse;
	private JLabel status;
	
	public MouseTrackerFrame()
	{
		super("Demonstração de Eventos do Mouse");
		
		mouse = new JPanel();
		mouse.setBackground(Color.WHITE);
		add(mouse, BorderLayout.CENTER);
		
		status = new JLabel("Mouse fora do Painel");
		add(status, BorderLayout.SOUTH);
		
		MouseHandler treino = new MouseHandler();
		mouse.addMouseListener(treino);
		mouse.addMouseMotionListener(treino);
	}
	private class MouseHandler implements MouseListener, MouseMotionListener
	{
		public void mouseClicked(MouseEvent event)
		{
			status.setText(String.format("Clicado em [%d, %d]",event.getX(),event.getY()));
		}

		public void mousePressed(MouseEvent event)
		{
			status.setText(String.format("Pressionado em [%d, %d]",event.getX(),event.getY()));
		}

		public void mouseReleased(MouseEvent event)
		{
			status.setText(String.format("Liberado em [%d, %d]",event.getX(),event.getY()));
		}

		public void mouseEntered(MouseEvent event)
		{
			status.setText(String.format("Mouse posicionado em [%d, %d]",event.getX(),event.getY()));
			mouse.setBackground(Color.GREEN);
		}
		
		public void mouseExited(MouseEvent event)
		{
			status.setText("Mouse fora do Painel");
			mouse.setBackground(Color.WHITE);
		}
		
		public void mouseDragged(MouseEvent event)
		{
			status.setText(String.format("Arrastado em [%d, %d]",event.getX(),event.getY()));
		}

		public void mouseMoved(MouseEvent event)
		{
			status.setText(String.format("Movendo em [%d, %d]",event.getX(),event.getY()));
		}
	}
}
