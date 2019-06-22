#include "questao12.h"

void Matriz::setMatriz(int num)
{
	this->num = num;
}

int Matriz::getMatriz()
{
	return num;
}

void imprimir_matriz(Matriz** m)
{
	int i,j;
	cout<<"\nA matriz digitada, sem os elementos da diagonal secundaria eh:\n";
    for(i=0; i<n; i++)
    {
        for(j=0; j<n; j++)
        {
            if(i!= n-(j+1))
            {
                cout<<m[i][j].getMatriz()<<" ";
            }
        }
        cout<<endl;
    }
}