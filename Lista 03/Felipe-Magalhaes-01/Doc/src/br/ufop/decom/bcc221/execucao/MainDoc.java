package br.ufop.decom.bcc221.execucao;

import br.ufop.decom.bcc221.docs.Carta;
import br.ufop.decom.bcc221.docs.Documento;

public class MainDoc {

	public static void main(String[] args) {
		Carta carta = new Carta();
		carta.anexar();
		carta.imprimir();
		Documento doc = new Documento();
		doc.imprimir();
		doc.criarDocumento("meu documento", 10);
		doc.imprimir();

	}

}
