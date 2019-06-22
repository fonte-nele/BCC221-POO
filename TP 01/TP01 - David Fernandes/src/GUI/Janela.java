package GUI;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Janela extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	Double width = screenSize.getWidth();
	Double height = screenSize.getHeight();
	
	public int getWidth(){
		return this.width.intValue();
	}
	public int getHeight(){
		return this.height.intValue();
	}
	
	/** Create the frame */
	public Janela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, this.width.intValue(), this.height.intValue());
		contentPane = new EditorDesenhos();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}
	
	/** Launch the application */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Janela frame = new Janela();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
