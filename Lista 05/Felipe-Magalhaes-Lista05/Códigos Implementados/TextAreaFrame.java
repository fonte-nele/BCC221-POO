import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JScrollPane;

public class TextAreaFrame extends JFrame
{
	//Resolver warning!
	private static final long serialVersionUID = 1L;
	
	private JTextArea texto1,texto2;
	private JButton botao;
	
	public TextAreaFrame()
	{
		super("Demonstração Texto Área");
		Box box = Box.createHorizontalBox();
		String demo = "Essa é uma string demo\n"+"ilustrando a cópia de texto\nda caixa de texto 1 para\n"+"outra caixa de texto\nusando um evento externo\n";
		
		texto1 = new JTextArea(demo,10,15);
		box.add(new JScrollPane(texto1));
		
		botao = new JButton("Cópia>>>");
		box.add(botao);
		botao.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent evento)
					{
						texto2.setText(texto1.getSelectedText());
					}
				});
		texto2 = new JTextArea(10,15);
		texto2.setEditable(false);
		box.add(new JScrollPane(texto2));
		add(box);
	}
}
