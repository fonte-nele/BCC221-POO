#ifndef LIBRARY_H
#define LIBRARY_H

#define NMAX_CONTAS 100
#define NMAX_CLIENTES 100
#define NMAX_EVENTOS 100
#define NMAX_BANCOS 100
#define NMAX_ERROS 10


#include <iostream>
#include <fstream>
#include <vector>
#include <iomanip>
#include <stdio.h>
#include <string>
#include <cstdlib>
#include "sisbanco.h"
#include "caixaautomatico.h"
#include "contaespecial.h"
#include "contapoupanca.h"
#include "contasimples.h"
#include "deposito.h"
#include "gerencbanco.h"
#include "gerencclientes.h"
#include "gerenccontas.h"
#include "gerenciamentoadm.h"
#include "saque.h"
#include "transferencia.h"


void Criar_Bancos_Iniciais();
void MainMenu(int *menu);



#endif // LIBRARY_H

