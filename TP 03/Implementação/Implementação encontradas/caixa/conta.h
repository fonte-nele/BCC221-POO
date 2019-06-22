#ifndef CAIXA_CONTA_H
#define CAIXA_CONTA_H

#include <string>
using namespace std;

class ValorInvalido {};

class SaldoInsuficiente {};

class conta
{
private:
   int numero;
   int titular; // cpf
   double saldo;

public:
   conta(int numero = 0, int titular = 0, double saldo = 0.0)
      : numero{numero}, titular{titular}, saldo{saldo}
   { }

   int get_numero() const { return numero; }
   int get_titular() const { return titular; }
   double get_saldo() const { return saldo; }

   void deposito(double valor)
   {
      if (valor >= 0)
         saldo += valor;
      else
         throw ValorInvalido();
   }

   void saque(double valor)
   {
      if (valor >= 0)
         if (valor <= saldo)
            saldo -= valor;
         else
            throw SaldoInsuficiente();
      else
         throw ValorInvalido();
   }

   friend ostream& operator<<(ostream& os, const conta& c);
   friend istream& operator>>(istream& is, conta& c);
};

#endif //CAIXA_CONTA_H
