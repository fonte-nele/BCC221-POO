
#include "Forma.hpp"
#include <typeinfo>
#include <stdio.h>

Forma::~Forma(){
	printf("%s \n", typeid(this).name());
}

