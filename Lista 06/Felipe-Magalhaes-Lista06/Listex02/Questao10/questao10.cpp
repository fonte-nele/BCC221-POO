#include "questao10.h"

void Numero::setNumero(int num)
{
	this->num = num;
}

int Numero::getNumero()
{
	return num;
}

double porc08(Numero *v)
{
	int i;
	double cont=0;
	for(i=0;i<n;i++)
	{
		if(v[i].getNumero()<8)
		{
			cont++;
		}
	}
	return (cont/n)*100;
}

double porc10(Numero *v)
{
	int i;
	double cont=0;
	for(i=0;i<n;i++)
	{
		if(v[i].getNumero()>10)
		{
			cont++;
		}
	}
	return (cont/n)*100;
}

