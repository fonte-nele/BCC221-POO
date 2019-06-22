#include "library.h"

        // Construtores e Destrutores

ContaPoupanca::ContaPoupanca(string name, long cpf, long senha, double taxa) {
    setNumero();
    tipoConta = 3;
    nomeTitular = name;
    cpfTitular = cpf;
    senhaAcesso = senha;
    saldo = 0;
    estado = true;
    setTaxaRendimento(taxa);
    nContasPoupanca++;
    listaMovimentacoes.reserve(NMAX_EVENTOS);
}

ContaPoupanca::~ContaPoupanca() {
    nContasPoupanca--;
}


        // Métodos Get e Set
void ContaPoupanca::setNumero() {
    numero = nContasPoupanca + (NMAX_CONTAS * 2);
}

void ContaPoupanca::setTaxaRendimento(double t) {
    taxaRendimento = t;
}

double ContaPoupanca::getTaxaRendimento() {
    return taxaRendimento;
}


        // Outros Métodos

void ContaPoupanca::ImprimeDados() {
    cout << "Nome Titular: " << nomeTitular << endl;
    cout << "CPF Titular: " << cpfTitular << endl;
    cout << "Numero da Conta: " << numero << endl;
    cout << "Saldo: " << saldo << endl;
    cout << "Taxa de Rendimento: " << taxaRendimento << endl;
    cout << "Lista de Movimentacoes: " << endl;
    // Imprime a Lista de Movimentações
    for (unsigned int i = 0; i < listaMovimentacoes.size(); i++)
        listaMovimentacoes.at(i).ImprimeDados();
}
