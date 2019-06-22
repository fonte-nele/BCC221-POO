
#include "Quadrado.hpp"
#include <typeinfo>
#include <stdio.h>
#include <string>

Quadrado::Quadrado(double &lado){
	this->setLado(lado);
}

void Quadrado::setLado(double &lado){
	this->lado = lado;
}
double Quadrado::getLado(){
	return this->lado;
}

double Quadrado::getArea(){
	return this->getLado()*this->getLado();
}

Quadrado::~Quadrado(){
	printf("%s \t", typeid(this).name());
}
