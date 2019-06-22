#include "questao2.h"

void Circulo::setRaio(float raio)
{
	this->raio = raio;
}

float Circulo::getRaio()
{
	return raio;
}

float Circulo::diametro(float raio)
{
	return 2*raio;
}

float Circulo::area(float raio)
{
	return raio*raio*PI;
}

float Circulo::circunferencia(float raio)
{
	return 2*raio*PI;
}