#include <iostream>
#include <limits> //for numeric_limits
#include <iomanip>
#include "menu.h"

void menu(string titulo, vector<pair<string, function<void()>>> itens)
{
   while (true)
   {
      cout << titulo << endl
           << "=================================" << endl;
      for (int i = 0; i < itens.size(); ++i)
         cout << setw(3) << i + 1 << ". " << itens[i].first << endl;
      cout << setw(3) << 0 << ". " << "Terminar" << endl;
      cout << "=================================" << endl
           << "Digite uma opção: ";
      int opcao;
      cin >> opcao;
      cout << endl;
      // ignora todos os caracteres disponíveis no fluxo de entrada
      // padrão até encontrar o caracter '\n'
      cin.ignore(numeric_limits<streamsize>::max(), '\n');
      if (opcao == 0)
         break;
      else if (opcao > 0 && opcao <= itens.size())
         itens[opcao - 1].second();
      else
         cout << "Opção inválida";
      cout << endl << "Tecle <ENTER> para continuar";
      string aux;
      getline(cin, aux);
      cout << endl;
   }
}
