public class StringTamanho
{
	public static void main(String[] args)
	{
		String str1 = new String();
		String str2 = new String("Hello");
		int len1 = str1.length();
		int len2 = str2.length();
		System.out.println("Tamanho de \"" + str1 + "\" = " + len1);
		System.out.println("Tamanho de \"" + str2 + "\" = " + len2);
	}
}