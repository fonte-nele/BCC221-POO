#include "questao5.h"

int main()
{
	Num num;
	int i;
	float num1,maior1=0,maior2=0;
	
	for(i=0; i<15; i++)
	{
		cout<<"\nDigite um numero real: ";
		cin>>num1;
		num.setNum(num1);
		num.verificar_maior(num1,maior1,maior2);
	}
	cout<<"\nO maior numero eh: "<<maior1<<endl;
    cout<<"O segundo maior numero eh: "<<maior2<<endl;
	cout<<"\nFIM DA EXECUCAO..."<<endl;
	return 0;
}