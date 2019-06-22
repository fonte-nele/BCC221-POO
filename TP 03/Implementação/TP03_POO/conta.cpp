#include "library.h"

        // Construtores e Destrutores
Conta::Conta() {
    numero = -1;
}

        // Funções Set


void Conta::setSenha(long senha) {
    senhaAcesso = senha;
}

void Conta::setEstado(bool e) {
    estado = e;
}

        // Funções Get

long Conta::getNumeroConta() {
    return numero;
}

long Conta::getSenha() {
    return senhaAcesso;
}

long Conta::getSaldo() {
    return saldo;
}

long Conta::getEstado() {
    return estado;
}
int Conta::getTipoConta() {
    return tipoConta;
}

string Conta::getNomeTitular() {
    return nomeTitular;
}

        // Outras Funções

void Conta::addEvento(Evento *evento) {
    listaMovimentacoes.insert(listaMovimentacoes.end(), (*evento));
}

void Conta::ImprimeDados() {
    cout << "Impressao invalida" << endl;
}

void Conta::Retira(double valor) {
    saldo -= valor;
}

void Conta::Deposita(double valor) {
    saldo += valor;
}










