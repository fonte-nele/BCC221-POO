#include "questao1.h"

int main()
{
	Numero num[3];
	int num1;
	cout<<"\nDigite um numero inteiro: ";
	cin>>num1;
	num[0].setNumero(num1);
	cout<<"\nDigite outro numero inteiro: ";
	cin>>num1;
	num[1].setNumero(num1);
	cout<<"\nDigite o ultimo numero inteiro: ";
	cin>>num1;
	num[2].setNumero(num1);
	
	cout<<"\nSoma: "<<soma(num)<<endl;
	cout<<"Media: "<<media(num)<<endl;
	cout<<"Maior: "<<maior(num)<<endl;
	cout<<"Menor: "<<menor(num)<<endl;
	
	
	cout<<"\nFIM EXECUCAO..."<<endl;
	return 0;
}