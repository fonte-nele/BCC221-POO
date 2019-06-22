
#ifndef QUADRADO_HPP_
#define QUADRADO_HPP_

#include "Bidimensional.hpp"

class Circulo : public Bidimensional{
private:
	double raio;

public:
	Circulo(double &);

	void setRaio(double &);
	double getRaio();

	double getArea();

	~Circulo();
};

#endif
