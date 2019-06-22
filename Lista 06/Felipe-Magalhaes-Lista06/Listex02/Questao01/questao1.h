#include <iostream>
using namespace std;

class Numero
{
	public:
		void setNumero(int);
		int getNumero();
		friend int soma(Numero*);
		friend int media(Numero*);
		friend int produto(Numero*);
		friend int maior(Numero*);
		friend int menor(Numero*);
	
	private:
		int num;
};