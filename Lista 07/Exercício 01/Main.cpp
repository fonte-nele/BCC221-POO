
#include "Forma.hpp"
#include "Bidimensional.hpp"
#include "Tridimensional.hpp"
#include "Circulo.hpp"
#include "Quadrado.hpp"
#include "Triangulo.hpp"
#include "Cubo.hpp"
#include "Esfera.hpp"
#include "Tetraedro.hpp"
#include <typeinfo>
#include <stdio.h>
#include <vector>
using namespace std;


int main(int argc, char **argv){
	double num = 1.0;
	Forma *driver[] = {new Circulo(num), new Quadrado(num), new Triangulo(num, num),
			new Cubo(num), new Esfera(num), new Tetraedro(num)};

	for(int i = 0; i < 6; i++){
		if(typeid(*driver[i]) == typeid(class Cubo) || typeid(*driver[i]) == typeid(class Esfera) || typeid(*driver[i]) == typeid(class Tetraedro)){
			Tridimensional *temporario = dynamic_cast<Tridimensional*> (driver[i]);
			printf("%s de area igual a %lf e volume igual a %lf \n",
					typeid(*temporario).name(), temporario->getArea(), temporario->getVolume());
		}
		else{
			printf("%s de area igual a %lf \n", typeid(*driver[i]).name(), driver[i]->getArea());
		}
	}

	for(int i = 0; i < 6; i++)
		delete driver[i];

	return 0;
}
