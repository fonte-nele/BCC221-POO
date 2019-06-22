#ifndef GERENCBANCO
#define GERENCBANCO


#include "library.h"

class GerencBanco {
private:
    int menu;
    Banco *bancoAtual;
public:
   // Construtores e Destrutores
   GerencBanco();
   ~GerencBanco();

   // Métodos Get e Set
   void setBancoAtual(Banco* b);

   // Outros Métodos
   void ShowMenu();
   void CriarBanco();
   void SelecionarBanco();
   Banco* getBancoAtual();


};












#endif // GERENCBANCO

