import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

public class CheckBoxFrame extends JFrame
{
	//Resolver problema com o Warning!
	private static final long serialVersionUID = 1L;
	
	private JTextField texto;
	private JCheckBox negrito;
	private JCheckBox italico;
	
	public CheckBoxFrame()
	{
		super("Testando JCheckBox");
		setLayout(new FlowLayout());
		
		texto = new JTextField("Digite e veja o estilo de fonte",20);
		texto.setFont(new Font("Serif",Font.PLAIN,14));
		add(texto);
		
		negrito = new JCheckBox("Negrito");
		italico = new JCheckBox("Itálico");
		add(negrito);
		add(italico);
		
		CheckBoxHandler treino = new CheckBoxHandler();
		negrito.addItemListener(treino);
		italico.addItemListener(treino);
	}
	
	private class CheckBoxHandler implements ItemListener
	{
		private int val_negrito = Font.PLAIN;
		private int val_italico = Font.PLAIN;
		
		public void itemStateChanged(ItemEvent evento)
		{
			if(evento.getSource()==negrito)
			{
				val_negrito = negrito.isSelected()?Font.BOLD:Font.PLAIN;
			}
			if(evento.getSource()==italico)
			{
				val_italico = italico.isSelected()?Font.ITALIC:Font.PLAIN;
			}
			texto.setFont(new Font("Serif",val_negrito+val_italico,14));
		}
	}
}
