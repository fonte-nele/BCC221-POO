#include <iostream>
#include <string>
using namespace std;

class GradeBook
{
	public:
		GradeBook(string,string);
		void setcursoNome(string);
		string getcursoNome();
		void setprofNome(string);
		string getprofNome();
		void displayMessage();
	
	private:
		string cursoNome;
		string profNome;
};