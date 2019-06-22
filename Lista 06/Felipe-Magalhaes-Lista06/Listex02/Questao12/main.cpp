#include "questao12.h"

int main()
{
    Matriz **m;
	int i,j,num;
	//Alocacao Dinamica Matriz!
	m = new Matriz*[n];
	for(i=0; i<n; i++)
	{
		m[i] = new Matriz[n];
	}
	
    for(i=0; i<n; i++)
    {
        for(j=0; j<n; j++)
        {
            cout<<"Digite a matriz: Linha ["<<i+1<<"] Coluna ["<<j+1<<"]\n";
            cin>>num;
			m[i][j].setMatriz(num);
        }
    }
	imprimir_matriz(m);
	
	for(i=0; i<n; i++)
	{
		delete[]m[i];
	}
	delete[]m;
    return 0;
}
