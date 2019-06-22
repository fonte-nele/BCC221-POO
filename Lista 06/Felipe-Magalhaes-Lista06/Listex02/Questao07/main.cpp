#include "questao7.h"

int main()
{
	Constante valor;
	int num;
	cout<<"\nDigite o numero de termos do somatorio: ";
	cin>>num;
	valor.setConstante(num);
	
	cout<<"\nO valor de e eh: "<<valor.valor_const(valor.getConstante())<<endl;
	cout<<"\nFIM DA EXECUCAO..."<<endl;
	return 0;
}