#include <iomanip>
#include "questao3.h"

int main()
{
	int i,num,quant;
	string numero;
	float valor,total;
	
	cout<<"\nDigite a quantidade de notas fiscais que deseja inserir: ";
	cin>>quant;
	
	NotaFiscal v[quant];
	
	for(i=0; i<quant; i++)
	{
		cout<<"\nNOTA FISCAL "<<i+1<<"!"<<endl;
		cout<<"\nDigite o numero da peca:"<<endl;
		cin.ignore();
		getline(cin,numero);
		v[i].setNum(numero);
		cout<<"Digite a descricao da peca:"<<endl;
		getline(cin,numero);
		v[i].setDesc(numero);
		cout<<"Digite a quantidade comprada:"<<endl;
		cin>>num;
		v[i].setQuant(num);
		cout<<"Digite o preco:"<<endl;
		cin>>valor;
		v[i].setPreco(valor);
	}
	
	total = v[0].getTotalNota(v,quant);
	cout<<"\nValor Total Nota: R$"<<fixed<<setprecision(2)<<total<<endl;
	cout<<"\nFIM DA EXECUCAO..."<<endl;
	return 0;
}