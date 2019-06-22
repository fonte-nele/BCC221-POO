
package figura;

public class Retangulo extends Figura{
	private int base;
	private int altura;
	
	public Retangulo(int base, int altura, char conteudo){
		this.base = base;
		this.altura = altura;
		this.conteudo = conteudo;
	}

	public void desenhar() {
		for(int i=0; i < altura; i++){
			for(int j=0; j < base; j++)
				System.out.print(conteudo);
			
			System.out.print("\n");
		}
	}
	
	
}