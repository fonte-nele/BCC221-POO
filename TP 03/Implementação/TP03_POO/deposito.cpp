
#include "library.h"

using namespace std;

        // Construtores e Destrutores

Deposito::Deposito(){
    tipoEvento = 2;
}


        // Outros Métodos
void Deposito::ImprimeDados() {
    cout << "Deposito de R$" << valor << endl;
    cout << "Na conta de numero " << paraQualConta << endl << endl;
}
int Deposito::RealizaDeposito(Conta *c, double valor) {
    paraQualConta = c->getNumeroConta();
    c->Deposita(valor);
    return 1;
}

