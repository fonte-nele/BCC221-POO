#include "questao6.h"

Aluno::Aluno()
{
	n++;
}

void Aluno::setNome(string nome)
{
	this->nome = nome;
}

string Aluno::getNome()
{
	return nome;
}

void Aluno::setSerie(int serie)
{
	this->serie = serie;
}

int Aluno::getSerie()
{
	return serie;
}

void Aluno::setGrau(string grau)
{
	this->grau = grau;
}

string Aluno::getGrau()
{
	return grau;
}

void Aluno::setAluno(string nome,int serie,string grau)
{
	setNome(nome);
	setSerie(serie);
	setGrau(grau);
}

int Aluno::getAluno()
{
	return n;
}

Aluno::~Aluno()
{
	n--;
}