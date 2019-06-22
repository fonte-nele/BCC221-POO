package figura;


public class Triangulo extends Figura{
	private int base;
	private int altura;
	
	public Triangulo(int base, int altura, char conteudo){
		this.base = base;
		this.altura = altura;
		this.conteudo = conteudo;
	}
	
	public void desenhar() {
		int a = altura/2;
		int b = base/2;
		for(int i=0; i < a; i++){
			for(int j=b*-1; j < b; j++){
				if(j >= i*-1 && j <= i)
					System.out.print(conteudo);
				else
					System.out.print(" ");
			}
			System.out.println();
		}
	}
}
		
		/*
for(int i=0; i < altura; i++){
	cont++;
	j = 0;
	while(j < cont){
		System.out.print(conteudo);
		j++;
	}
	System.out.print("\n");
}
		 */