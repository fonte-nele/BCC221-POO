#include "library.h"

using namespace std;
int ContaSimples::nContasSimples = 0;
int ContaEspecial::nContasEspeciais = 0;
int ContaPoupanca::nContasPoupanca = 0;

int main()
{
    long senhaADM;
    int menu;
    GerenciamentoADM *gerenc;
    CaixaAutomatico *caixa;
    cout << "Digite a senha do Gerenciamento Administrativo: ";
    cin >> senhaADM;

    gerenc = new GerenciamentoADM(senhaADM);
    caixa = new CaixaAutomatico;
    Criar_Bancos_Iniciais();

    MainMenu(&menu);
    if(menu == 1){
        if(gerenc->ConfereSenha())
            gerenc->ShowMenu();
    }
    else if(menu == 2){
        caixa->menuInicial();
    }

    delete gerenc;
    delete caixa;
    return 0;
}

