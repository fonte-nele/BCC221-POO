import java.util.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator; 

public class Colecao
{
	Scanner scan1=new Scanner(System.in);
	Scanner scan2=new Scanner(System.in);
	Scanner scan3=new Scanner(System.in);
	private static final String[] Vetor1=new String[2];
	private static final int[] Vetor2=new int[2];
	private static final int[] Vetor3=new int[2];
	public Colecao()
	{
		List<String> vetor1=new ArrayList<String>();
		List<Integer> vetor2=new ArrayList<Integer>();
		List<Integer> vetor3=new ArrayList<Integer>();
		for(int cont=0;cont<Vetor1.length;cont++)
		{
			System.out.println("Insira o nome da serie\n");
			String titulo=scan1.nextLine();
			Vetor1[cont]=titulo;
			System.out.println("Insira a quantidade de episodios\n");
			int quant_episodios=scan2.nextInt();
			Vetor2[cont]=quant_episodios;
			System.out.println("Insira o ultimo episodio visto\n");
			int ultimo_visto=scan3.nextInt();
			Vetor3[cont]=ultimo_visto;
		}
		for(String titulo : Vetor1)
		{
			
			vetor1.add(titulo);
		}
		for(int quant_capitulos : Vetor2)
		{
			vetor2.add(quant_capitulos);
		}
		for(int ultimo_visto : Vetor3)
		{
			vetor3.add(ultimo_visto);
		}
		for(int cont=0;cont<vetor1.size();cont++)
		{
			System.out.printf(" Serie: %s\n",vetor1.get(cont));
			System.out.printf(" Quantidade de episodios: %d\n",vetor2.get(cont));
			System.out.printf(" Ultimo episodio visto: %d\n\n",vetor3.get(cont));
		}
	}
	public static void main(String args[])
	{
		new Colecao();
	}
}