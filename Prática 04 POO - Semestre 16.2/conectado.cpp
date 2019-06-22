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

#include "Conectado.h"
#include "Desconectado.h"

void Conectado::conectar(Conexao* con)
{
	cout<<"ERRO!"<<endl;
}

void Conectado::desconectar(Conexao* con)
{
	con->setEstado(new Desconectado());
}

void Conectado::imprimir()
{
	cout<<"Estado conectado!"<<endl;
}