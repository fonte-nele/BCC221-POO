#include <iostream>
#include <iomanip>
#define PI 3.14159
using namespace std;

class Circulo
{
	public:
		void setRaio(float);
		float getRaio();
		float diametro(float);
		float area(float);
		float circunferencia(float);
	
	private:
		float raio;
};