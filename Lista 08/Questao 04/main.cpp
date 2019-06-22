#include <iostream>
#include <cctype>
#include <stdexcept>
using namespace std;

class DivideByZeroException : public runtime_error
{
    public:
        // construtor especifica a mensagem de erro padrão
        DivideByZeroException(): runtime_error( “tentou dividir por zero" )
        {}
};

double divisao(int numerador, int denominador) 
{
	if( denominador == 0)
		throw DivideByZeroException();
    
	return static_cast <double> (numerador)/denominador;
}

int main()
{
    /*
            O tratamento de exceções em Java e C++ são muito semelhantes, existindo poucas divergências,
        como por exemplo, o comando FINALLY, que em Java garante que algo vai ser executado independente
        do try ou catch, isso não existe em C++. Outra diferença é que em Java uma classe de exceção deve
        herdar de Exception, e em C++ isso não ocorre necessariamente. Por fim, Java deixa o tratamento
        de exceção mais estruturado. Outra diferença diz respeito a quais tipos de objetos 
        podem ser lançados como exceção. Em C++ quaisquer objetos podem ser lançados, mesmo sendo estes 
        de tipos primitivos. Já em Java, apenas objetos que estendem a classe Throwable podem ser lançados. 
    */
    
	int numero1;
	int numero2;
	double resultado;
	cout << "Digite dois inteiros: ";
	while ( cin >> numero1 >> numero2 ) 
    {
		try 
        {
			resultado = divisao(numero1, numero2);
			cout << "Resultado: " << resultado << endl;
		}
		catch (DivideByZeroException &divideByZeroException) 
        {
			cout << "\tExceção ocorrida: " << divideByZeroException.what() << endl;
		}
		cout << "\nDigite dois inteiros: ";
	}
    /*
            E na minha opinião, alguns nomes de classes em C++ não são muito
        sugestivos, visto que a classe runtime_error pode ser interpretado pelo programador como algum erro
        relacionado ao programa, e não com a classe de erro.
    
    */
    cout<<endl;
    return 0;
}