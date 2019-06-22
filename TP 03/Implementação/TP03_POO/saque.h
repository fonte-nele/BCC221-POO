#ifndef SAQUE
#define SAQUE




#include "library.h"

class Saque : public Evento {
private:
public:
    // Construtores e Destrutores
    Saque();

    // Outros Métodos
    virtual void ImprimeDados();
    int RealizaSaque(Conta *c, double valor);
};





#endif // SAQUE

