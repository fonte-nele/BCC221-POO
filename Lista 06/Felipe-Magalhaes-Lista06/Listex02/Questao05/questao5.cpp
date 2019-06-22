#include "questao5.h"

void Num::setNum(float num)
{
	this->num = num;
}

float Num::getNum()
{
	return num;
}

void Num::verificar_maior(float num1,float& num2,float& num3)
{
	if(num2<num1)
	{
		num3 = num2;
		num2 = num1;
	}
	else
	{
		if(num1>num3 && num1!=num2)
		{
			num3 = num1;
		}
	}
}