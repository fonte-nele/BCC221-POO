#ifndef DEPOSITO
#define DEPOSITO

#include "library.h"


class Deposito : public Evento {
private:
    long numeroConta;
public:
    // Construtores e Destrutores

    Deposito();

    // Outros Métodos
    virtual void ImprimeDados();
    int RealizaDeposito(Conta *c, double valor);
};




#endif // DEPOSITO

