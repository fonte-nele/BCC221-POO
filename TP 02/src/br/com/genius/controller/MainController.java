package br.com.genius.controller;

import br.com.genius.audio.AudioGerador;
import br.com.genius.util.Util;
import br.com.genius.view.Main;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractButton;

/**
 *
 * @author fernandopucci
 */
public class MainController {

    //
    //
    private Main principal;
    //
    private int jogadaCPU;
    private int jogadaJogador;
    //
    private int[] vetorCPU;
    private int[] vetorPlayer;
    //
    private boolean isJogadaHabilitada = false;

    public MainController(Main main) {

        this.principal = main;
        this.vetorCPU = Util.geraVetorAleatorio(Util.QUANTIDADE_TOTAL_JOGADAS);
        this.vetorPlayer = new int[Util.QUANTIDADE_TOTAL_JOGADAS];
        this.jogadaCPU = 0;
        this.jogadaJogador = 0;

    }

    public void acao(String botao) {
//        System.out.println(botao);
    }

    public Thread getThreadRodar() {
        return new Thread() {

            public void run() {
                try {

                    isJogadaHabilitada = false;

                    principal.showJogue(isJogadaHabilitada);

                    Thread.sleep(Util.TIME);

                    for (int i = 0; i < jogadaCPU; i++) {

                        switch (vetorCPU[i]) {

                            case 1:
                                principal.paintCampo(principal.getBotao1());

                                AudioGerador.geraAudio(Util.BOTAO_1_FREQ);
                                AudioGerador.executarSom();
                                Thread.sleep(Util.TIME);
                                principal.unPaintAll();
                                Thread.sleep(Util.TIME / 2);
                                break;
                            case 2:
                                principal.paintCampo(principal.getBotao2());
                                AudioGerador.geraAudio(Util.BOTAO_2_FREQ);
                                AudioGerador.executarSom();
                                Thread.sleep(Util.TIME);
                                principal.unPaintAll();
                                Thread.sleep(Util.TIME / 2);
                                break;
                            case 3:
                                principal.paintCampo(principal.getBotao3());
                                AudioGerador.geraAudio(Util.BOTAO_3_FREQ);
                                AudioGerador.executarSom();
                                Thread.sleep(Util.TIME);
                                principal.unPaintAll();
                                Thread.sleep(Util.TIME / 2);
                                break;
                            case 4:
                                principal.paintCampo(principal.getBotao4());
                                AudioGerador.geraAudio(Util.BOTAO_4_FREQ);
                                AudioGerador.executarSom();
                                Thread.sleep(Util.TIME);
                                principal.unPaintAll();
                                Thread.sleep(Util.TIME / 2);
                                break;
                            default:
                                principal.unPaintAll();
                                break;
                        }
                    }

                    isJogadaHabilitada = true;
                    principal.showJogue(isJogadaHabilitada);

                } catch (InterruptedException ex) {
                    Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
    }

    private void trataJogada(int botao) {

        switch (botao) {
            case 1:
                vetorPlayer[jogadaJogador] = botao;
                break;
            case 2:
                vetorPlayer[jogadaJogador] = botao;
                break;
            case 3:
                vetorPlayer[jogadaJogador] = botao;
                break;
            case 4:
                vetorPlayer[jogadaJogador] = botao;
                break;
        }


        jogadaJogador++;

        if (Util.comparaVetores(vetorCPU, vetorPlayer, jogadaJogador)) {
            if (jogadaJogador == jogadaCPU) {
                getThreadPiscarSucesso().start();
                principal.incrementaPontos();

                if (jogadaCPU == vetorCPU.length) {

                    principal.finaliza(true);

                } else {

                    limpaJogadaPlayer();
                    jogadaCPU++;

                    getThreadRodar().start();

                }
            }
        } else {

            getThreadPiscarErro().start();
            principal.finaliza(false);

        }

    }

    private Thread getThreadPiscarErro() {
        return new Thread() {

            public void run() {

                principal.piscaErro();

            }
        };
    }

    private Thread getThreadPiscarSucesso() {
        return new Thread() {

            public void run() {

                principal.piscaSucesso();

            }
        };
    }

    private Thread getThreadBotao1() {
        return new Thread() {

            public void run() {

                trataJogada(1);
            }
        };
    }

    private Thread getThreadBotao2() {
        return new Thread() {

            public void run() {

                trataJogada(2);
            }
        };
    }

    private Thread getThreadBotao3() {
        return new Thread() {

            public void run() {

                trataJogada(3);
            }
        };
    }

    private Thread getThreadBotao4() {
        return new Thread() {

            public void run() {

                trataJogada(4);
            }
        };
    }

    public void acao(AbstractButton botao) {

        if (botao.isEnabled()) {
            if (botao.getName().equals("bt1") && isJogadaHabilitada) {
                AudioGerador.executarSom();

                botao.setBackground(Util.COR_BOTAO_1_CLICADO);
                AudioGerador.geraAudio(Util.BOTAO_1_FREQ);


            } else if (botao.getName().equals("bt2") && isJogadaHabilitada) {
                AudioGerador.executarSom();

                botao.setBackground(Util.COR_BOTAO_2_CLICADO);
                AudioGerador.geraAudio(Util.BOTAO_2_FREQ);


            } else if (botao.getName().equals("bt3") && isJogadaHabilitada) {
                AudioGerador.executarSom();

                botao.setBackground(Util.COR_BOTAO_3_CLICADO);
                AudioGerador.geraAudio(Util.BOTAO_3_FREQ);

            } else if (botao.getName().equals("bt4") && isJogadaHabilitada) {
                AudioGerador.executarSom();

                botao.setBackground(Util.COR_BOTAO_4_CLICADO);
                AudioGerador.geraAudio(Util.BOTAO_4_FREQ);
            }
        }
    }

    public void acaoControle(String botao) {

        if (botao.equals("botaoIniciar")) {

            principal.habilitaBotaoIniciar(false);

            if (jogadaCPU == 0) {

                jogadaCPU++;

            }

            getThreadRodar().start();

        } else if (botao.equals("bt1") && isJogadaHabilitada) {
            isJogadaHabilitada = false;
//            AudioGerador.geraAudio(Util.BOTAO_1_FREQ);
            isJogadaHabilitada = true;

//            getThreadBotao1().start();
//            trataJogada(1);
        } else if (botao.equals("bt2") && isJogadaHabilitada) {
            isJogadaHabilitada = false;
//            AudioGerador.geraAudio(Util.BOTAO_2_FREQ);
            isJogadaHabilitada = true;
//            getThreadBotao2().start();
//            trataJogada(2);

        } else if (botao.equals("bt3") && isJogadaHabilitada) {
            isJogadaHabilitada = false;
//            AudioGerador.geraAudio(Util.BOTAO_3_FREQ);
            isJogadaHabilitada = true;
//            getThreadBotao3().start();
//            trataJogada(3);
        } else if (botao.equals("bt4") && isJogadaHabilitada) {
            isJogadaHabilitada = false;
//            AudioGerador.geraAudio(Util.BOTAO_4_FREQ);
            isJogadaHabilitada = true;
//            getThreadBotao4().start();
//            trataJogada(4);
        }

    }

    public void acaoControle(AbstractButton botao) {

        if (botao.isEnabled()) {
            acaoControle(botao.getName());
        }
    }

    public void acaoRelease(AbstractButton botao) {
        if (botao.isEnabled()) {

            if (botao.getName().equals("bt1") && isJogadaHabilitada) {

                botao.setBackground(Util.COR_BOTAO_1);
                getThreadBotao1().start();


            } else if (botao.getName().equals("bt2") && isJogadaHabilitada) {

                botao.setBackground(Util.COR_BOTAO_2);
                getThreadBotao2().start();

            } else if (botao.getName().equals("bt3") && isJogadaHabilitada) {

                botao.setBackground(Util.COR_BOTAO_3);
                getThreadBotao3().start();

            } else if (botao.getName().equals("bt4") && isJogadaHabilitada) {

                botao.setBackground(Util.COR_BOTAO_4);
                getThreadBotao4().start();

            }
        }

    }

    private void limpaJogadaPlayer() {
        vetorPlayer = new int[Util.QUANTIDADE_TOTAL_JOGADAS];
        jogadaJogador = 0;
    }
}
