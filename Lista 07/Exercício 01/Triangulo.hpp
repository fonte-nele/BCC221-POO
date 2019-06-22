
#ifndef TRIANGULO_HPP_
#define TRIANGULO_HPP_

#include "Bidimensional.hpp"

class Triangulo : public Bidimensional{
private:
	double base;
	double altura;

public:
	Triangulo(double &, double &);

	void setBase(double &);
	double getBase();

	void setAltura(double &);
	double getAltura();

	double getArea();

	~Triangulo();
};

#endif
