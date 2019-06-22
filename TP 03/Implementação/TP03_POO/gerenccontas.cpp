
#include "library.h"

using namespace std;

   // Construtores e Destrutores
GerencContas :: GerencContas() {

}

GerencContas :: ~GerencContas() {

}
   // Funções Get e Set

void GerencContas :: setListadeContas(vector<Conta>::iterator c) {
    carteiraContas = c;
}

vector<Conta>::iterator GerencContas::getListadeContas() {
    return carteiraContas;
}


void GerencContas :: setListadeClientes(vector<Cliente>::iterator c) {
    cadastroClientes = c;
}


vector<Cliente>::iterator GerencContas :: getListadeClientes() {
    return cadastroClientes;
}


   // Outras Funções
void GerencContas :: ShowMenu() {
    menu = 0;

    do {
        cout << "\n------- BEM VINDO AO GERENCIAMENTO DE CONTAS  -------" << endl << endl;
        cout << "Escolha uma das opcoes a seguir:" << endl << endl;
        cout << "1- Mostrar Lista de Contas" << endl;
        cout << "2- Abrir uma Conta" << endl;
        cout << "3- Ativar uma Conta" << endl;
        cout << "4- Desativar uma Conta" << endl;
        cout << "5- Sair" << endl << endl;
        cout << "Digite a opcao desejada: " << endl;
        cin >> menu;
        cout << endl;

        if(menu < 1 || menu > 5)
            cout << "Opcao invalida, digite novamente." << endl;

    } while(menu < 1 || menu > 5);

    if(menu == 1)
        MostrarListaContas();
    else if(menu == 2)
        AbrirConta();
    else if(menu == 3)
        AtivarConta();
    else if(menu == 4)
        DesativarConta();

}


void GerencContas :: MostrarListaContas() {
    for(int i = 0; i < NMAX_CONTAS; i++) {
        if(carteiraContas[i].getNumeroConta() != -1 && carteiraContas[i].getEstado()) {
            // Realiza primeiro o Downcasting
           /* switch(carteiraContas[i].getTipoConta()) {
                case 1: // Conta Simples
                ContaSimples *ptr = dynamic_cast<ContaSimples*>(carteiraContas[i]);
                ptr->ImprimeDados();
                break;

                case 2: // Conta Especial
                ContaEspecial *ptr = dynamic_cast<ContaEspecial>(carteiraContas[i]);
                ptr->ImprimeDados();
                break;

                case 3: // Conta Poupanca
                ContaPoupanca *ptr = dynamic_cast<ContaPoupanca>(carteiraContas[i]);
                ptr->ImprimeDados();
                break;
            }*/
            carteiraContas[i].ImprimeDados();
        }
    }
}

