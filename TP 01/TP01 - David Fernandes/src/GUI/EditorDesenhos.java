package GUI;
import figuras.*;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Vector;

public class EditorDesenhos extends JPanel{

	private static final long serialVersionUID = 1L;
	JTextField coordXa;
	JTextField coordYa;
	JTextField coordXb;
	JTextField coordYb;
	
	/** Cria o painel */
	public EditorDesenhos() {
		setLayout(null);
		
		/**Desenhar Linha*/
		JButton btnDesenharLinha = new JButton("Desenhar Linha");
		btnDesenharLinha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				Figura l = new Linha();
				l = l.getFiguraGUI();
				l.desenhar(EditorDesenhos.this);
			}
		});
		btnDesenharLinha.setBounds(10, 10, 180, 20);
		add(btnDesenharLinha);
		
		/**Desenhar Circulo*/
		
		JButton btnDesenharCirculo = new JButton("Desenhar Circulo");
		btnDesenharCirculo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Figura c = new Circulo();
				c = c.getFiguraGUI();
				c.desenhar(EditorDesenhos.this);
			}
		});
		btnDesenharCirculo.setBounds(10, 35, 180, 20);
		add(btnDesenharCirculo);
		
		/**Desenhar Retangulo*/
		JButton btnDesenharRetangulo = new JButton("Desenhar Retangulo");
		btnDesenharRetangulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Figura r = new Retangulo();
				r = r.getFiguraGUI();
				r.desenhar(EditorDesenhos.this);
			}
		});
		btnDesenharRetangulo.setBounds(10, 60, 180, 20);
		add(btnDesenharRetangulo);
		
		/**Desenhar Triangulo*/
		JButton btnDesenharTriangulo = new JButton("Desenhar Triangulo");
		btnDesenharTriangulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Figura t = new Triangulo();
				t = t.getFiguraGUI();
				t.desenhar(EditorDesenhos.this);
			}
		});
		btnDesenharTriangulo.setBounds(10, 85, 180, 20);
		add(btnDesenharTriangulo);
		
		
		JButton btnDesenharGrupo = new JButton("Desenhar Grupo");
		btnDesenharGrupo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int escolha;
				String opcoes[] = {"Linha", "Circulo", "Retangulo", "Triangulo"};
				Vector<Figura> figuras = new Vector<>(); //FIZ UM VECTOR DE FIGURAS PARA GUARDAS TODAS AS FIGURAS QUE SERÃO ADICIONADAS AO GRUPO
				
				
				do{
					
					String fig_added = (String) JOptionPane.showInputDialog(null, null,
					        "Escolha a figura a ser adicionada?",
					        JOptionPane.QUESTION_MESSAGE, 
					        null, opcoes, opcoes[0]);
					switch(fig_added){
						case "Linha":
							Figura l = new Linha();
							l = l.getFiguraGUI();
							figuras.add(l);
							break;
						case "Circulo":
							Figura c = new Circulo();
							c = c.getFiguraGUI();
							figuras.add(c);
							break;
						case "Retangulo":
							Figura r = new Retangulo();
							r = r.getFiguraGUI();
							figuras.add(r);
							break;
						case "Triangulo":
							Figura t = new Linha();
							t = t.getFiguraGUI();
							figuras.add(t);
							break;
					}
					
					escolha = JOptionPane.showOptionDialog(null,
							"Deseja adicionar nova figura ao grupo?",
							null, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
							null, null, null);
					
					/** Condição de Parada*/
					if(escolha != JOptionPane.YES_OPTION){
						Figura g = new Grupo(figuras);
						g.desenhar(EditorDesenhos.this);
						break;
					}
						
					
				}while(true);				
			}
		});
		btnDesenharGrupo.setBounds(10, 110, 180, 20);
		add(btnDesenharGrupo);
		
		
		/**Limpar*/
		JButton btnLimpar = new JButton("Limpar Tela");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				repaint();
			}
		});
		btnLimpar.setBounds(10, 135, 180, 20);
		add(btnLimpar);
		
	}
	
}

