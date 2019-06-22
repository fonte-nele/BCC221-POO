import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class LabelFrame extends JFrame
{
	//Corre��o do warning que apresentava!
	private static final long serialVersionUID = 1L;
	
	private JLabel label1,label2,label3;
	
	public LabelFrame()
	{
		super("Testando R�tulos");
		setLayout(new FlowLayout());
		
		label1 = new JLabel("R�tulo com texto");
		label1.setToolTipText("Este � o r�tulo 1");
		label1.setHorizontalTextPosition(SwingConstants.CENTER);
		add(label1);
		
		//Criado um arquivo na pasta src com o nome bug1.png para funcionamento do c�digo!
		Icon bug = new ImageIcon(getClass().getResource("bug1.png"));
		label2 = new JLabel("R�tulo com texto e �cone",bug,SwingConstants.LEFT);
		label2.setToolTipText("Este � o r�tulo 2");
		add(label2);
		
		label3 = new JLabel();
		label3.setText("R�tulo com �cone e texto no bot�o");
		label3.setIcon(bug);
		label3.setHorizontalTextPosition(SwingConstants.CENTER);
		label3.setVerticalTextPosition(SwingConstants.BOTTOM);
		label3.setToolTipText("Este � o r�tulo 3");
		add(label3);
	}
}
