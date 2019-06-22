package br.ufop.decom.bcc221.docs;

public class MainDoc {

	public static void main(String[] args) {
		
		Documento carta = new Carta();
		
		//carta.anexar();
		carta.imprimir();
			
		Documento doc = new Documento();

		doc.imprimir();

		Documento outro = new Carta();
		
		doc = new Carta();
		doc.imprimir();
		doc.criarDocumento("meu documento", 10);
	}

}
