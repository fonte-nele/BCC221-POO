#include <iostream>
#include <algorithm>
#include "banco.h"
#include "menu.h"

ostream& banco::write(ostream& os) const
{
   os << proxima_conta << endl << endl;
   for (auto c : clientes)
      os << c.get_cpf() << endl << c.get_nome() << endl << c.get_endereco() << endl;
   os << endl;
   for (auto c : contas)
      os << c.get_numero() << endl << c.get_titular() << endl << c.get_saldo() << endl;
   os << endl;
   return os;
}

banco banco::read(istream& is)
{
   int n;
   vector<cliente> v1;
   vector<conta> v2;
   string nome, endereco;
   int numero, titular;
   double saldo;
   string lixo;
   // obtém número disponível para a próxima conta
   is >> n;
   getline(is, nome); // pula linhas em branco
   getline(is, nome);
   // obtém o cadastro de clientes
   while (is.peek() != EOF && is.peek() != '\n' &&
          is >> numero && getline(is, lixo) &&
          getline(is, nome) &&
          getline(is, endereco)
         )
      v1.push_back(cliente(numero, nome, endereco));
   getline(is, nome);
   // obtém a carteira de contas
   while (is.peek() != EOF && is.peek() != '\n' &&
          is >> numero &&
          is >> titular &&
          is >> saldo
         )
      v2.push_back(conta(numero, titular, saldo));
   if (is)
      return banco(v1, v2, n);
   throw read_error("banco");
}

string banco::nome_titular(int cpf) const
{
   auto p = find_if(clientes.cbegin(), clientes.cend(), [cpf](cliente c){return c.get_cpf() == cpf;});
   if (p == clientes.cend())
      return "";
   else
      return p->get_nome();
}

void banco::caixa_automatico()
{
   menu("Banco BCC221",
        {  {"Cadastrar cliente", [this](){cadastrar_cliente();} },
           {"Consultar cliente", [this](){consultar_cliente();} },
           {"Abrir conta",       [this](){abrir_conta();} },
           {"Consultar saldo",   [this](){consultar_saldo();} },
           {"Depositar",         [this](){depositar();} },
           {"Sacar",             [this](){sacar();} },
        } );

}

void banco::cadastrar_cliente()
{
   cout << "Cadastro de novo cliente" << endl
   << "===============================================" << endl;

   cout << "  CPF......: ";
   int cpf;
   cin >> cpf;
   cin.ignore(numeric_limits<streamsize>::max(), '\n');

   if ( find_if(clientes.begin(),
                clientes.end(),
                [cpf](cliente c){return c.get_cpf() == cpf;})
        == clientes.end() )
   {
      cout << "  Nome.....: ";
      string nome;
      getline(cin, nome);
      cout << "  Endereco.: ";
      string endereco;
      getline(cin, endereco);
      clientes.push_back(cliente(cpf, nome, endereco));
   }
   else
      cout << "  CPF já cadastrado!" << endl;
}

void banco::consultar_cliente() const
{
   cout << "Consultar cliente" << endl
   << "===============================================" << endl;

   cout << "  CPF......: ";
   int cpf;
   cin >> cpf;
   cin.ignore(numeric_limits<streamsize>::max(), '\n');

   auto p = find_if(clientes.cbegin(),
                    clientes.cend(),
                    [cpf](cliente c){return c.get_cpf() == cpf;});

   if ( p != clientes.end() )
   {
      cout << "  Nome.....: " << p->get_nome() << endl
           << "  Endereco.: " << p->get_endereco() << endl;
   }
   else
      cout << "  CPF não cadastrado!" << endl;
}

void banco::abrir_conta()
{
   cout << "Abertura de conta" << endl
   << "===============================================" << endl;

   cout << "  CPF do titular..: ";
   int cpf;
   cin >> cpf;
   cin.ignore(numeric_limits<streamsize>::max(), '\n');

   if ( find_if(clientes.cbegin(),
                clientes.cend(),
                [cpf](cliente c){return c.get_cpf() == cpf;})
        != clientes.end() )
   {
      cout << "  Número..........: " << proxima_conta << endl;
      contas.push_back(conta(proxima_conta, cpf));
      proxima_conta++;
   }
   else
      cout << "  CPF não cadastrado!" << endl;
}

void banco::consultar_saldo() const
{
   cout << "Consultar saldo" << endl
        << "===============================================" << endl;

   cout << "  Conta.......: ";
   int numero;
   cin >> numero;
   cin.ignore(numeric_limits<streamsize>::max(), '\n');

   auto p = find_if(contas.cbegin(),
                    contas.cend(),
                    [numero](conta c){return c.get_numero() == numero;});

   if ( p != contas.end() )
      cout << "  Titular.....: " << nome_titular(p->get_titular()) << endl
           << "  Saldo.......: " << p->get_saldo() << endl;
   else
      cout << "  Conta inexistente!" << endl;
}

void banco::depositar()
{
   cout << "Depositar" << endl
   << "===============================================" << endl;

   cout << "  Conta.....: ";
   int numero;
   cin >> numero;
   cin.ignore(numeric_limits<streamsize>::max(), '\n');

   auto p = find_if(contas.begin(),
                    contas.end(),
                    [numero](conta c){return c.get_numero() == numero;});

   if ( p != contas.end() )
   {
      cout << "  Valor.....: ";
      double valor;
      cin >> valor;
      try { p->deposito(valor); }
      catch (ValorInvalido) { cout << "Valor inválido! kkkkkkk!" << endl; }
   }
   else
      cout << "  Conta inexistente!" << endl;
}

void banco::sacar()
{
   cout << "Sacar" << endl
   << "===============================================" << endl;

   cout << "  Conta.....: ";
   int numero;
   cin >> numero;
   cin.ignore(numeric_limits<streamsize>::max(), '\n');

   auto p = find_if(contas.begin(),
                    contas.end(),
                    [numero](conta c){return c.get_numero() == numero;});

   if ( p != contas.end() )
   {
      cout << "  Valor.....: ";
      double valor;
      cin >> valor;
      try { p->saque(valor); }
      catch (ValorInvalido e) { cout << "Valor inválido! kkkkkkk!" << endl; }
      catch (SaldoInsuficiente e) { cout << "Saldo insuficiente :(" << endl; }
   }
   else
      cout << "  Conta inexistente!" << endl;
}
