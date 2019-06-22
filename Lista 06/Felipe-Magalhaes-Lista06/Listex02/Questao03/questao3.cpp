#include "questao3.h"

void Num::setNum(int num)
{
	this->num = num;
}

int Num::getNum()
{
	return num;
}

bool multiplo(Num* num)
{
	int maior,menor;
	maior = max(num[0].getNum(),num[1].getNum());
	menor = min(num[0].getNum(),num[1].getNum());
	if(maior%menor==0)
	{
		return true;
	}
	else
	{
		return false;
	}
}