void GerencContas :: AbrirConta() {
    long cpf, senha;
    int i, j, tipo;
    double limite, taxa;
    cout << "Digite o cpf do cliente que deseja abrir uma conta: ";
    cin >> cpf;

    // Procura o cliente
    for(i = 0; i < NMAX_CLIENTES; i++) {
        if(cadastroClientes[i].getCPF() == cpf)
            break;
    }

    // Se não o encontrar
    if(i == NMAX_CLIENTES) {
        cerr << "Cliente nao encontrado!" << endl;
        return;
    }

    cout << "Digite a senha da conta a ser criada: ";
    cin >> senha;
    cout << "1- Conta Simples\n" <<
            "2- Conta Especial\n" <<
            "3- Conta Poupanca\n " <<
            "Digite o tipo da conta: ";
    cin >> tipo;

    // Conta Especial
    if(tipo == 2) {
        cout << "Digite o limite da conta especial: ";
        cin >> limite;
        ContaEspecial contaCriada(cadastroClientes[i].getNome(), cpf, senha, limite);
        for(j = 0; j < NMAX_CONTAS; j++) {
            if(carteiraContas[j].getNumeroConta() == -1) {
                carteiraContas[j] = contaCriada;
                cadastroClientes[i].AdicionarConta(&carteiraContas[j]);
            }
            break;
        }
        // Caso ja excedeu o numero de contas que podem ser criadas
        if(j == NMAX_CONTAS) {
            cerr << "Numero maximo de contas excedido!" << endl;
            return;
        }
    }

    // Conta Poupanca
    if(tipo == 3) {
        cout << "Digite a taxa de rendimento da conta: ";
        cin >> taxa;
        ContaEspecial contaCriada(cadastroClientes[i].getNome(), cpf, senha, taxa);
        for(j = 0; j < NMAX_CONTAS; j++) {
            if(carteiraContas[j].getNumeroConta() == -1) {
                carteiraContas[j] = contaCriada;
                cadastroClientes[i].AdicionarConta(&carteiraContas[j]);
            }
            break;
        }
        // Caso ja excedeu o numero de contas que podem ser criadas
        if(j == NMAX_CONTAS) {
            cerr << "Numero maximo de contas excedido!" << endl;
            return;
        }
    }

    // Conta Simples

    ContaSimples contaCriada(cadastroClientes[i].getNome(), cpf, senha);
    carteiraContas[j] = contaCriada;
    cadastroClientes[i].AdicionarConta(&carteiraContas[j]);
}

void GerencContas :: AtivarConta() {
    long numero;
    cout << "Digite o numero da conta que deseja ativar: ";
    cin >> numero;
    char auxConfirma;

    for(int i = 0; i < NMAX_CONTAS; i++) {
        if(carteiraContas[i].getNumeroConta() == numero) {
            // Realiza primeiro o Downcasting
            /*switch(carteiraContas[i].getTipoConta()) {
                case 1: // Conta Simples
                ContaSimples *ptr = dynamic_cast<ContaSimples>(carteiraContas[i]);
                ptr->ImprimeDados();
                break;

                case 2: // Conta Especial
                ContaEspecial *ptr = dynamic_cast<ContaEspecial>(carteiraContas[i]);
                ptr->ImprimeDados();
                break;

                case 3: // Conta Poupanca
                ContaPoupanca *ptr = dynamic_cast<ContaPoupanca>(carteiraContas[i]);
                ptr->ImprimeDados();
                break;
            }*/
            carteiraContas[i].ImprimeDados();
            cout << "Deseja ativar esta conta? (S/N): ";
            cin >> auxConfirma;
            if(auxConfirma == 'S' || auxConfirma == 's') {
                carteiraContas[i].setEstado(true);
            }
            else {
                cout << "Operacao de ativacao cancelada!" << endl;
            }
            return;
        }
    }
}

void GerencContas :: DesativarConta() {
    long numero;
    cout << "Digite o numero da conta que deseja desativar: ";
    cin >> numero;
    char auxConfirma;

    for(int i = 0; i < NMAX_CONTAS; i++) {
        if(carteiraContas[i].getNumeroConta() == numero) {
            // Realiza primeiro o Downcasting
           /* switch(carteiraContas[i].getTipoConta()) {
                case 1: // Conta Simples
                ContaSimples *ptr = dynamic_cast<ContaSimples>(carteiraContas[i]);
                ptr->ImprimeDados();
                break;

                case 2: // Conta Especial
                ContaEspecial *ptr = dynamic_cast<ContaEspecial>(carteiraContas[i]);
                ptr->ImprimeDados();
                break;

                case 3: // Conta Poupanca
                ContaPoupanca *ptr = dynamic_cast<ContaPoupanca>(carteiraContas[i]);
                ptr->ImprimeDados();
                break;
            }*/
            cout << "Deseja desativar esta conta? (S/N): ";
            cin >> auxConfirma;
            if(auxConfirma == 'S' || auxConfirma == 's') {
                carteiraContas[i].setEstado(false);
                return;
            }
            else {
                cout << "Operacao de desativacao cancelada!" << endl;
                return;
            }

        }
    }
}




















