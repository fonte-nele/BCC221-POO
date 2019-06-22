package br.ufop.decom.bcc221.Main;

import br.ufop.decom.bcc221.Frame.Tela;
import javax.swing.JFrame;


/*
    Nome: Main.java

    Autor: Gilmar Serafim <gilmarjunior72@gmail.com>

    Data: 07/06/2016

    Objetivo:

*/

public class Main {

    public static void main(String[] args) {
        
        Tela tela = new Tela();
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setSize(600, 400);
        tela.setLocationRelativeTo(null);
        tela.setVisible(true);

    }

}
