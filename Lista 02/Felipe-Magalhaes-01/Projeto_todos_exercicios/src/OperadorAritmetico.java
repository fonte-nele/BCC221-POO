public class OperadorAritmetico
{
	public static void main(String[] args)
	{
		int num = 120;
		double num_real = 25.5F;
		double num_grande = 25.8/0.0;
		double lixo = 0.0/0.0;
		boolean teste = true;
		
		System.out.println("Numero = "+num);
		System.out.println("Numero Real = "+num_real);
		System.out.println("Numero Grande = "+num_grande);
		System.out.println("Lixo = "+lixo);
		System.out.println("Teste = "+teste);
		
		//Imprimir valor máximo Int!!!
		System.out.println("Maximo int = "+Integer.MAX_VALUE);
		//Imprimir valor máximo Double
		System.out.println("Maximo double = "+Double.MAX_VALUE);
		
		System.out.println("12.5 + 100 = "+(12.5 + 100));
		System.out.println("12.5 - 100 = "+(12.5 - 100));
		System.out.println("12.5 * 100 = "+(12.5 * 100));
		System.out.println("12.5 / 100 = "+(12.5 / 100));
		System.out.println("12.5 % 100 = "+(12.5 % 100));
		System.out.println("\"abc\" + \"xyz\" = " + "\"" + ("abc" + "xyz")+ "\"");
	}
}
