#include "questao6.h"

int Aluno::n = 0;

int main()
{
	string nome,grau;
	int serie,i;
	Aluno v[num];
	
	for(i=0; i<num; i++)
	{
		cout<<"\nDADOS ALUNO "<<i+1<<"!"<<endl;
		cout<<"\nDigite o nome do aluno:"<<endl;
		cin.ignore();
		getline(cin,nome);
		cout<<"Digite a serie do aluno:"<<endl;
		cin>>serie;
		cout<<"Digite o grau do aluno:"<<endl;
		cin.ignore();
		getline(cin,grau);
		v[i].setAluno(nome,serie,grau);
		cout<<"\nDADOS INSERIDOS COM SUCESSO..."<<endl;
	}
	
	cout<<"\nO valor do construtor eh: "<<v[0].getAluno()<<endl;	
	
	cout<<"\nFIM DA EXECUCAO..."<<endl;
	return 0;
}