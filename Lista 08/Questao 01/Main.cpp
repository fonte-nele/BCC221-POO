#include <iostream>
#include <exception>
using namespace std;

int main () 
{
	int n = (int)10000000000000;
    
    try
    {
		int *vetor= new int[n];
        cout<<"Endereco: "<<(void*)vetor<<endl;
	}
	catch (exception &a)
    {
		cout<<endl<<"Memoria insuficiente: "<<a.what()<<endl;
	}

	return 0;
}
