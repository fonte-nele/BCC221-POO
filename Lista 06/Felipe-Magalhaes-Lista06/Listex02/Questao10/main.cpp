#include "questao10.h"

int main()
{
	Numero *v;
	int i,num;
	v = new Numero[12];
	for(i=0;i<n;i++)
	{
		cout<<"Preencha o vetor, posicao "<<i+1<<" :\n";
		cin>>num;
		v[i].setNumero(num);
	}
	cout<<"\nA porcentagem de numeros menores que 08 eh : "<<fixed<<setprecision(2)<<porc08(v)<<" %."<<endl;
	cout<<"A porcentagem de numeros maiores que 10 eh: "<<fixed<<setprecision(2)<<porc10(v)<<" %."<<endl;
	
	delete []v;
	cout<<"\nFIM DA EXECUCAO..."<<endl;
	return 0;
}