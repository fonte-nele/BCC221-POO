#include <iostream>
#include <string>
using namespace std;

class NotaFiscal
{
	public:
		void setNum(string);
		string getNum();
		void setDesc(string);
		string getDesc();
		void setQuant(int);
		int getQuant();
		void setPreco(float);
		float getPreco();
		float getTotalNota(NotaFiscal*,int);
		
	private:
		string num;
		string desc;
		int quant;
		float preco;
};