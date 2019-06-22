package sisFolhaPgto;

import java.util.Date;


public class Gerente extends Funcionario {

	public Gerente(String nome, Date dt, int id) {
		super(nome, dt, id);

		// salario base gerente: 400,
		this.setSalarioBase(400);
	}
	public boolean isFuncionario() {
		return false;
	}
	public boolean isGerente() {
		return true;
	}
}
