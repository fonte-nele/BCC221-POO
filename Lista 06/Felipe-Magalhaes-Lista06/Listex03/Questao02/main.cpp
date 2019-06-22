#include <iomanip> 
#include "questao2.h"

int main()
{
	float valor;
	/*CONTA 1*/
	cout<<"\nDigite um valor para inicializar o saldo da Conta 1:"<<endl;
	cin>>valor;
	if(valor<0)
	{
		valor=0;
		cout<<"\nERRO: Valor de saldo inicial invalido!INICIALIZADO SALDO COM VALOR 0"<<endl;
	}
	Conta conta1(valor);
	cout<<"\nSaldo inicializado com sucesso."<<endl<<endl;
	cout<<"Digite um valor para adicionar ao saldo atual da conta 1: "<<endl;
	cin>>valor;
	conta1.setCredito(valor);
	cout<<"\nDigite um valor para debitar no saldo da conta 1: "<<endl;
	cin>>valor;
	while(valor> conta1.getSaldo())
	{
		cout<<"\nValor digitado superior ao saldo disponivel.FAVOR TENTAR NOVAMENTE"<<endl;
		cout<<"Digite um valor para debitar no saldo da conta 1: "<<endl;
		cin>>valor;
	}
	conta1.setDebito(valor);
	cout<<"\nO saldo disponivel na conta 1 eh: R$"<<fixed<<setprecision(2)<<conta1.getSaldo()<<endl<<endl;
	
	/*CONTA 2*/
	cout<<"\nDigite um valor para inicializar o saldo da Conta 2:"<<endl;
	cin>>valor;
	if(valor<0)
	{
		valor=0;
		cout<<"\nERRO: Valor de saldo inicial invalido!INICIALIZADO SALDO COM VALOR 0"<<endl;
	}
	Conta conta2(valor);
	cout<<"\nSaldo inicializado com sucesso."<<endl<<endl;
	cout<<"Digite um valor para adicionar ao saldo atual da conta 2: "<<endl;
	cin>>valor;
	conta2.setCredito(valor);	
	cout<<"\nDigite um valor para debitar no saldo da conta 2: "<<endl;
	cin>>valor;
	while(valor> conta2.getSaldo())
	{
		cout<<"\nValor digitado superior ao saldo disponivel.FAVOR TENTAR NOVAMENTE"<<endl;
		cout<<"Digite um valor para debitar no saldo da conta 2: "<<endl;
		cin>>valor;
	}
	conta2.setDebito(valor);
	cout<<"\nO saldo disponivel na conta 2 eh: R$"<<fixed<<setprecision(2)<<conta2.getSaldo()<<endl<<endl;

	cout<<"\nFIM DA EXECUCAO..."<<endl;
	return 0;
}