#include "questao2.h"

Conta::Conta(float saldo)
{
	setSaldo(saldo);
}

void Conta::setCredito(float saldo)
{
	this->saldo += saldo;
}

void Conta::setDebito(float saldo)
{
	this->saldo -= saldo;
}

float Conta::getSaldo()
{
	return saldo;
}	

void Conta::setSaldo(float saldo)
{
	this->saldo = saldo;
}