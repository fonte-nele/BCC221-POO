
#ifndef BIDIMENSIONAL_HPP
#define BIDIMENSIONAL_HPP

#include "Forma.hpp"

class Bidimensional : public Forma{
public:
	virtual double getArea() = 0;
	virtual ~Bidimensional() = 0;
};

#endif
