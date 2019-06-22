#include "questao2.h"

int main()
{
	Circulo circ;
	float raio;
	cout<<"\nDigite o raio do circulo: ";
	cin>>raio;
	circ.setRaio(raio);
	cout<<"\nO diametro eh: "<<fixed<<setprecision(2)<<circ.diametro(circ.getRaio())<<endl;
	cout<<"A area eh: "<<fixed<<setprecision(2)<<circ.area(circ.getRaio())<<endl;
	cout<<"A circunferencia eh: "<<fixed<<setprecision(2)<<circ.circunferencia(circ.getRaio())<<endl;
	cout<<"\nFIM DA EXECUCAO..."<<endl;
	return 0;
}