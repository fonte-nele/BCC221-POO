#ifndef SISBANCO
#define SISBANCO

#include "library.h"

using namespace std;

/*

        Tentamos separar cada classe em um .h diferente para obter um baixo acoplamento mas,
        tivemos problemas de compilação devido à forma que cada classe foi criada, chamando
        uma dentro outra. Por este motivo esse .h geral foi criado.

        Mas, apesar disso, fizemos os .cpp separados.

*/



class Evento {
protected:
    double valor;
    long paraQualConta;    // numero da conta para para qual o evento foi direcionado
    int tipoEvento;     /*
                           1- Saque
                           2- Deposito
                           3- Transferencia
                        */
public:
    virtual void ImprimeDados(); // imprime os dados do evento
};


class Conta {       // Interface de Conta

protected:
    int tipoConta;      /* Associa qual tipo para fazer downcast
                           1- Conta Simples
                           2- Conta Especial
                           3- Conta Poupança
                        */
    string nomeTitular;
    string cpfTitular;
    long numero;        // Número da conta
    //Cliente titular;    // Cliente dono da conta
    long senhaAcesso;   // Senha para acesso da conta
    double saldo;
    bool estado;        // Estado( Ativo ou Desativo )
    vector<Evento> listaMovimentacoes;

public:

    // Construtores e Destrutores
    Conta();// Cria conta Vazia

    // Funções Get e Set
    void setSenha(long senha);
    void setEstado(bool e);

    long getNumeroConta();
    long getSenha();
    long getSaldo();
    long getEstado();
    int getTipoConta();
    string getNomeTitular();

    // Outras Funções
    void addEvento(Evento *evento);
    virtual void ImprimeDados();
    void Retira(double valor);
    void Deposita(double valor);
};

class Cliente {

protected:
    string nome;
    long CPF;   // CPF identificador do cliente
    string endereco;
    Conta *conta; // lista das contas que o cliente pertence

public:

    // Construtores e Destrutores
    Cliente(string name, long cpf, string end);
    Cliente();
    ~Cliente();

    // Funções Set
    void setNome(string name);
    void setCPF(long cpf);
    void setEndereco(string end);
    // Funções Get
    string getNome();
    long getCPF();
    string getEndereco();

    // Outras Funções
    void AdicionarConta(Conta *c);
    void DeletarConta();
    void MostrarDados();
};



class Banco {
private:
    string nome;    // nome do banco
    long senhaAcessoGeral;  // senha para acesso aos dados do banco
    vector<Cliente> cadastroClientes;     // Cria uma lista encadeada de clientes presentes no banco
    int nClientes;
    vector<Conta> carteiraContas;     // Cria uma lista encadeada de contas presentes no banco
    int nContas;
public:

    // Construtores e Destrutores
    Banco();
    Banco(string name, long senha);
    ~Banco();

    // Metodos Set e Get
    void setNome(string name);
    void setSenhaAcesso(long senha);
    void setCliente();
    void setConta();
    string getNome();
    int getNClientes();
    int getNContas();
    vector<Cliente>::iterator getCadastroClientes();
    vector<Conta>::iterator getCarteiraContas();

    // Outros Métodos
    Cliente ProcuraCliente(long cpfCliente);
    Conta ProcuraConta(long numConta);
};







#endif // SISBANCO

