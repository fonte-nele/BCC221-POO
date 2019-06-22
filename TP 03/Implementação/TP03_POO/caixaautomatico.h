#ifndef CAIXAAUTOMATICO
#define CAIXAAUTOMATICO

#include "library.h"



class CaixaAutomatico {
private:
    Conta contaAtual;
    int posConta;
    Banco qualBanco;
    int posBanco;
    int opcao;

public:

    // Construtores e Destrutores
    CaixaAutomatico();
    ~CaixaAutomatico();

    // Outros Métodos
    void menuInicial();
    void menuCaixa();

    void consultaSaldo();
    void consultaExtrato();
    void fazDeposito();
    void fazSaque();
    void fazTransferencia();

};










#endif // CAIXAAUTOMATICO

