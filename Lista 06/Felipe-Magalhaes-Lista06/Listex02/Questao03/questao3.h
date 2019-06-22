#include <iostream>
#include <cmath>
using namespace std;

class Num
{
	public:
		void setNum(int);
		int getNum();
		friend bool multiplo(Num*);
	
	private:
		int num;
};