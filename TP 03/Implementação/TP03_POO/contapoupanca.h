#ifndef CONTAPOUPANCA
#define CONTAPOUPANCA

#include "library.h"

class ContaPoupanca : public Conta {
private:
    static int nContasPoupanca;
    double taxaRendimento;

public:
    // Construtores e Destrutores

    ContaPoupanca(string name, long cpf, long senha, double taxa);
    ~ContaPoupanca();

    // Métodos Get e Set

    void setNumero();
    void setTaxaRendimento(double t);
    double getTaxaRendimento();


    // Outros Métodos

    virtual void ImprimeDados();
};



#endif // CONTAPOUPANCA

