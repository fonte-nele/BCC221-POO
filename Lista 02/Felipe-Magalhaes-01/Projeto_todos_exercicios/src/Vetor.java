public class Vetor
{
	private boolean[] vet = new boolean[3];
	
	public Vetor()
	{
		for(int i=0;i<vet.length;i++)
		{
			System.out.println("Vetor_Booleano[" + i + "]:" + vet[i]);
		}
	}
	public static void main(String[] args)
	{
		System.out.println("Vetor Int Inicializacao:");
		int[] vetor = new int[3];
		for(int i=0;i<vetor.length;i++)
		{
			System.out.println("Vetor_Int[" + i + "]:" + vetor[i]);
		}
		System.out.println("Vetor Booleano Inicializacao:");
		new Vetor();
		System.out.println("Vetor Tipo Referencia Inicializacao:");
		String[] name=new String[3];
		for(int i=0;i<name.length;i++)
		{
			System.out.println("nome[" + i + "]:" + name[i]);
		}
	}
}