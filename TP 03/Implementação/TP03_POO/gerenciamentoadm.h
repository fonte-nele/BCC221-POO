#ifndef GERENCIAMENTOADM
#define GERENCIAMENTOADM


#include "library.h"


class GerenciamentoADM {
private:
    GerencBanco *gerencBancos;
    GerencClientes *gerencClientes;
    GerencContas *gerencContas;
    Banco *bancoAtual;
    int menu;
    long senhaAcesso;
    bool permissao;
public:
   GerenciamentoADM(long s);
   ~GerenciamentoADM();

   void ShowMenu();
   bool ConfereSenha();
};


#endif // GERENCIAMENTOADM

