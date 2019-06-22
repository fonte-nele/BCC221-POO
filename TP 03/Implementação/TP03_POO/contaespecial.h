#ifndef CONTAESPECIAL
#define CONTAESPECIAL

#include "library.h"


class ContaEspecial : public Conta {
private:
    static int nContasEspeciais;
    double limiteSaque;

public:
    // Construtores e Destrutores
    ContaEspecial(string name, long cpf, long senha, double limite);
    ~ContaEspecial();

    // Métodos Get e Set
    void setLimite(double lim);
    double getLimite();
    void setNumero();

    // Outros Métodos

    virtual void ImprimeDados();

};



#endif // CONTAESPECIAL

