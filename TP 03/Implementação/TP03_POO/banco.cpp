#include "library.h"

using namespace std;



    // Construtores e Destrutores
Banco:: Banco() {
    setNome("");
}

Banco:: Banco(string name, long senha) {
    setNome(name);
    setSenhaAcesso(senha);
    nClientes = 0;
    nContas = 0;
    cadastroClientes.reserve(NMAX_CLIENTES);
    carteiraContas.reserve(NMAX_CONTAS);

}

Banco:: ~Banco() {
    cadastroClientes.clear();
    carteiraContas.clear();
}


    // Metodos Set e Get
void Banco:: setNome(string name) {
    nome = name;
}

void Banco:: setSenhaAcesso(long senha) {
    senhaAcessoGeral = senha;
}

void Banco:: setCliente() {

}

void Banco:: setConta() {

}

string Banco:: getNome() {
    return nome;
}

int Banco:: getNClientes() {
    return nClientes;
}

int Banco:: getNContas() {
    return nContas;
}

vector<Cliente>::iterator Banco:: getCadastroClientes() {
    return cadastroClientes.begin();
}

vector<Conta>::iterator Banco:: getCarteiraContas() {
    return carteiraContas.begin();
}


        // Outros Métodos


Cliente Banco::ProcuraCliente(long cpfCliente) {
    Cliente naoAchou;
    vector<Cliente>::iterator it = cadastroClientes.begin();
    unsigned int i = 0;
    while(i < cadastroClientes.size()) {

        // Achou o cliente
        if(cadastroClientes.at(i).getCPF() == cpfCliente) {
            naoAchou = *it;
            return naoAchou;
        }

        it++;   // incrementa a posição do iterador
        i++;
    }
    return naoAchou;
}

Conta Banco::ProcuraConta(long numConta) {
    Conta naoAchou;
    unsigned int i = 0;
    vector<Conta>::iterator it = carteiraContas.begin();
    while(i < carteiraContas.size()) {

        // Achou o cliente
        if(carteiraContas.at(i).getNumeroConta() == numConta) {
            naoAchou = *it;
            return naoAchou;
        }
        it++;    // incrementa a posição do iterador
        i++;
    }
    return naoAchou;
}




















