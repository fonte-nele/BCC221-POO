import java.awt.Color;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class KeyDemoFrame extends JFrame implements KeyListener
{
	//Resolução warning!!
	private static final long serialVersionUID = 1L;
	
	private String linha1="",linha2="",linha3="";
	private JTextArea texto;
	
	public KeyDemoFrame()
	{
		super("Demonstração Eventos Keystroke");
		
		texto = new JTextArea(10,15);
		texto.setText("Pressione alguma tecla do teclado...");
		texto.setEnabled(false);
		texto.setDisabledTextColor(Color.BLACK);
		add(texto);
		
		addKeyListener(this);
	}
	public void keyPressed(KeyEvent evento)
	{
		linha1 = String.format("Tecla pressionada: %s", KeyEvent.getKeyText(evento.getKeyCode()));
		linhas2e3(evento);
	}
	public void keyReleased(KeyEvent evento)
	{
		linha1 = String.format("Tecla liberada: %s", KeyEvent.getKeyText(evento.getKeyCode()));
		linhas2e3(evento);
	}
	public void keyTyped(KeyEvent evento)
	{
		linha1 = String.format("Tipo tecla: %s", evento.getKeyChar());
		linhas2e3(evento);
	}
	private void linhas2e3(KeyEvent evento)
	{
		linha2 = String.format("Essa tecla %s é uma ação da chave",(evento.isActionKey()?"":"não"));
		
		String temp = KeyEvent.getKeyModifiersText(evento.getModifiers());
		
		linha3 = String.format("Teclas especiais pressionada: %s",(temp.equals("")?"nenhuma":temp));
		
		texto.setText(String.format("%s\n\n%s\n\n%s\n",linha1,linha2,linha3));
	}
}
