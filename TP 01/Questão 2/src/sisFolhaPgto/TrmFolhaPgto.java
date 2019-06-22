package sisFolhaPgto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class TrmFolhaPgto {

	private CadastroFuncionario cadastroFuncionario;

	public TrmFolhaPgto() {
		this.cadastroFuncionario = new CadastroFuncionario();
	}
	public void iniciarSistema() {

		int idFuncionario;
		int op;
		System.out.println("\nSistema de Pagamento");
		idFuncionario = this.getIDFuncionario();
		// seleciona usuario
		while (idFuncionario > -1) {
			op = this.getOperacao(); // seleciona operacao
			this.executaOperacao(idFuncionario, op); // e executa
			idFuncionario = this.getIDFuncionario();

		}
	}
	// realiza leitura teclado
	private int getInt(String str, int de, int ate) {
		BufferedReader r = 
			new BufferedReader(new InputStreamReader(System.in));
		StreamTokenizer st = new StreamTokenizer(r);
		do {
			System.out.println("Entre com " + str);
			try {
				st.nextToken();
			} catch (IOException e) {
				System.err.println("Erro na leitura do teclado");
				return (0);
			}
		} while (st.ttype != StreamTokenizer.TT_NUMBER || st.nval < de
				|| st.nval > ate);
		return ((int) st.nval);
	}
	private int getIDFuncionario() {

		int qtdFuncionario = this.cadastroFuncionario.getTamanhoLista();
		int id = getInt
		("id do funcionario " + "( ou digite -1 para terminar)",
				-1, (qtdFuncionario - 1));
		return id;
	}
	private int getOperacao() {
		int op = getInt("operacao:\n1=adicionar evento,"
				+ " 2=gerar demonstrativo, 3=sair", 1, 4);
		return (op);
	}
	private void executaOperacao(int idFuncionario, int op) {
		Funcionario f1 = this.cadastroFuncionario
				.buscarFuncionario(idFuncionario);

		switch (op) {
		case 1:

			Calendar cal = new GregorianCalendar();
			Date hoje = cal.getTime();
			int idEvento = this.getIdEvento();
			float valor = this.getValorEvento(idEvento);
			if (idEvento == 1)
				f1.adicionarEvento
				(new EventoReajuste(hoje, valor));
			else
				f1.adicionarEvento
				(new EventoAtraso(hoje, valor));
			break;
		case 2:

			f1.gerarDemonstrativo();
			break;
		}
	}
	private int getIdEvento() {

		int idEvento = getInt
		("evento:\n1= reajuste," + " 2= horas atraso", 1,
				2);
		return idEvento;
	}
	private float getValorEvento(int id) {

		int valor = 0;
		switch (id) {
		case 1:
			valor = getInt
			("valor do reajuste: \n", 1, 50000);
			break;
		case 2:
			valor = getInt
			("o numero de horas de atraso: \n", 1, 8);
			break;
		default:
			System.err.println("Opcao invalida");
		}
		return valor;
	}
}
