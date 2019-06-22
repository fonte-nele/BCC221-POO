#include "library.h"

using namespace std;


void Criar_Bancos_Iniciais() {

    ifstream confereBanco("Bancos.bin", ios::binary);

    // Confere se o arquivo já existe
    if(!confereBanco) {
        //Banco blankBank("vazio", 0);
        Banco blankBank;
        confereBanco.close();

        ofstream criadorBancos("Bancos.bin",  ios::out | ios::binary);

        if(!criadorBancos) {
            cerr << "Nao foi possivel criar bancos.bin" << endl;
            criadorBancos.close();
            confereBanco.close();
            return;
        }

        for(int i = 0; i < NMAX_BANCOS; i++)
            criadorBancos.write(reinterpret_cast<const char*>(&blankBank), sizeof(Banco));
        criadorBancos.close();
    }
    else
        confereBanco.close();

}

void MainMenu(int *menu) {
    do {
        cout << "--------- MENU INICIAL ---------" << endl << endl;
        cout << "Selecione uma das opcoes a seguir:" << endl;
        cout << "1- Gerenciamento Administrativo" << endl;
        cout << "2- Caixa Automatico" << endl;
        cout << "3- Sair" << endl << endl;
        cout << "Digite sua alternativa: ";
        cin >> (*menu);
        cout << endl;
    } while ((*menu) < 1 || (*menu) > 3);
}

