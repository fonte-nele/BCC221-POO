#include "questao6.h"

int main()
{
	Vendedor vend;
	float valor;
	
	do
	{
		cout<<"\nDigite o valor das vendas do vendedor: ";
		cin>>valor;
		vend.setVendedor(valor);
		if(valor != -1)
		{
			cout<<"\nSalario do vendedor: R$"<<fixed<<setprecision(2)<<vend.calcular(valor)<<endl;
		}
	}while(valor != -1);
	
	cout<<"\nFIM DA EXECUCAO..."<<endl;
	return 0;
}