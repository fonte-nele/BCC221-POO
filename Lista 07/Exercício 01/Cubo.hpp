
#ifndef CUBO_HPP
#define CUBO_HPP

#include "Tridimensional.hpp"

class Cubo : public Tridimensional{
private:
	double lado;
public:
	Cubo(double &);

	void setLado(double &);
	double getLado();

	double getArea();
	double getVolume();

	~Cubo();
};

#endif
