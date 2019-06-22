
package figura;

public class Circulo extends Figura{
	private int largura;
	private int altura;
	
	public Circulo(int base, int altura, char conteudo){
		this.largura = base;
		this.altura = altura;
		this.conteudo = conteudo;
	}
	
	public void desenhar() {
		int a = altura;
		int l = largura;
		for(int i=0; i < a; i++){
                    System.out.print("\n ");
                    if(i==1){
                        for(int j = 0; j< 1; j++ ){
                            System.out.print(conteudo);
                            }
                        }    
			for(int j = 0; j < l; j++){
                          
                                System.out.print(" ");
				System.out.print(conteudo);
				
			}
                    }
                }
        }
