package figura;


public class Linha extends Figura{
	private int c;
	
	public Linha(int cumprimento, char conteudo){
		this.c = cumprimento;
		this.conteudo = conteudo;
	}
	public void desenhar(){
		for(int i=0; i < c; i++)
			System.out.print(conteudo);
		
		System.out.print("\n");
	}
	
}