
#include "Bidimensional.hpp"
#include <typeinfo>
#include <stdio.h>

Bidimensional::~Bidimensional(){
	printf("%s \t", typeid(this).name());
}


