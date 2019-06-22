#include <iostream>
#include <iomanip>
#define n 12
using namespace std;

class Numero
{
	public:
		void setNumero(int);
		int getNumero();
		friend double porc08(Numero*);
		friend double porc10(Numero*);
		
	private:
		int num;
};