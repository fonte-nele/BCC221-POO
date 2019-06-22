package br.ufop.decom.bcc221.Panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/*
    Nome: ImagePanel.java

    Autor: Gilmar Serafim <gilmarjunior72@gmail.com>

    Data: 07/06/2016

    Objetivo:

 */

public class ImagePanel extends JPanel{
    
    private JTextArea textArea;
    
    public ImagePanel(){        
        
       textArea = new JTextArea(20, 50);
       textArea.setEnabled(false);
       textArea.setDisabledTextColor(Color.BLACK);
       add(textArea);
        
    }    
    
  
    
    
    
}
