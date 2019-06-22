package sisFolhaPgto;


import java.util.Date;
import java.util.Vector;
import java.util.Enumeration;

public class Funcionario {

	private String nomeFunc;
	private Date dtAdmissao;
	private float salarioBase;
	private Date dtFechamento;
	private Vector<Evento> eventos;
	private Vector<Demonstrativo> demonstrativos;
	private int horasAtrasos;
	private int id;

	public Funcionario(String nome, Date dt, int id) {
		this.nomeFunc = nome;
		// salario base do funcionaro: 300
		this.setSalarioBase(300);
		this.dtAdmissao = dt;
		this.dtFechamento = dt;
		this.eventos = new Vector<Evento>(10, 10);
		this.demonstrativos = new Vector<Demonstrativo>(10, 10);
		this.id = id;
	}

	public boolean adicionarEvento(Evento e) {

		Date hoje = new Date();
		if (!(e.getDtEvento()).after(this.dtFechamento)) {
			System.out.println
			("Evento com data anterior aa do fechamento.");
			return false;
		} else if ((e.getDtEvento()).after(hoje)) {

			System.out.println("Evento com data futura.");
			return false;
		} else {
			// evento adicionado com sucesso
			this.eventos.addElement(e);
			return true;
		}
	}
	public void gerarDemonstrativo() {

		Evento e;
		Demonstrativo d;
		Date hoje = new Date();
		Enumeration<Evento> listaEventos = this.eventos.elements();
		while (listaEventos.hasMoreElements()) {
			e = (Evento) listaEventos.nextElement();
			if (e.getDtEvento().after(this.dtFechamento)) {
				processarEventos(e);
			}
		}

		d = new Demonstrativo(this, this.dtFechamento, hoje);

		adicionarLancamentos(d);
		this.dtFechamento = hoje;
		this.demonstrativos.add(d);
		d.imprimir();
	}
	public boolean isGerente() {
		return false;
	}
	public boolean isFuncionario() {
		return true;
	}
	public int getId() {
		return id;
	}
	public void setSalarioBase(float sal) {
		this.salarioBase = sal;
	}
	public String toString() {
		return ("Funcionario: " + this.nomeFunc);
	}
	private void processarEventos(Evento e) {
		if (e.getTipoEvento().equals("EventoReajuste"))
			if (e.getValorEvento() < this.salarioBase)
				System.out.println
				("\n Reajuste menor que salario base."
						+ " O salario base nao sofrera alteracoes");
			else
				this.salarioBase = e.getValorEvento();
		else if (e.getTipoEvento().equals("EventoAtraso"))
			this.horasAtrasos += e.getValorEvento();
		else
			System.out.println
			("Evento invalido funcionario.");
	}

	private void adicionarLancamentos(Demonstrativo d) {

		float valor;
		float salarioHora;
		salarioHora = this.salarioBase / 176;
		d.incluirCredito("Salario Base", 
				this.salarioBase);
		if (this.horasAtrasos > 0) {
			valor = this.horasAtrasos * salarioHora;
			d.incluirDebito
			("Atrasos (" + this.horasAtrasos + " hs)", valor);
		}
	}

}
