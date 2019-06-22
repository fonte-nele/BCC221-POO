#include "questao3.h"

int main()
{
	Num num[2];
	int num1;
	cout<<"\nDigite um numero inteiro: ";
	cin>>num1;
	num[0].setNum(num1);
	cout<<"\nDigite outro numero inteiro: ";
	cin>>num1;
	num[1].setNum(num1);
	
	if(multiplo(num))
	{
		cout<<"\nOs numeros sao multiplos entre si."<<endl<<endl;
	}
	else
	{
		cout<<"\nOs numeros nao sao multiplos entre si."<<endl<<endl;
	}
	cout<<"FIM DA EXECUCAO..."<<endl;
	return 0;
}