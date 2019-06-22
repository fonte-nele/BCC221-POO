
#include "Esfera.hpp"
#include <typeinfo>
#include <stdio.h>
#include <cmath>

Esfera::Esfera(double &raio){
	this->setRaio(raio);
}

void Esfera::setRaio(double &raio){
	this->raio = raio;
}

double Esfera::getRaio(){
	return this->raio;
}

double Esfera::getArea(){
	return 4*M_PI*pow(this->getRaio(), 2);
}

double Esfera::getVolume(){
	return (4/3)*M_PI*pow(this->getRaio(), 3);
}

Esfera::~Esfera(){
	printf("%s \t", typeid(this).name());
}
