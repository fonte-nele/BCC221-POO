#include "contaespecial.h"

        // Construtores e Destrutores

ContaEspecial::ContaEspecial(string name, long cpf, long senha, double limite) {
    setNumero();
    nomeTitular = name;
    cpfTitular = cpf;
    senhaAcesso = senha;
    tipoConta = 2;
    saldo = 0;
    estado = true;
    setLimite(limite);
    nContasEspeciais++;
    listaMovimentacoes.reserve(NMAX_EVENTOS);
}

ContaEspecial::~ContaEspecial() {
    nContasEspeciais--;
}

    // Métodos Get e Set
void ContaEspecial::setLimite(double lim) {
    limiteSaque = lim;
}

double ContaEspecial::getLimite() {
    return limiteSaque;
}

void ContaEspecial::setNumero() {
        numero = nContasEspeciais + NMAX_CONTAS;
}

    // Outros Métodos

void ContaEspecial::ImprimeDados() {
    cout << "Nome Titular: " << nomeTitular << endl;
    cout << "CPF Titular: " << cpfTitular << endl;
    cout << "Numero da Conta: " << numero << endl;
    cout << "Saldo: " << saldo << endl;
    cout << "Limite: " << limiteSaque << endl;
    cout << "Lista de Movimentacoes: " << endl;
    // Imprime a Lista de Movimentações
    for (unsigned int i = 0; i < listaMovimentacoes.size(); i++)
        listaMovimentacoes.at(i).ImprimeDados();
}
