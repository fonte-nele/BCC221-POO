
#include "Cubo.hpp"
#include <typeinfo>
#include <stdio.h>

Cubo::Cubo(double &lado){
	this->setLado(lado);
}

void Cubo::setLado(double &lado){
	this->lado = lado;
}
double Cubo::getLado(){
	return this->lado;
}

double Cubo::getArea(){
	return 6*this->getLado();
}
double Cubo::getVolume(){
	return this->getLado()*this->getLado()*this->getLado();
}

Cubo::~Cubo(){
	printf("%s \t", typeid(this).name());
}
