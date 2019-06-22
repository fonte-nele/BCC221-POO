#include <iostream>
#include <string>
using namespace std;

class Funcionario{
public:

Funcionario (string n, string sn, string d){
	setNome(n);
	setSobrenome(sn);
	setDocumento(d);
}

void setNome(string n){
	nome = n;
}

string getNome(){
	return nome;
}

void setSobrenome(string sn){
	sobrenome = sn;
}

string getSobrenome(){
	return sobrenome;
}

void setDocumento(string d){
	documento = d;
}

string getDocumento(){
	return documento;
}

virtual ~Funcionario(){
	cout<<"Objeto funcionário destruído"<<endl;
}

virtual float calcularSalario()=0;

virtual void print(){
	cout<<getNome()<<" "<<getSobrenome()<<" "<<getDocumento()<<endl;
}
private:
string nome, sobrenome, documento;
	
};

class FuncionarioAssalariado: public Funcionario{
public:
FuncionarioAssalariado(string n, string sn, string d, float salario):Funcionario(n, sn, d){
	setSalario(salario);
}

~FuncionarioAssalariado(){
	cout<<"Objeto funcionário assalariado destruído"<<endl;
}

void setSalario(float salario){
	salarioSemanal = salario;
}

float getSalario(){
	return salarioSemanal;
}

void print(){
	Funcionario::print();
	cout<<getSalario()<<endl;
}

float calcularSalario(){
	return	getSalario();
}

private:
	float salarioSemanal;
};

class FuncionarioComissionado: public Funcionario{
public:
FuncionarioComissionado(string n, string sn, string d, float c, float v):Funcionario(n, sn, d){
	setComissao(c);
	setVendas(v);
}

~FuncionarioComissionado(){
	cout<<"Objeto funcionário comissionado destruído"<<endl;
}

void setVendas(float v){
	vendas = v;
}

float getVendas(){
	return vendas;
}

void setComissao(float c){
	comissao = c;
}
float getComissao(){
	return comissao;
}

void print(){
	Funcionario::print();
	cout<<getVendas()<<" "<<getComissao()<<endl;
}

float calcularSalario(){
	return	getVendas()*getComissao();
}

private:	
float comissao, vendas;
};

class FuncionarioAssalariadoComissionado: public FuncionarioComissionado{
public:

FuncionarioAssalariadoComissionado(string n, string sn, string d, float c, float v, float s):FuncionarioComissionado(n, sn, d, c, v){
	setSalario(s);
}

void print(){
	FuncionarioComissionado::print();
	cout<<getSalario()<<endl;
}

void setSalario(float s){
	salario = s;
}

float getSalario(){
	return salario;
}

float calcularSalario(){
	return	FuncionarioComissionado::calcularSalario()+getSalario();
}


~FuncionarioAssalariadoComissionado(){
	cout<<"Objeto funcionário assalariado comissionado destruído"<<endl;
}

private:

float salario;
};


class FuncionarioHorista: public Funcionario{
	
public:
FuncionarioHorista(string n, string sn, string d, float h, float vh):Funcionario(n, sn, d){
	setHoras(h);
	setValorHora(vh);
}

~FuncionarioHorista(){
	cout<<"Objeto funcionário horista destruído"<<endl;
}

void setHoras(float h){
	horas = h;
}

float getHoras(){
	return horas;
}

void setValorHora(float vh){
	valorHora = vh;
}
float getValorHora(){
	return valorHora;
}

void print(){
	Funcionario::print();
	cout<<getHoras()<<" "<<getValorHora()<<endl;
}

float calcularSalario(){
	if(getHoras() <= 40)
		return getHoras()*getValorHora();
	else 
		return 40*getValorHora()+(getHoras()-40)*1.5*getValorHora();
}
private:
int horas;
float valorHora;
};


int main() {
	Funcionario *vetor[] = {new FuncionarioAssalariado("Cristovao", "Colombo", "222.222.222-22", 6000.00), new FuncionarioComissionado("Ciro", "Botinni", "333.333.333-22", 0.20, 33000.00), new FuncionarioAssalariadoComissionado("Joaquim", "Xavier", "000.000.000-00", 0.10, 27000.00, 4000.0), new FuncionarioHorista("Pedro", "Cabral", "111.111.111-11", 65, 40.0)};

	for(int i=0; i<4;i++){
		if(typeid(*vetor[i]) == typeid(class FuncionarioAssalariado))
		{
			FuncionarioAssalariado *ptr = dynamic_cast<FuncionarioAssalariado*> (vetor[i]);
			ptr->setSalario(ptr->getSalario()*1.1);
		}
		cout<<vetor[i]->calcularSalario()<<endl;
		vetor[i]->print();
	}
	
	for(int i=0; i<4;i++)
		delete vetor[i];
}