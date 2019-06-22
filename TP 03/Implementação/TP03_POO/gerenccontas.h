#ifndef GERENCCONTAS
#define GERENCCONTAS

#include "library.h"

class GerencContas {
private:
   vector<Conta>::iterator carteiraContas;     // Cria uma lista encadeada de contas presentes no banco
   vector<Cliente>::iterator cadastroClientes;
   int menu;
public:

   // Construtores e Destrutores
   GerencContas();
   ~GerencContas();

   // Funções Get e Set
   void setListadeContas(vector<Conta>::iterator c);
   vector<Conta>::iterator getListadeContas();
   void setListadeClientes(vector<Cliente>::iterator c);
   vector<Cliente>::iterator getListadeClientes();

   // Outras Funções
   void ShowMenu();
   void MostrarListaContas();
   void AbrirConta();
   void AtivarConta();
   void DesativarConta();

};












#endif // GERENCCONTAS

