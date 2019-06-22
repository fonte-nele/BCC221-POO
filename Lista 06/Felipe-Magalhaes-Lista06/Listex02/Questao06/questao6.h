#include <iostream>
#include <iomanip>
using namespace std;

class Vendedor
{
	public:
		void setVendedor(float);
		float getVendedor();
		float calcular(float);
		
	private:
		float vendas;
};