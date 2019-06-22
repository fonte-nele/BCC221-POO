#include "questao7.h"

void Constante::setConstante(int num)
{
	this->num = num;
}

int Constante::getConstante()
{
	return num;
}

double Constante::valor_const(int num)
{
	int i;
	double valor,fat=1;
	for(i=2; i<=(num+1); i++)
	{
		valor = 1/fat;
		fat *= i;
	}
	return valor;
}