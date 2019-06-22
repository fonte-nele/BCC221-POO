package br.ufop.decom.bcc221.Frame;

import br.ufop.decom.bcc221.Panel.ButtonsPanel;
import br.ufop.decom.bcc221.Panel.ImagePanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;

public class Tela extends JFrame{
    
    private ButtonsPanel buttonsPanel;
    private ImagePanel imagePanel;
    
    public Tela(){
        
        super("TP1 POO");
       
        
        buttonsPanel = new ButtonsPanel();
        add(buttonsPanel, BorderLayout.NORTH);
        
        imagePanel = new ImagePanel();
        add(imagePanel, BorderLayout.CENTER);
        
    }

}
