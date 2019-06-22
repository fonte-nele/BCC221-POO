package sisFolhaPgto;

public class Lancamento {
	private String descricao;
	private float valor;

	public Lancamento(String st, float val) {
		this.descricao = st;
		this.valor = val;
	}
	public String getDescricao() {
		return this.descricao;
	}
	public float getValor() {
		return valor;
	}
	public String toString() {
		return (this.descricao + "\t" + valor);
	}
}
