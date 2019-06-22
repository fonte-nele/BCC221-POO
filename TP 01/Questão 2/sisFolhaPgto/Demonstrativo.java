package sisFolhaPgto;

import java.util.Date;
import java.util.Enumeration;
import java.util.Vector;

public class Demonstrativo {
	private Date dtInicial;
	private Date dtFinal;
	private Vector<Lancamento> lancamentos;
	private Funcionario funcionario;
	public Demonstrativo(Funcionario f, Date inicio, Date fim) {
		this.dtInicial = inicio;
		this.dtFinal = fim;
		this.lancamentos = new Vector<Lancamento>(10, 10);
		this.funcionario = f;
	}
	public void incluirCredito(String hist, float val) {
		lancamentos.addElement(new Lancamento(hist, val));
	}
	public void incluirDebito(String hist, float val) {
		lancamentos.addElement(new Lancamento(hist, -val));
	}
	public void imprimir() {
		Lancamento l;
		float total = 0;
		System.out.println(this);
		Enumeration<Lancamento> lista = this.lancamentos.elements();
		while (lista.hasMoreElements()) {
			l = (Lancamento) lista.nextElement();
			System.out.println(l);
			total += l.getValor();
		}
		System.out.println("Total a pagar: " + total);
	}
	public String toString() {
		return ("Demonstrativo de Pagamento:" 
				+ "\n Periodo de " + dtInicial
				+ " a " + this.dtFinal + "\n " 
				+ this.funcionario);
	}
}