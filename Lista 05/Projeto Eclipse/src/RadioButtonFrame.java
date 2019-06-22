import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class RadioButtonFrame extends JFrame
{
	//Resolver Warning!
	private static final long serialVersionUID = 1L;
	
	private JTextField texto;
	private Font simples,negrito,italico,neg_italico;
	private JRadioButton botao_simples,botao_neg,botao_italico,botao_neg_italico;
	private ButtonGroup radio;
	
	public RadioButtonFrame()
	{
		super("Teste RadioButton");
		setLayout(new FlowLayout());
		
		texto = new JTextField("Digite e veja o estilo de fonte",25);
		add(texto);
		
		botao_simples = new JRadioButton("Simples",true);
		botao_neg = new JRadioButton("Negrito",false);
		botao_italico = new JRadioButton("Itálico",false);
		botao_neg_italico = new JRadioButton("Negrito/Itálico",false);
		
		add(botao_simples);
		add(botao_neg);
		add(botao_italico);
		add(botao_neg_italico);
		
		radio = new ButtonGroup();
		radio.add(botao_simples);
		radio.add(botao_neg);
		radio.add(botao_italico);
		radio.add(botao_neg_italico);
		
		simples = new Font("Serif",Font.PLAIN,14);
		negrito = new Font("Comic Sans MS",Font.BOLD,14);
		italico = new Font("Serif",Font.ITALIC,14);
		neg_italico = new Font("Serif",Font.BOLD + Font.ITALIC,14);
		texto.setFont(simples);
		
		botao_simples.addItemListener(new RadioButtonHandler(simples));
		botao_neg.addItemListener(new RadioButtonHandler(negrito));
		botao_italico.addItemListener(new RadioButtonHandler(italico));
		botao_neg_italico.addItemListener(new RadioButtonHandler(neg_italico));
	}
	private class RadioButtonHandler implements ItemListener
	{
		private Font fonte;
		
		public RadioButtonHandler(Font f)
		{
			fonte = f;
		}
		public void itemStateChanged(ItemEvent evento)
		{
			texto.setFont(fonte);
		}
	}
}
