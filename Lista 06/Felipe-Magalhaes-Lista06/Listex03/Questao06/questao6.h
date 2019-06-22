#include <iostream>
#include <string>
#define num 15
using namespace std;

class Aluno
{	
	public:
		Aluno();
		void setNome(string);
		string getNome();
		void setSerie(int);
		int getSerie();
		void setGrau(string);
		string getGrau();
		void setAluno(string,int,string);
		int getAluno();
		~Aluno();
	
	private:
		string nome;
		int serie;
		string grau;
		static int n;
};