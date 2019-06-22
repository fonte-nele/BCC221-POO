import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ButtonFrame extends JFrame
{
	//Resolver problema Warning!
	private static final long serialVersionUID = 1L;
	
	private JButton texto,icone;
	public ButtonFrame()
	{
		super("Testando bot�es");
		setLayout(new FlowLayout());
		
		texto = new JButton("Bot�o texto");
		add(texto);
		
		Icon bug1 = new ImageIcon(getClass().getResource("bug1.png"));
		Icon bug2 = new ImageIcon(getClass().getResource("bug2.png"));
		icone = new JButton("Bot�o �cone",bug1);
		icone.setRolloverIcon(bug2);
		add(icone);
		
		ButtonHandler treino = new ButtonHandler();
		icone.addActionListener(treino);
		texto.addActionListener(treino);
	}
	private class ButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent evento)
		{
			JOptionPane.showMessageDialog(ButtonFrame.this,String.format("Voc� pressionou: %s", evento.getActionCommand()));
		}
	}
}
