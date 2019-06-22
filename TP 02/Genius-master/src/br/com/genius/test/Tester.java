/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.genius.test;

import br.com.genius.audio.AudioGerador;
import br.com.genius.util.Util;

/**
 *
 * @author fernandopucci
 */
public class Tester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//    int[] vetor = Util.geraVetorAleatorio(10); 
//    
//        for (int i = 0; i < vetor.length; i++) {
//            System.out.print(" " + vetor[i]);
//        }
//        System.out.println("");
//    }

        int[] vet1 = new int[]{1, 2, 3, 4, 5, 6};
        int[] vet2 = new int[6];
        vet2[0] = 1;
        vet2[1] = 2;
        vet2[2]= 2;
//        vet2[3]= 4;
//        vet2[4]= 5;
//        vet2[5]= 6;

//        System.out.println(Util.comparaVetores(vet1, vet2, 3));
        
        AudioGerador.geraAudio(Util.BOTAO_1_FREQ);

    }
}
