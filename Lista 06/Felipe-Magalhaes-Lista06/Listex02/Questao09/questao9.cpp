#include "questao9.h"

void Numero::setNumero(int num)
{
	this->num = num;
}

int Numero::getNumero()
{
	return num;
}

bool Numero::verificar(int num)
{
	if(num%2==0)
	{
		return true;
	}
	else
	{
		return false;
	}
}