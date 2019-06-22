#include <iostream>
#include <cmath>
using namespace std;

class Num
{
	public:
		void setNum(float);
		float getNum();
		void verificar_maior(float,float&,float&);
	private:
		float num;
};