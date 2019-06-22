/**
	Data de criação: 27/01/2017
	Aluno: Mateus Vitor Pereira Lana
	Matricula: 15.1.4340
	Obs.: Costumo implementar os exercicios propostos
	juntamente com o aluno Thiago Oliveira, se por um 
	acaso alguma ferramenta de correção acusar cópia, 
	gostaria de deixar claro que a atividade proposta 
	foi feita por nós.
*/

#include "Conexao.h"

int main()
{
	//Criando o objeto
	Conexao* conexao1 = new Conexao();
	
	//Parte que executa o menu de opções
	int op;
	do
	{
		cout<<"\n\n ==========MENU=========="<<endl;
		cout<<" |                       |"<<endl;
		cout<<" | Escolha uma opcao:    |"<<endl;
		cout<<" |                       |"<<endl;
		cout<<" | 1-Conectar            |"<<endl;
		cout<<" | 2-Desconectar         |"<<endl;
		cout<<" | 3-Sair                |"<<endl;
		cout<<" |                       |"<<endl;
		cout<<" ========================"<<endl<<endl;
		cin>>op;
		switch(op)
		{
			case 1:
				conexao1->conectar(conexao1);
				break;
			case 2:
				conexao1->desconectar(conexao1);
				break;
			case 3:
				break;
			default:
				cout<<"Opcao invalida!"<<endl;
				break;
		}
	}while(op != 3);
	
	delete conexao1;
	
	return 0;
}