
#ifndef QUADRADO_HPP
#define QUADRADO_HPP

#include "Bidimensional.hpp"

class Quadrado : public Bidimensional{
private:
	double lado;

public:
	Quadrado(double &);

	void setLado(double &);
	double getLado();

	double getArea();

	~Quadrado();
};

#endif
