#include "questao3.h"

void NotaFiscal::setNum(string num)
{
	this->num = num;
}

string NotaFiscal::getNum()
{
	return num;
}

void NotaFiscal::setDesc(string desc)
{
	this->desc = desc;
}

string NotaFiscal::getDesc()
{
	return desc;
}

void NotaFiscal::setQuant(int quant)
{
	this->quant = quant;
}

int NotaFiscal::getQuant()
{
	return quant;
}

void NotaFiscal::setPreco(float preco)
{
	this->preco = preco;
}

float NotaFiscal::getPreco()
{
	return preco;
}

float NotaFiscal::getTotalNota(NotaFiscal v[],int n)
{
	int i;
	float valor=0;
	
	for(i=0; i<n; i++)
	{
		valor += (v[i].getQuant()*v[i].getPreco());
	}
	return valor;
}