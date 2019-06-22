//
//  MatrizMain.cpp
//  
//
//
//

#include <stdio.h>
#include<iostream>
#include "Matriz.hpp"
using namespace std;


const int NUM_LINHAS = 4;
const int NUM_COLUNAS = 4;
int main()
{
    
    
    
    Matriz * matriz;
    matriz = criarMatriz(NUM_LINHAS,NUM_COLUNAS);
    criarMatriz(&matriz, NUM_LINHAS, NUM_COLUNAS);
    for(int i = 0; i< NUM_COLUNAS;i++ )
    {
        for (int j = 0 ; j < NUM_COLUNAS; j ++)
        {
            adicionarElemento(matriz, i, j, i+j+0.5);
        }
    }
    int flag_imprimir;
    cout<<"Digite 1 para imprimir: ";
    cin >> flag_imprimir;
    if (flag_imprimir == 1 )
        imprimir(matriz);

    deletarMatriz(&matriz);
    

}




