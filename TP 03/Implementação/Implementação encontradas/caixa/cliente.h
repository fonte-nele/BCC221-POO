#ifndef CAIXA__CLIENTE_H
#define CAIXA__CLIENTE_H

#include <string>
#include <iostream>
using namespace std;

class cliente
{
private:
   int cpf;
   string nome;
   string endereco;

public:
   cliente(int cpf = 0, string nome = "", string endereco = "")
      : cpf{cpf}, nome{nome}, endereco{endereco}
   {}
   int get_cpf() const { return cpf; }
   string get_nome() const { return nome; }
   string get_endereco() const { return endereco; }

   friend ostream& operator<<(ostream& os, const cliente& c);
   friend istream& operator>>(istream& is, cliente& c);
};

#endif
