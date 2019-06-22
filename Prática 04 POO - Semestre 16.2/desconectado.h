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

#ifndef DESCONECTAR_H
#define DESCONECTAR_H

#include "Estado.h"

class Desconectado : public Estado
{
	public:
		void conectar(Conexao*);
		void desconectar(Conexao*);
		void imprimir();
};

#endif