#include <iostream>
#include <fstream>
#include "banco.h"

using namespace std;

int main()
{
   ifstream f{"bcc221.banco.txt"};
   try
   {
      banco bcc221 = f ? banco::read(f) : banco();
      f.close();
      bcc221.caixa_automatico();
      ofstream f{"bcc221.banco.txt"};
      if (!bcc221.write(f))
         cerr << "cannot save" << endl;
   }
   catch (read_error e)
   {
      cerr << "cannot read" << endl;
   }
   f.close();
   return 0;
}
