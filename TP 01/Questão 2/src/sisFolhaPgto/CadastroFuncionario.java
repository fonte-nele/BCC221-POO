package sisFolhaPgto;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class CadastroFuncionario {

	private List<Funcionario> listaFuncionario;

	public CadastroFuncionario() {

		Calendar cal = new GregorianCalendar();
		cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) - 1);
		Funcionario func1 = new Gerente("Joao", cal.getTime(), 0);
		Funcionario func2 = new Gerente("Pedro", cal.getTime(), 1);

		this.listaFuncionario = new ArrayList<Funcionario>();
		this.listaFuncionario.add(func1);
		this.listaFuncionario.add(func2);
	}
	public Funcionario buscarFuncionario(int id) {
		List<Funcionario> listaFunList = this.listaFuncionario;
		if (listaFunList != null)
			for (int i = 0; i < listaFunList.size(); i++) {
				Funcionario funcionario = listaFunList.get(i);
				if (id == funcionario.getId()) {
					return funcionario;
				}
			}
		return null;
	}
	public int getTamanhoLista() {
		return this.listaFuncionario.size();
	}
	public List<Funcionario> getListaFuncionario() {
		return this.listaFuncionario;
	}
}
