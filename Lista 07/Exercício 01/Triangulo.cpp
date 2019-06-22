
#include "Triangulo.hpp"
#include <typeinfo>
#include <stdio.h>

Triangulo::Triangulo(double &base, double &altura){
	this->setBase(base);
	this->setAltura(altura);
}

void Triangulo::setBase(double &base){
	this->base = base;
}
double Triangulo::getBase(){
	return this->base;
}

void Triangulo::setAltura(double &altura){
	this->altura = altura;
}
double Triangulo::getAltura(){
	return this->altura;
}

double Triangulo::getArea(){
	return 0.5*getAltura()*getBase();
}

Triangulo::~Triangulo(){
	printf("%s \t", typeid(this).name());
}
