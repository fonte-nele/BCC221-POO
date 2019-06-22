#ifndef CONTASIMPLES
#define CONTASIMPLES


#include "library.h"

class ContaSimples : public Conta {
private:
    static int nContasSimples;
public:
    // Construtores e Destrutores
    ContaSimples(string name, long cpf, long senha);
    ~ContaSimples();

    // Métodos Get e Set
    void setNumero();

    // Outros Métodos

    virtual void ImprimeDados();
};


#endif // CONTASIMPLES

