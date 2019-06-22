
#include "library.h"

using namespace std;


    // Construtores e Destrutores

GerencClientes :: GerencClientes() {

}

GerencClientes :: ~GerencClientes() {

}




    // Funções get e set
void GerencClientes :: setListadeClientes(vector<Cliente>::iterator c) {
    cadastroClientes = c;
}


vector<Cliente>::iterator GerencClientes :: getListadeClientes() {
    return cadastroClientes;
}




    // Outras Funções

void GerencClientes :: ShowMenu() {
    menu = 0;

    do {
        cout << "\n------- BEM VINDO AO GERENCIAMENTO DE CLIENTES -------" << endl << endl;
        cout << "Escolha uma das opcoes a seguir:" << endl << endl;
        cout << "1- Mostrar lista de Clientes" << endl;
        cout << "2- Adicionar um Cliente" << endl;
        cout << "3- Remover um Cliente" << endl;
        cout << "4- Sair" << endl << endl;
        cout << "Digite a opcao desejada: " << endl;
        cin >> menu;
        cout << endl;

        if(menu < 1 || menu > 4)
            cout << "Opcao invalida, digite novamente." << endl;

    } while(menu < 1 || menu > 4);

    if(menu == 1)
        MostrarListaClientes();
    else if(menu == 2)
        AdicionarCliente();
    else if(menu == 3)
        RemoverCliente();
}


void GerencClientes :: MostrarListaClientes() {
    for(int i = 0; i < NMAX_CLIENTES; i++)
        cadastroClientes[i].MostrarDados();
}

void GerencClientes :: AdicionarCliente() {
    string name, endereco;
    long cpf;
    cout << "Digite o nome do cliente: ";
    cin >> name;
    cout << "Digite o cpf do cliente: ";
    cin >> cpf;
    cout << "Digite o endereco do cliente: ";
    cin >> endereco;
    for(int i = 0; i < NMAX_CLIENTES; i++) {
        if(cadastroClientes[i].getCPF() == cpf) {
            cerr << "Cliente ja cadastrado." << endl;
            return;
        }
        if(cadastroClientes[i].getCPF() == 0) {
            Cliente c(name, cpf, endereco);
            cadastroClientes[i] = c;
            cout << "Cliente cadastrado na posicao " << i << endl;
            return;
        }
    }
    cout << "Numero maximo de clientes atingido" << endl;
}

void GerencClientes :: RemoverCliente() {
    long cpf;
    char auxConfirma;
    cout << "Digite o cpf do cliente que deseja remover: " << endl;
    cin >> cpf;

    for(int i = 0; i < NMAX_CLIENTES; i++) {
        if(cadastroClientes[i].getCPF() == cpf) {
            cout << "Cliente encontrado:" << endl;
            cadastroClientes[i].MostrarDados();
            cout << "Deseja realmente deletar este cliente? (S/N): ";
            cin >> auxConfirma;
            if(auxConfirma == 'S' || auxConfirma == 's') {
                cadastroClientes[i].DeletarConta();
                cadastroClientes[i].setNome("vazio");
                cadastroClientes[i].setCPF(0);
                cadastroClientes[i].setEndereco("vazio");
                cout << "Cliente deletado!" << endl;
            }
            else {
                cout << "Operacao de remocao de cliente cancelada!" << endl;
                return;
            }
        }
    }
}




























