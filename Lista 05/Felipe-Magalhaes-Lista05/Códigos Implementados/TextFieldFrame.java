import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;

public class TextFieldFrame extends JFrame
{
	//Resolver problema do warning!
	private static final long serialVersionUID = 1L;
	
	private JTextField text1,text2,text3;
	private JPasswordField senha;
	
	public TextFieldFrame()
	{
		super("Testando JTextFiel e JPasswordField");
		setLayout(new FlowLayout());
		
		text1 = new JTextField(10);
		add(text1);
		
		text2 = new JTextField("Digite seu texto aqui");
		add(text2);
		
		text3 = new JTextField("Digite a senha ao lado",21);
		text3.setEditable(false);
		add(text3);
		
		senha = new JPasswordField("        ");
		add(senha);
		
		TextFieldHandler treino = new TextFieldHandler();
		text1.addActionListener(treino);
		text2.addActionListener(treino);
		text3.addActionListener(treino);
		senha.addActionListener(treino);
	}
	private class TextFieldHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent evento)
		{
			String nova = "";
			
			if(evento.getSource()==text1)
			{
				nova = String.format("Texto 1: %s",evento.getActionCommand());
			}
			else
			{
				if(evento.getSource()==text2)
				{
					nova = String.format("Texto 2: %s",evento.getActionCommand());
				}
				else
				{
					if(evento.getSource()==text3)
					{
						nova = String.format("Texto 3: %s",evento.getActionCommand());
					}
					else
					{
						if(evento.getSource()==senha)
						{
							nova = String.format("Senha: %s", new String(senha.getPassword()));
						}
					}
				}
			}
			JOptionPane.showMessageDialog(null, nova);
		}
	}
}
