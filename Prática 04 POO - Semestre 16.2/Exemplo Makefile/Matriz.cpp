
#include "Matriz.hpp"
#include<iostream>
using namespace std;


struct matriz{

    int num_linhas;
    int num_colunas;
    float* elementos;
};


void criarMatriz(Matriz** matriz, int num_linhas, int num_colunas){

    
    (*matriz) = new Matriz;
    (*matriz)->num_linhas = num_linhas;
    (*matriz)->num_colunas = num_colunas;
    (*matriz)->elementos = new float[num_linhas*num_colunas];
    

}

Matriz* criarMatriz(int num_linhas, int num_colunas){

    Matriz* matriz = new Matriz;
    matriz->num_linhas = num_linhas;
    matriz->num_colunas=num_colunas;
    matriz->elementos = new float[num_linhas*num_colunas];
    return matriz;

}

void adicionarElemento(Matriz* matriz, int index_linha, int index_coluna,float elemento){
    
    (matriz)->elementos[index_linha * (matriz)->num_colunas + index_coluna] = elemento;

}
float lerElemento(Matriz* matriz, int index_linha, int index_coluna){

    
    return matriz->elementos[index_linha * matriz->num_colunas + index_coluna];
}

void imprimir(Matriz* matriz){
    
    for(int i = 0; i < matriz->num_linhas; i++)
    {
        for(int j = 0 ; j < matriz->num_colunas; j ++)
        {
            cout << "\n Elemento: " << "(" << i << "," << j <<")= " << matriz->elementos[i * matriz->num_colunas + j];
        
        }
    }
}
void deletarMatriz(Matriz** matriz){
   delete [] (*matriz)->elementos;
    delete (*matriz);

}