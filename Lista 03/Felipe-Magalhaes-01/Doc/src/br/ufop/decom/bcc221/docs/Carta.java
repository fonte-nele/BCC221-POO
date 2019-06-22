package br.ufop.decom.bcc221.docs;

public class Carta extends Documento {
	private String transporte;
	public Carta(){
		super();
		transporte = "Aereo";
	}
	public void anexar(){
		System.out.println("Anexando arquivo");
	}
	public String getTransporte() {
		return transporte;
	}
	public void setTransporte(String transporte) {
		this.transporte = transporte;
	}
	public void imprimir()
	{
		
		super.imprimir();
		System.out.println("Imprimindo Carta");
		
	}
} // fim da classe Carta