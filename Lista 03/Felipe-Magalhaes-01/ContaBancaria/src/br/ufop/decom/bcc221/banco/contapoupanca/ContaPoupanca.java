package br.ufop.decom.bcc221.banco.contapoupanca;

import br.ufop.decom.bcc221.banco.contabancaria.ContaBancaria;

public class ContaPoupanca extends ContaBancaria{
	
	public double indice;
	
	public ContaPoupanca(double sal, double indice){
		super(sal);
		this.indice = indice;
	}
	public void render(){
		double s = this.devolverSaldo();
		double i = indice * s;
		this.creditar(i);
	}
	public void setSaldo(double saldo, double saldo_novo){
		saldo = saldo_novo;
	}
	public double getSaldo(double saldo){
		return saldo;
	}
}
