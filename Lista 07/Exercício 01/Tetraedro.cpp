
#include "Tetraedro.hpp"
#include <typeinfo>
#include <stdio.h>
#include <cmath>

Tetraedro::Tetraedro(double &lado){
	this->setLado(lado);
}

void Tetraedro::setLado(double &lado){
	this->lado = lado;
}
double Tetraedro::getLado(){
	return this->lado;
}

double Tetraedro::getArea(){
	return	pow(this->getLado(), 2)*sqrt(3);
}
double Tetraedro::getVolume(){
	return this->getLado()*this->getLado()*(1.0/3);
}

Tetraedro::~Tetraedro(){
	printf("%s \t", typeid(this).name());
}
