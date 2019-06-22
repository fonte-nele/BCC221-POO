package br.ufop.decom.bcc221.Figura;

import br.ufop.decom.bcc221.Panel.ImagePanel;

/*
    Nome: Figura.java

    Autor: Gilmar Serafim <gilmarjunior72@gmail.com>

    Data: 07/06/2016

    Objetivo:

 */

public class Figura {
    
    private Figura figura;
    
    public void desenhar(){
        
        figura = new Figura();
        
        figura = new Circunferencia();
        figura.desenhar();
        
        figura = new Linha();
        figura.desenhar();
        
        figura = new Quadrado();
        figura.desenhar();
        
        figura = new Triangulo();
        figura.desenhar();
        
    }

}
