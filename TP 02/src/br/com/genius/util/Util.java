package br.com.genius.util;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

public class Util {

    public static final int TIME = 300;
    public static final int QUANTIDADE_TOTAL_JOGADAS = 50;
    //
    public static final double BOTAO_1_FREQ = 500;
    public static final double BOTAO_2_FREQ = 1000;
    public static final double BOTAO_3_FREQ = 1500;
    public static final double BOTAO_4_FREQ = 2000;
    //
    public static final Color COR_BOTAO_1 = new Color(0, 100, 0);
    public static final Color COR_BOTAO_2 = new Color(0, 0, 100);
    public static final Color COR_BOTAO_3 = new Color(100, 0, 0);
    public static final Color COR_BOTAO_4 = new Color(100, 100, 0);
    //
    public static final Color COR_BOTAO_1_CLICADO = Color.green;
    public static final Color COR_BOTAO_2_CLICADO = Color.blue;
    public static final Color COR_BOTAO_3_CLICADO = Color.red;
    public static final Color COR_BOTAO_4_CLICADO = Color.yellow;
    //
    private static final String FILE = "genius.dat";

    public static int[] geraVetorAleatorio(int tamanhoVetor) {

        int[] vetor = new int[tamanhoVetor];
        double l = 0;
        Random r = new Random();

        for (int i = 0; i < tamanhoVetor; i++) {
            do {
                l = r.nextDouble() * 10;
                if (l < 0) {
                    l = l * -1;
                }
                if ((int) l == 0) {
                    l = -1; //forca nova iteração
                }
            } while (!(l < 5 && l > 0));

            vetor[i] = (int) l;

        }

        return vetor;

    }

    public static boolean comparaVetores(int[] vetor1, int[] vetor2, int tamanhoIndice) {

        int t = 0;

//        exibeVetor("VetorCPU: ", vetor1);
//        exibeVetor("VetorPlayer: ", vetor2);

        for (int i = 0; i < tamanhoIndice; i++) {

            if (vetor2[i] != vetor1[i]) {
                t++;
                break;
            }

        }

        return t == 0 ? true : false;

    }

    private static void exibeVetor(String nomeVetor, int[] vetor) {


        System.out.println(nomeVetor);
        for (int i = 0; i < vetor.length; i++) {
            System.out.print(" " + vetor[i]);
        }
        System.out.println();

    }

    public static void piscaComponente(JPanel painel, Color cor) {
        try {
            Color c = painel.getBackground();

            painel.setBackground(cor);
            painel.repaint();
            Thread.sleep(150);
            painel.setBackground(c);
            painel.repaint();
        } catch (InterruptedException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static boolean gravaArquivo(String conteudo) {
        FileOutputStream fos = null;
        try {
            // Gravando arquivo  
            File arquivo;

            arquivo = new File(FILE);
            fos = new FileOutputStream(arquivo, false);
            String texto = conteudo;
            fos.write(texto.getBytes());
            fos.close();

        } catch (Exception ex) {

            System.out.println(ex.getMessage());

        }
//      

        return true;
    }

    public static String leArquivo() {

        FileInputStream fis;
        StringBuilder sb = new StringBuilder();
        try {
            // Lendo do arquivo    
            File arquivo;
            arquivo = new File(FILE);
            fis = new FileInputStream(arquivo);


            int ln;
            while ((ln = fis.read()) != -1) {
                sb.append((char) ln);
            }

            fis.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return sb.toString();

    }
}
