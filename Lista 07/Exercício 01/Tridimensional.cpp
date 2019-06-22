
#include "Tridimensional.hpp"
#include <typeinfo>
#include <stdio.h>

Tridimensional::~Tridimensional(){
	printf("%s \t", typeid(this).name());
}
