#include "questao1.h"

int main()
{
	char resp;
	string nome;
	GradeBook myGradeBook("BCC221-POO","Amanda Nascimento");
	
	cout<<"\nO nome do curso e prof esta salvo como:"<<endl;
	cout<<"Nome Curso: "<<myGradeBook.getcursoNome()<<endl;
	cout<<"Nome Prof.(a): "<<myGradeBook.getprofNome()<<endl<<endl;
	cout<<"Deseja alterar algum campo? S-sim N-nao"<<endl;
	cin>>resp;
	
	if(toupper(resp)=='S')
	{
		cout<<"Digite um nome para o curso: "<<endl;
		cin.ignore();
		getline(cin,nome);
		myGradeBook.setcursoNome(nome);
		cout<<"Digite um nome para o prof.(a): "<<endl;
		getline(cin,nome);
		myGradeBook.setprofNome(nome);
	}
	
	cout<<endl<<"Dados presentes na classe:"<<endl;
	myGradeBook.displayMessage();
	
	cout<<"\nFIM DA EXECUCAO..."<<endl;
	return 0;
}