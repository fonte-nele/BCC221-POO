#include "questao8.h"

void Numero::setNumero(float num)
{
	this->num = num;
}

float Numero::getNumero()
{
	return num;
}

float Numero::absoluto(float& num1)
{
	num1 = abs(num1);
	return num1;
}