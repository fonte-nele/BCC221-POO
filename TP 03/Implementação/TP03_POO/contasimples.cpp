
#include "contasimples.h"

        // Construtores e Destrutores

ContaSimples::ContaSimples(string name, long cpf, long senha) {
    setNumero();
    tipoConta = 1;
    nomeTitular = name;
    cpfTitular = cpf;
    senhaAcesso = senha;
    saldo = 0;
    estado = true;
    nContasSimples++;
    listaMovimentacoes.reserve(NMAX_EVENTOS);
}

ContaSimples::~ContaSimples() {
    nContasSimples--;
}

        // Métodos Get e Set

void ContaSimples::setNumero() {
    numero = nContasSimples;
}


        // Outros Métodos

void ContaSimples::ImprimeDados() {
    cout << "Nome Titular: " << nomeTitular << endl;
    cout << "CPF Titular: " << cpfTitular << endl;
    cout << "Numero da Conta: " << numero << endl;
    cout << "Saldo: " << saldo << endl;
    cout << "Lista de Movimentacoes: " << endl;
    // Imprime a Lista de Movimentações
     for (unsigned int i = 0; i < listaMovimentacoes.size(); i++)
        listaMovimentacoes.at(i).ImprimeDados();
}


























