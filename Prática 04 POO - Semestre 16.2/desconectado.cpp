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

#include "Desconectado.h"
#include "Conectado.h"

void Desconectado::conectar(Conexao* con)
{
	con->setEstado(new Conectado());
}

void Desconectado::desconectar(Conexao* con)
{
	cout<<"ERRO!"<<endl;
}

void Desconectado::imprimir()
{
	cout<<"Estado desconectado!"<<endl;
}