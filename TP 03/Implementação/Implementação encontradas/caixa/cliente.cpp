#include "cliente.h"
#include "util.h"

ostream& operator<<(ostream& os, const cliente& c)
{
   return os << "cliente("
             << c.cpf << ','
             << escape(c.nome) << ','
             << escape(c.endereco)
             << ')';
}

istream &operator>>(istream &is, cliente &c)
{
   int cpf;
   string nome;
   string endereco;
   string str;
   char ch;
   if (word(is >> ws, "cliente") &&
       is >> ch && ch == '(' &&
       is >> cpf &&
       is >> ch && ch == ',' &&
       unescape(is, nome) &&
       is >> ch && ch == ',' &&
       unescape(is, endereco) &&
       is >> ch && ch == ')'
      )
   {
      c.cpf = cpf;
      c.nome = nome;
      c.endereco = endereco;
   }
   else
      is.setstate(ios_base::failbit);
   return is;
}
