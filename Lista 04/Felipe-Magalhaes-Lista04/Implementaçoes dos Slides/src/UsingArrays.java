import java.util.Arrays;
public class UsingArrays
{
	private int intArray[] = { 1, 2, 3, 4, 5, 6 };
	private double doubleArray[] = { 8.4, 9.3, 0.2, 7.9, 3.4 };
	private int filledIntArray[], intArrayCopy[];
	public UsingArrays()
	{
		 filledIntArray = new int[ 10 ];
		 intArrayCopy = new int[ intArray.length ];
		 Arrays.fill( filledIntArray, 7 ); // preenche com 7s
		 Arrays.sort( doubleArray ); // ordena crescentemente
		 // preenche os vetores
		 System.arraycopy( intArray, 0, intArrayCopy, 0, intArray.length );
	}
	public void printArrays()
	{
		 System.out.print( "Vetor de double: " );
		 	for ( double doubleValue : doubleArray )
		 System.out.printf( "%.1f ", doubleValue );
		 System.out.print( "\nVetor de inteiros: " );
		 	for ( int intValue : intArray )
		 System.out.printf( "%d ", intValue );
		 System.out.print( "\nVetor de inteiros preenchido: " );
		 	for ( int intValue : filledIntArray )
		 System.out.printf( "%d ", intValue );
		 System.out.print( "\nCopia do vetor de inteiros: " );
		 	for ( int intValue : intArrayCopy )
		 System.out.printf( "%d ", intValue );
		 System.out.println( "\n" );
	 }
	 // pesquisa um valor no vetor
	 public int searchForInt( int value )
	 {
		 return Arrays.binarySearch( intArray, value );
	 }

	 // compara o conteudo dos vetores
	 public void printEquality()
	 {
		 boolean b = Arrays.equals( intArray, intArrayCopy );
		 System.out.printf( "Vetor de inteiros %s Copia do vetor de inteiros\n", ( b ? "==" : "!=" ) );
		 b = Arrays.equals( intArray, filledIntArray );
		 System.out.printf( "Vetor de inteiros %s Vetor de inteiros preenchido\n", ( b ? "==" : "!=" ) );
	 }
	 public static void main( String args[] )
	 {
		 UsingArrays usingArrays = new UsingArrays();
		 usingArrays.printArrays();
		 usingArrays.printEquality();
		 int location = usingArrays.searchForInt( 5 );
		 if ( location >= 0 )
			 System.out.printf( "5 foi encontrado na posicao %d no vetor de inteiros\n", location );
		 else
			 System.out.println( "5 nao foi encontrado no vetor de inteiros" );
		 location = usingArrays.searchForInt( 8763 );
		 if ( location >= 0 )
			 System.out.printf( "8763 foi encontrado na posicao %d no vetor de inteiros\n", location );
		 else
			 System.out.println( "8763 nao foi encontrado no vetor de inteiros" );
	 }
}