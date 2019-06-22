#include "questao1.h"

void Numero::setNumero(int num)
{
	this->num = num;
}

int Numero::getNumero()
{
	return num;
}

int soma(Numero* num)
{
	return (num[0].getNumero()+num[1].getNumero()+num[2].getNumero());
}

int media(Numero* num)
{
	return (num[0].getNumero()+num[1].getNumero()+num[2].getNumero())/3;
}

int produto(Numero* num)
{
	return (num[0].getNumero()*num[1].getNumero()*num[2].getNumero());
}

int maior(Numero* num)
{
	if(num[0].getNumero()>=num[1].getNumero() && num[0].getNumero()>=num[2].getNumero())
	{
		return num[0].getNumero();
	}
	else
	{
		if(num[1].getNumero()>=num[0].getNumero() && num[1].getNumero()>=num[2].getNumero())
		{
			return num[1].getNumero();
		}
		else
		{
			return num[2].getNumero();
		}
	}
}

int menor(Numero* num)
{
	if(num[0].getNumero()<=num[1].getNumero() && num[0].getNumero()<=num[2].getNumero())
	{
		return num[0].getNumero();
	}
	else
	{
		if(num[1].getNumero()<=num[0].getNumero() && num[1].getNumero()<=num[2].getNumero())
		{
			return num[1].getNumero();
		}
		else
		{
			return num[2].getNumero();
		}
	}
}

