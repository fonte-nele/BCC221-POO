package br.ufop.decom.bcc221.banco.contabancaria;

public class ContaBancaria {
	public double saldo;
	public ContaBancaria(double sal){
		saldo = sal;
	}
	public double devolverSaldo(){
		return saldo;
	}
	public void creditar(double valor){
		saldo += valor;}
	public void debitar(double valor){
		saldo -= valor;}
}