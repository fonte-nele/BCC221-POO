public class NumTeste
{
	public static void main(String[] args)
	{
		int anInt = 100;
		long aLong = 200L;
		byte aByte = 65;
		short aShort = (-902);
		char aChar = 'A';
		float aFloat = 10.98F;
		double aDouble = 899.89;
		
		//Imprimir valor das variáveis!!!
		System.out.println("Um Int = "+anInt);
		System.out.println("Um Long = "+aLong);
		System.out.println("Um Byte = "+aByte);
		System.out.println("Um Short = "+aShort);
		System.out.println("Um Char = "+aChar);
		System.out.println("Um Float = "+aFloat);
		System.out.println("Um Double = "+aDouble);
		System.out.println("Max double = "+Double.MAX_VALUE);
		System.out.println("Min double = "+Double.MIN_VALUE);
		System.out.println("Positivo infinito para double = "+Double.POSITIVE_INFINITY);
		System.out.println("Negativo infinito para double = "+Double.NEGATIVE_INFINITY);
		System.out.println("Nao eh um numero para double = "+Double.NaN);
		System.out.println("Double takes = " +Double.BYTES +" bytes");
	}
}