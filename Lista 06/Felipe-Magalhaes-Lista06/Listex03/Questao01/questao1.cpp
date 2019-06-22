#include "questao1.h"

GradeBook::GradeBook(string nome1,string nome2)
{
	setcursoNome(nome1);
	setprofNome(nome2);
}

void GradeBook::setcursoNome(string nome)
{
	cursoNome = nome;
}

string GradeBook::getcursoNome()
{
	return cursoNome;
}

void GradeBook::setprofNome(string nome)
{
	profNome = nome;
}

string GradeBook::getprofNome()
{
	return profNome;
}

void GradeBook::displayMessage()
{
	cout<<"Nome Curso: "<<getcursoNome()<<endl;
	cout<<"Nome Prof.(a): "<<getprofNome()<<endl;
}