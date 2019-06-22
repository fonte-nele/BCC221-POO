
#include "library.h"

using namespace std;


        // Construtores e Destrutores

GerencBanco :: GerencBanco() {
    bancoAtual = NULL;
}

GerencBanco :: ~GerencBanco() {

}

// Métodos Get e Set
void GerencBanco :: setBancoAtual(Banco* b) {
    bancoAtual = b;
}
    // Outros Métodos
void GerencBanco :: ShowMenu() {
    menu = 0;

    do {
        cout << "\n------- BEM VINDO AO GERENCIAMENTO BANCARIO -------" << endl << endl;
        cout << "Escolha uma das opcoes a seguir:" << endl << endl;
        cout << "1- Criar Banco" << endl;
        cout << "2- Selecionar Banco" << endl;
        cout << "3- Sair" << endl << endl;
        cout << "Digite a opcao desejada: " << endl;
        cin >> menu;
        cout << endl;

        if(menu < 1 || menu > 3)
            cout << "Opcao invalida, digite novamente." << endl;

    } while(menu < 1 || menu > 3);

    if(menu == 1)
        CriarBanco();
    else if(menu == 2)
        SelecionarBanco();

}


void GerencBanco :: CriarBanco() {
    string nome;
    int i;
    Banco bank;
    cout << "Digite o nome do banco que deseja criar: ";
    cin >> nome;

    fstream confereBanco("Bancos.bin", ios::in | ios::out | ios::binary);

    if(!confereBanco) {
        cerr << "Nao foi possivel abrir bancos.bin" << endl;
        return;

    } else {

        // Confere se já existe um banco com esse nome

        for(i = 0; i < NMAX_BANCOS; i++) {
            confereBanco.read(reinterpret_cast<char*>(&bank), sizeof(Banco));
            if(bank.getNome().compare(nome) == 0) {
                cerr << "Nome ja existente" << endl;
                confereBanco.close();
                return;
            }
        }
        cout << "conferiu" << endl;

        long senha;
        cout << "Digite a senha de acesso desejada: ";
        cin >> senha;
        Banco banco(nome,senha);

        ofstream criaBanco("Bancos.bin", ios::binary);
        confereBanco.seekg(0, ios::beg);

        // Procura onde tem um espaço vazio
        for(i = 0; i < NMAX_BANCOS; i++) {
            confereBanco.read(reinterpret_cast<char*>(&bank), sizeof(Banco));
            // caso ache um espaço vazio
            if(bank.getNome().compare("vazio") == 0) {
                criaBanco.write(reinterpret_cast<const char*>(&banco), sizeof(Banco));
                cout << "Banco adicionado com sucesso" << endl;
                break;
            }
        }
        if(i == NMAX_BANCOS)
            cout << "Lista de Bancos cheia!" << endl;
        confereBanco.close();
        criaBanco.close();
    }
}

void GerencBanco :: SelecionarBanco() {

    string nome;
    Banco *bank;
    cout << "Digite o nome do banco que deseja abrir: ";
    cin >> nome;

    ifstream abreBanco("Bancos.bin", ios::in | ios::binary);

    if(!abreBanco) {
        cerr << "Nao foi possivel abrir bancos.bin" << endl;
    } else {

        // Procura o banco no Sistema de bancos
        for(int i = 0; i < NMAX_BANCOS; i++) {
            abreBanco.read(reinterpret_cast<char*>(&bank), sizeof(Banco));
            if(bank->getNome() == nome) {
                bancoAtual = bank;
                abreBanco.close();
                return;
            }
        }

        // Caso o banco não exista
        cerr << "Banco nao encontrado";
        abreBanco.close();
    }
}

Banco* GerencBanco :: getBancoAtual() {
    return bancoAtual;
}
