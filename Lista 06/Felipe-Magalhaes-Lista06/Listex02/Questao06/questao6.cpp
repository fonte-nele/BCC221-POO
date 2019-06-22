#include "questao6.h"

void Vendedor::setVendedor(float vendas)
{
	this->vendas = vendas;
}

float Vendedor::getVendedor()
{
	return vendas;
}

float Vendedor::calcular(float num)
{
	float porc;
	porc = (num/100)*9;
	
	return (200+porc);
}