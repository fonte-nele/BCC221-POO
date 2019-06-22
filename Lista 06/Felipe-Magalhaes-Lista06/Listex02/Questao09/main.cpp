#include "questao9.h"

int main()
{
	Numero *v;
	int i, num;
	v = new Numero[12];
	
	cout<<endl;
	for(i=0; i<12; i++)
	{
		cout<<"Digite um numero para a posicao "<<i+1<<" do vetor: ";
		cin>>num;
		v[i].setNumero(num);
	}
	cout<<endl;
	for(i=0; i<12; i++)
	{
		if(v[i].verificar(v[i].getNumero()))
		{
			cout<<"Numero: "<<v[i].getNumero()<<" PAR"<<endl;
		}
		else
		{
			cout<<"Numero: "<<v[i].getNumero()<<" IMPAR"<<endl;
		}
	}
	cout<<"\nFIM DA EXECUCAO..."<<endl;
	
	delete []v;
	return 0;
}