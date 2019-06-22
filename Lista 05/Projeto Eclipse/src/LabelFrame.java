import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class LabelFrame extends JFrame
{
	//Correção do warning que apresentava!
	private static final long serialVersionUID = 1L;
	
	private JLabel label1,label2,label3;
	
	public LabelFrame()
	{
		super("Testando Rótulos");
		setLayout(new FlowLayout());
		
		label1 = new JLabel("Rótulo com texto");
		label1.setToolTipText("Este é o rótulo 1");
		label1.setHorizontalTextPosition(SwingConstants.CENTER);
		add(label1);
		
		//Criado um arquivo na pasta src com o nome bug1.png para funcionamento do código!
		Icon bug = new ImageIcon(getClass().getResource("bug1.png"));
		label2 = new JLabel("Rótulo com texto e ícone",bug,SwingConstants.LEFT);
		label2.setToolTipText("Este é o rótulo 2");
		add(label2);
		
		label3 = new JLabel();
		label3.setText("Rótulo com ícone e texto no botão");
		label3.setIcon(bug);
		label3.setHorizontalTextPosition(SwingConstants.CENTER);
		label3.setVerticalTextPosition(SwingConstants.BOTTOM);
		label3.setToolTipText("Este é o rótulo 3");
		add(label3);
	}
}
