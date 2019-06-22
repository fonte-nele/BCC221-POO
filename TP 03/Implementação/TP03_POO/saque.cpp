#include "library.h"

using namespace std;

        // Construtores e Destrutores

Saque::Saque(){
    tipoEvento = 1;
}


        // Outros Métodos
void Saque::ImprimeDados() {
    cout << "Saque de R$" << valor << endl;
    cout << "Na conta de numero " << paraQualConta << endl << endl;
}

int Saque::RealizaSaque(Conta *c, double valor) {
    paraQualConta = c->getNumeroConta();
    if(c->getTipoConta() == 2)
    {
       ContaEspecial *ptr;
       ptr = dynamic_cast<ContaEspecial*>(c);
        if((ptr->getSaldo() + ptr->getLimite()) >= valor)
        {
            ptr->Retira(valor);
            return 1;
        }else{
            cout << "Não a limite disponível para realizar o saque" <<endl;
            return 0;
        }
    }
        else
    {
        if(c->getSaldo() >= valor)
        {
          c->Retira(valor);
          return 1;
        }else{
            cout << "Não e possivel realizar o saque" <<endl;
            return 0;
        }
    }

}
















