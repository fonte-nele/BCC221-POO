#include "library.h"

using namespace std;

        // Construtores e Destrutores

Cliente::Cliente(string name, long cpf, string end) {
    setNome(name);
    setCPF(cpf);
    setEndereco(end);
    conta = NULL;
}

Cliente::Cliente() {
    setNome("vazio");
    setCPF(-1);
    setEndereco("vazio");
    conta = NULL;
}

Cliente::~Cliente() {
    //contas.clear();
}

        // Funções Get e Set

void Cliente::setNome(string name) {
    nome = name;
}

void Cliente:: setCPF(long cpf) {
    CPF = cpf;
}

void Cliente::setEndereco(string end) {
    endereco = end;
}

string Cliente::getNome() {
    return nome;
}

long Cliente::getCPF() {
    return CPF;
}

string Cliente::getEndereco() {
    return endereco;
}

        // Outras Funções

void Cliente::AdicionarConta(Conta *c) {
    conta = c;
}

void Cliente::DeletarConta() {
    conta = NULL;
}

void Cliente::MostrarDados() {

    cout << "\nNome: " << getNome() << endl;
    cout << "CPF: " << getCPF() << endl;
    cout << "Endereco: " << getEndereco() << endl;
    if(conta != NULL)
        cout << "Numero da Conta: " << conta->getNumeroConta() << endl << endl;
    else
        cout << "Sem conta existente" << endl << endl;

}























