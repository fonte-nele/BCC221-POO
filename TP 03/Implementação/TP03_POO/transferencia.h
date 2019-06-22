#ifndef TRANSFERENCIA
#define TRANSFERENCIA

#include "library.h"

class Transferencia : public Evento {

private:
    long deQualConta;
public:
    // Construtores e Destrutores

    Transferencia();

    // Outros Métodos
    virtual void ImprimeDados();
    int RealizaTransferencia(Conta paraQual, Conta deQual, double valor);
};







#endif // TRANSFERENCIA

