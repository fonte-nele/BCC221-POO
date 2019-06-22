#include "library.h"

using namespace std;


    // Construtores e Destrutores

Transferencia::Transferencia() {
    tipoEvento = 3;

}


    // Outros Métodos
void Transferencia::ImprimeDados() {
    cout << "Transferencia de R$" << valor << endl;
    cout << "Da conta de numero " << deQualConta << endl;
    cout << "Para a conta de numero " << paraQualConta << endl << endl;
}


int Transferencia::RealizaTransferencia(Conta paraQual, Conta deQual, double valor) {
    deQualConta = deQual.getNumeroConta();
    paraQualConta = paraQual.getNumeroConta();
    if(deQual.getTipoConta() == 2){
        ContaEspecial *ptr;
        ptr = dynamic_cast<ContaEspecial*>(&deQual);
        if((ptr->getSaldo() + ptr->getLimite()) >= valor)
        {
            ptr->Retira(valor);
            paraQual.Deposita(valor);
            return 1;
        } else {
            cout << "Saldo insuficiente para completar a transferencia" << endl;
            return 0;
        }
    }else{
          if(deQual.getSaldo() >= valor)
        {
            deQual.Retira(valor);
            paraQual.Deposita(valor);
            return 1;
        } else {
              cout << "Saldo insuficiente para completar a transferencia" << endl;
              return 0;
          }
    }
}

















