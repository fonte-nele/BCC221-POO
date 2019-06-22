#include "conta.h"
#include "util.h"

ostream &operator<<(ostream &os, const conta &c)
{
   return os << "conta("
             << c.numero << ','
             << c.titular << ','
             << c.saldo
             << ')';
}

istream &operator>>(istream &is, conta &c)
{
   int numero;
   int titular;
   int saldo;
   char ch;
   if (word(is >> ws, "conta") &&
       is >> ch && ch == '(' &&
       is >> numero &&
       is >> ch && ch == ',' &&
       is >> titular &&
       is >> ch && ch == ',' &&
       is >> saldo &&
       is >> ch && ch == ')'
      )
   {
      c.numero = numero;
      c.titular = titular;
      c.saldo = saldo;
   }
   else
      is.setstate(ios_base::failbit);
   return is;
}
