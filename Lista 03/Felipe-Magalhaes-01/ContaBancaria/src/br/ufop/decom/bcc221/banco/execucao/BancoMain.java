package br.ufop.decom.bcc221.banco.execucao;

import br.ufop.decom.bcc221.banco.contabancaria.ContaBancaria;
import br.ufop.decom.bcc221.banco.contapoupanca.ContaPoupanca;

//import br.com.ufop.bcc221.banco.contapoupanca.ContaPoupanca;


public class BancoMain {

	public static void main(String[] args) {
		
		ContaPoupanca c1 = new ContaPoupanca(5, 6);
		
		double a = c1.saldo; 
		c1.render(); 
		c1.devolverSaldo();
		
		ContaPoupanca c2 = new ContaPoupanca(50, 100);
		double b = c2.saldo; 
		double i = c2.indice; 
		c2.render(); 
		c2.creditar(10); 
		c2.getSaldo(b);
		c2.setSaldo(b,a);
		System.out.println("Termino do programa...");
	}

}
