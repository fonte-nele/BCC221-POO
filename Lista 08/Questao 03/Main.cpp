#include <iostream>
#include <cctype>
#include <cstdlib>
#include "DividirNaoNumeroExcecao.hpp"
#include "DividirZeroExcecao.hpp"

using namespace std;

double divisao(char numerador[], char denominador[])
{
	int  num,den;
    if(isalpha(numerador[0]) || isalpha(denominador[0]))
		throw CounterClassException();
	
	num = atoi(numerador);
	den = atoi(denominador);
	
	if(den == 0)
		throw DividirZeroExcecao();
	
	return num/den;
}

int main()
{
	char numero1[8],numero2[8];
	double resultado;
	
	cout<<"Digite dois numeros inteiros: "<<endl;
	
	while ( cin >> numero1 >> numero2 ) 
    {
		try 
        {
			resultado = divisao(numero1, numero2);
			cout<<"O resultado eh: "<<resultado<<endl;
		}
		catch (...)
        {
			cout<<"\nExceção ocorrida"<<endl;
		}
        cout<<"Digite dois numeros inteiros: "<<endl;
	}	
	cout<<endl;
	
	return 0;
}

