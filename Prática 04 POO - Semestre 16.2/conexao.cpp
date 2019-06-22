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
#include "Conectado.h"
#include "Desconectado.h"

Conexao::Conexao()
{
	c = NULL;
	d = new Desconectado();//Inicia a conexao desconectada
}

void Conexao::conectar(Conexao* conex)
{
	cout<<"\nTENTANDO CONECTAR..."<<endl;
	if(c != NULL)
	{
		Conectado est;
		cout<<"\nEstado Atual: ";
		est.imprimir();
		cout<<endl;
		est.conectar(conex);
	}
	else
	{
		Desconectado est;
		cout<<"\nEstado Atual: ";
		est.imprimir();
		cout<<endl;
		est.conectar(conex);
	}
}

void Conexao::desconectar(Conexao* conex)
{
	cout<<"\nTENTANDO DESCONECTAR..."<<endl;
	if(d != NULL)
	{
		Desconectado est;
		cout<<"\nEstado Atual: ";
		est.imprimir();
		cout<<endl;
		est.desconectar(conex);
	}
	else
	{
		Conectado est;
		cout<<"\nEstado Atual: ";
		est.imprimir();
		cout<<endl;
		est.desconectar(conex);
	}
}

void Conexao::setEstado(Conectado* cone)
{
	c = cone;
	delete d;
	d = NULL;
	cout<<"\nNovo estado: ";
	cone->imprimir();
	cout<<endl;
	cout<<"CONECTADO COM SUCESSO!"<<endl;
}

void Conexao::setEstado(Desconectado* desc)
{
	d = desc;
	delete c;
	c = NULL;
	cout<<"\nNovo estado: ";
	desc->imprimir();
	cout<<endl;
	cout<<"DESCONECTADO COM SUCESSO!"<<endl;
}

Conexao::~Conexao()
{
	delete c;
	delete d;
}