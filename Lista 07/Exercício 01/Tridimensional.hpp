
#ifndef TRIDIMENSIONAL_HPP_
#define TRIDIMENSIONAL_HPP_

#include "Forma.hpp"

class Tridimensional : public Forma{
public:
	virtual double getArea() = 0;
	virtual double getVolume() = 0;
	virtual ~Tridimensional() = 0;
};

#endif
