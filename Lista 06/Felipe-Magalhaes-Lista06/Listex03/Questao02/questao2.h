#include <iostream>
using namespace std;

class Conta
{
	public:
		Conta(float);
		void setCredito(float);
		void setDebito(float);
		float getSaldo();
		void setSaldo(float);
		
	private:
		float saldo;
};