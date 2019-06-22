
#include "Circulo.hpp"
#include <typeinfo>
#include <stdio.h>
#include <cmath>

Circulo::Circulo(double &raio){
	this->setRaio(raio);
}

void Circulo::setRaio(double &raio){
	this->raio = raio;
}
double Circulo::getRaio(){
	return this->raio;
}

double Circulo::getArea(){
	return pow(getRaio(), 2)*M_PI;
}

Circulo::~Circulo(){
	printf("%s \t", typeid(this).name());
}
