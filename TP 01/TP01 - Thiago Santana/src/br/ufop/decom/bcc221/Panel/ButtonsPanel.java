package br.ufop.decom.bcc221.Panel;

import br.ufop.decom.bcc221.Figura.Circunferencia;
import br.ufop.decom.bcc221.Figura.Figura;
import br.ufop.decom.bcc221.Figura.Linha;
import br.ufop.decom.bcc221.Figura.Quadrado;
import br.ufop.decom.bcc221.Figura.Triangulo;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/*
    Nome: ButtonsPanel.java

    Autor: Gilmar Serafim <gilmarjunior72@gmail.com>

    Data: 07/06/2016

    Objetivo:

 */

public class ButtonsPanel extends JPanel{
    
    private JButton bt_circunferencia;
    private JButton bt_linha;
    private JButton bt_quadrado;
    private JButton bt_triangulo;
    private JButton bt_grupos;
    
    private Figura figura;
    
    public ButtonsPanel(){
        
        setLayout(new FlowLayout());
        
        
        ButtonsPanelHandler handler = new ButtonsPanelHandler();
        
        bt_circunferencia = new JButton("Circunferência");
        bt_circunferencia.addActionListener(handler);
        add(bt_circunferencia);
        
        bt_linha = new JButton("Linha");
        bt_linha.addActionListener(handler);
        add(bt_linha);
        
        bt_quadrado = new JButton("Quadrado");
        bt_quadrado.addActionListener(handler);
        add(bt_quadrado);
        
        bt_triangulo = new JButton("Triângulo");
        bt_triangulo.addActionListener(handler);
        add(bt_triangulo);
        
        bt_grupos = new JButton("Grupo");
        bt_grupos.addActionListener(handler);
        add(bt_grupos);
        
        
    }
    
    private class ButtonsPanelHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent event) {
            
            if(event.getSource() == bt_circunferencia){
                
                figura = new Circunferencia();
                figura.desenhar();
                
            }else if(event.getSource() == bt_linha){
                
                figura = new Linha();
                figura.desenhar();
                
            }else if(event.getSource() == bt_quadrado){
                
                figura = new Quadrado();
                figura.desenhar();
                
            }else if(event.getSource() == bt_triangulo){
                
                figura = new Triangulo();
                figura.desenhar();
                
            }else if(event.getSource() == bt_grupos){
                
                figura = new Figura();
                figura.desenhar();
                
            }              
                
            
        }       
        
    }

}
