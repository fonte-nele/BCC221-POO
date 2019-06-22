#include "questao8.h"

int main()
{
	Numero num;
	float num1;
	cout<<"\nDigite um numero: ";
	cin>>num1;
	num.setNumero(num1);
	num.absoluto(num1);
	
	num.setNumero(num1);
	cout<<"\nValor absoluto: "<<num.getNumero()<<endl<<endl;
	cout<<"FIM DA EXECUCAO..."<<endl;
	return 0;
}