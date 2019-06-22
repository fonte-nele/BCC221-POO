#include "library.h"


        // Construtores e Destrutores

CaixaAutomatico::CaixaAutomatico() {
}

CaixaAutomatico::~CaixaAutomatico() {

}


        // Outros Métodos

void CaixaAutomatico::menuInicial() {
    opcao = 0;
    string nomeBanco;
    unsigned int i;
    long nConta;
    Banco bank;
    Conta account;
    cout << "Informe o nome do banco que deseja consultar: ";
    cin >> nomeBanco;


    ifstream abreBanco("Bancos.bin", ios::in | ios::binary);

    if(!abreBanco) {
        cerr << "Nao foi possivel abrir bancos.bin" << endl;
        return;
    } else {

        // Procura o banco no Sistema de Bancos
        for(i = 0; i < NMAX_BANCOS; i++) {
            abreBanco.read(reinterpret_cast<char*>(&bank), sizeof(Banco));
            if(bank.getNome() == nomeBanco) {
                qualBanco = bank;   // Atribui o banco a qualBanco

                // Ajusta a posição do banco
                abreBanco.seekg(-sizeof(Banco), ios::cur);
                posBanco = (abreBanco.tellg() / sizeof(Banco));
                abreBanco.close();
                break;
            }
        }
       // Se não achou o banco
       if(bank.getNome().compare("vazio") == 0) {
            cout << "Banco inexistente!" << endl;
            abreBanco.close();
            return;
       }
       abreBanco.close();

    }

    cout << "Digite o numero da conta que deseja acessar: ";
    cin >> nConta;
    account = qualBanco.ProcuraConta(nConta);

    // Se a conta não existir
    if (account.getNumeroConta() == -1) {
        cout << "Conta inexistente!" << endl;
        return;
    }

    // Caso exista, confere a senha;
    i = 0; // Numero de erros

    while(i < NMAX_ERROS) {
        cout << "Digite a senha da conta: ";
        cin >> nConta;

        // Acertou a senha
        if(nConta == account.getSenha()) {
            cout << "Bem vindo " << account.getNomeTitular() << "!" << endl;
            contaAtual = account;
            return;
        }
        i++; // Caso contrário adiciona um erro

        // Se excedeu o limite de erros
        if(i == NMAX_ERROS) {
            cout << "Numero de erros maximo atingido!" << endl;
            return;
        }
        cout << "Senha Incorreta!" << endl;
    }
    menuCaixa();
}

void CaixaAutomatico::menuCaixa() {
    opcao = 0;
    while(opcao != 6) {

        do {
            cout << endl;
            cout <<"  ===========MENU CAIXA===========" << endl;
            cout <<" ||                               ||" << endl;
            cout <<" || 1 - Saldo bancario            ||" << endl;
            cout <<" || 2 - Extrato bancario          ||" << endl;
            cout <<" || 3 - Deposito                  ||" << endl;
            cout <<" || 4 - Saque                 	  ||" << endl;
            cout <<" || 5 - Transferencia             ||" << endl;
            cout <<" || 6 - Sair                      ||" << endl;
            cout <<" ||                               ||" << endl;
            cout <<"  ===========MENU CAIXA===========" << endl;
            cout << endl;
            cout << "  Escolha: ";
            cin >> opcao;
            cin.ignore();

            if(opcao < 1 || opcao > 6)
                cout << "Opcao invalida, digite novamente." << endl;

        } while(opcao < 1 || opcao > 6);

        switch(opcao)
        {
            case 1:
                consultaSaldo();
                opcao = 0;
                break;
            case 2:
                consultaExtrato();
                opcao = 0;
                break;
            case 3:
                fazDeposito();
                opcao = 0;
                break;
            case 4:
                fazSaque();
                opcao = 0;
                break;
            case 5:
                fazTransferencia();
                opcao = 0;
                break;
            case 6:
                break;
        }
    }
}

void CaixaAutomatico::consultaSaldo() {
    cout << "O saldo da conta eh: " << contaAtual.getSaldo();
}

void CaixaAutomatico::consultaExtrato() {
    cout << "Seu extrato eh: " << endl;
    contaAtual.ImprimeDados();
}

void CaixaAutomatico::fazDeposito()
{
    Deposito d;
    double valor;
    cout << "Informe o valor do deposito." << endl;
    cin >> valor;

    if(d.RealizaDeposito(&contaAtual, valor)) {
    // Se o deposito foi feito com sucesso
        cout << "O saldo da conta depois do deposito eh: " << contaAtual.getSaldo();
        contaAtual.addEvento(&d);
        return;
    } else {
        return;
    }
}

void CaixaAutomatico::fazSaque()
{
    Saque s;
    double valor;
    cout << "Informe o valor do saque." << endl;
    cin >> valor;

    if(s.RealizaSaque(&contaAtual, valor)) {
    // Se o saque foi feito com sucesso
        cout << "O saldo da conta depois do saque eh: " << contaAtual.getSaldo();
        contaAtual.addEvento(&s);
        return;
    } else {
        return;
    }

}

void CaixaAutomatico::fazTransferencia()
{

    Transferencia t;
    Conta paraQual;
    long nParaQual;
    double valor;
    cout << "Informe o valor do deposito." << endl;
    cin >> valor;

    cout << "Informe o numero d a conta que deseja transferir" << endl;
    cin >> nParaQual;
    paraQual = qualBanco.ProcuraConta(nParaQual);

    if(paraQual.getNumeroConta() == -1) {
        cout << "Conta invalida!" << endl;
        return;
    }


    if(t.RealizaTransferencia(paraQual, contaAtual, valor)) {
    // Se o transferencia foi feito com sucesso
        cout << "O saldo da conta depois da transferencia eh: " << contaAtual.getSaldo();
        contaAtual.addEvento(&t);
        return;
    } else {
        return;
    }
}
