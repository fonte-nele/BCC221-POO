#ifndef CAIXA_BANCO_H
#define CAIXA_BANCO_H

#include <vector>
#include "cliente.h"
#include "conta.h"

using namespace std;

class banco
{
private:
   vector<cliente> clientes;
   vector<conta> contas;
   int proxima_conta;

public:
   banco() : proxima_conta(1) { }

   banco(vector<cliente> const &clientes, vector<conta> const &contas, int proxima_conta)
      : clientes(clientes), contas(contas), proxima_conta(proxima_conta)
   { }

   void caixa_automatico();

   ostream& write(ostream& os) const;
   static banco read(istream& is);

private:
   void cadastrar_cliente();
   void consultar_cliente() const;
   void abrir_conta();
   void consultar_saldo() const;
   void depositar();
   void sacar();

   string nome_titular(int cpf) const;

   friend ostream& operator<<(ostream& os, const banco& b);
   friend istream& operator>>(istream& is, banco& b);
};

class read_error: public runtime_error
{
public:
   read_error(string const& message)
      : runtime_error(message)
   { }
};

#endif //CAIXA_BANCO_H
