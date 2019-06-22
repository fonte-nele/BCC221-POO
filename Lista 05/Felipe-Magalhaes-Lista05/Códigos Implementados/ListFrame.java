import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.ListSelectionModel;

public class ListFrame extends JFrame
{
	//Resolver Warning!
	private static final long serialVersionUID = 1L;
	
	private JList<?> Lista_cores;
	private final String Nomes_cores[] = {"Amarelo","Azul","Branco","Ciano","Cinza","Cinza Claro","Cinza Escuro",
										"Laranja","Magenta","Preto","Rosa","Verde","Vermelho"
										};
	private final Color cores[] = {Color.YELLOW,Color.BLUE,Color.WHITE,Color.CYAN,
									Color.GRAY,Color.LIGHT_GRAY,Color.DARK_GRAY,
									Color.ORANGE,Color.MAGENTA,Color.BLACK,Color.PINK,Color.GREEN,Color.RED
									};
	public ListFrame()
	{
		super("Testando Lista de Cores");
		setLayout(new FlowLayout());
		JList<?> jList = new JList<Object>(Nomes_cores);
		Lista_cores = jList;
		Lista_cores.setVisibleRowCount(5);
		Lista_cores.setSelectionMode(ListSelectionModel.SINGLE_SELECTION );
		add(new JScrollPane( Lista_cores));
		Lista_cores.addListSelectionListener(
		
		new ListSelectionListener()
		{
			public void valueChanged(ListSelectionEvent evento)
			{
				getContentPane().setBackground(cores[Lista_cores.getSelectedIndex()]);
			}
		});
	}
}