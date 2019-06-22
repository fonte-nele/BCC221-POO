#include <iostream>
#define n 3
using namespace std;

class Matriz
{
	public:
		void setMatriz(int);
		int getMatriz();
		friend void imprimir_matriz(Matriz**);
	
	private:
		int num;
};