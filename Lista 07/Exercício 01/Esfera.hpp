
#ifndef ESFERA_HPP
#define ESFERA_HPP

#include "Tridimensional.hpp"

class Esfera : public Tridimensional{
private:
	double raio;
public:
	Esfera(double &);

	void setRaio(double &);
	double getRaio();

	double getArea();
	double getVolume();

	~Esfera();
};

#endif
