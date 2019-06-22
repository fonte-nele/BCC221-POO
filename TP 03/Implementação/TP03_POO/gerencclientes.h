#ifndef GERENCCLIENTES
#define GERENCCLIENTES


#include "library.h"

class GerencClientes {
    vector<Cliente>::iterator cadastroClientes;     // Cria uma lista encadeada de clientes presentes no banco
    int menu;
public:
   // Construtores e Destrutores
   GerencClientes();
   ~GerencClientes();

   // Funções get e set
   void setListadeClientes(vector<Cliente>::iterator c);
   vector<Cliente>::iterator getListadeClientes();

   // Outras Funções
   void ShowMenu();
   void MostrarListaClientes();
   void AdicionarCliente();
   void RemoverCliente();

};







#endif // GERENCCLIENTES

