import java.awt.FlowLayout;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class ComboBoxFrame extends JFrame
{
	//Resolver warning!
	private static final long serialVersionUID = 1L;
	
	private JComboBox<Object> combo;
	private JLabel rotulo;
	private String nomes[] = {"bug1.png","bug2.png","travelbug.png","buganim.png"};
	private Icon icones[] = {
							new ImageIcon(getClass().getResource(nomes[0])),
							new ImageIcon(getClass().getResource(nomes[1])),
							new ImageIcon(getClass().getResource(nomes[2])),
							new ImageIcon(getClass().getResource(nomes[3]))};
	public ComboBoxFrame()
	{
		super("Testando JComboBox");
		setLayout(new FlowLayout());
		
		combo = new JComboBox<Object>(nomes);
		combo.setMaximumRowCount(3);
		
		combo.addItemListener(
				new ItemListener()
				{
					public void itemStateChanged(ItemEvent evento)
					{
						if(evento.getStateChange()==ItemEvent.SELECTED)
						{
							rotulo.setIcon(icones[combo.getSelectedIndex()]);
						}
					}
				});
		add(combo);
		rotulo = new JLabel(icones[0]);
		add(rotulo);
	}
}


