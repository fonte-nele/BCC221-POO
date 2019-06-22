
#ifndef TETRAEDRO_HPP
#define TETRAEDRO_HPP

#include "Tridimensional.hpp"

class Tetraedro : public Tridimensional{
private:
	double lado;
public:
	Tetraedro(double &);

	void setLado(double &);
	double getLado();

	double getArea();
	double getVolume();

	~Tetraedro();
};


#endif
