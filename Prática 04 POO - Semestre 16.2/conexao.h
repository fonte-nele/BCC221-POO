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

#ifndef CONEXAO_H
#define CONEXAO_H

#include <iostream>
using namespace std;

class Estado;

class Conectado;

class Desconectado;

class Conexao
{
	public:
		Conexao();
		void conectar(Conexao*);
		void desconectar(Conexao*);
		void setEstado(Conectado*);
		void setEstado(Desconectado*);
		~Conexao();
	private:
		Estado* c;
		Estado* d;
};

#endif