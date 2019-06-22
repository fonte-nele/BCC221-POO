package br.ufop.decom.bcc221.docs;

public class Documento {
	private String autor;
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public int getDataDeChegada() {
		return dataDeChegada;
	}
	public void setDataDeChegada(int dataDeChegada) {
		this.dataDeChegada = dataDeChegada;
	}
	private int dataDeChegada;
	public void criarDocumento(String autor, int dataDeChegada){
		this.autor = autor; this.dataDeChegada = dataDeChegada;
	}
	public void imprimir(){
		System.out.println("Imprime o Documento");
	}
	public void editar(){
		System.out.println("Edita o Documento");
	}
} // fim da classe Documento