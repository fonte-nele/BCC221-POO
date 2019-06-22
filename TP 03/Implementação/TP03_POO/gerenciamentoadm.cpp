
#include "library.h"

using namespace std;




GerenciamentoADM :: GerenciamentoADM(long s) {
    gerencBancos = new GerencBanco();
    gerencClientes = new GerencClientes();
    gerencContas = new GerencContas();
    senhaAcesso = s;
    permissao = false;
}


GerenciamentoADM :: ~GerenciamentoADM() {
    delete[] gerencBancos;
    delete[] gerencClientes;
    delete[] gerencContas;
}

void GerenciamentoADM :: ShowMenu() {
    if(permissao) {
        menu = 0;
        while(menu != 4) {

                cout << "\n------- BEM VINDO AO GERENCIAMENTO ADMINISTRATIVO -------" << endl << endl;
                cout << "Escolha uma das opcoes a seguir:" << endl << endl;
                cout << "1- Genciamento de Bancos" << endl;
                cout << "2- Genciamento de Clientes" << endl;
                cout << "3- Genciamento de Contas" << endl;
                cout << "4- Sair" << endl << endl;
                cout << "Digite a opcao desejada: " << endl;
                cin >> menu;
                cout << endl;

                if(menu < 1 || menu > 4) {
                    cout << "Opcao invalida, digite novamente." << endl;
                    menu = 0;
                    continue;
                }


            switch(menu) {
                case 1:
                    gerencBancos->ShowMenu();
                    break;
                case 2:
                    if(bancoAtual == NULL) {
                        cout << "Escolha um banco" << endl;
                        menu = 0;
                        continue;
                    } else
                        gerencClientes->ShowMenu();
                    break;
                case 3:
                    if(bancoAtual == NULL) {
                        cout << "Escolha um banco" << endl;
                        menu = 0;
                        continue;
                    } else
                        gerencContas->ShowMenu();
                    break;
                case 4:
                    return;
            }
            bancoAtual = gerencBancos->getBancoAtual();
            gerencClientes->setListadeClientes(bancoAtual->getCadastroClientes());
            gerencContas->setListadeClientes(bancoAtual->getCadastroClientes());
            gerencContas->setListadeContas(bancoAtual->getCarteiraContas());

        }
    }
    else {
        cout << "ACESSO NEGADO!" << endl;
    }
}


bool GerenciamentoADM :: ConfereSenha() {

    long s;
    unsigned int erros = 0;
    while(erros < NMAX_ERROS) {
        cout << "DIGITE A SENHA PARA ACESSO: ";
        cin >> s;

        if(s == senhaAcesso) {
            permissao = true;
            break;
        }
        else {
            permissao = false;
            erros++;
        }
        if(erros == NMAX_ERROS) {
            cout << "Numero maximo de erros atingido!" << endl;
        }
        cout << "Senha Incorreta!" << endl;
    }
    return permissao;
}





























