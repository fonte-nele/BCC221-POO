import java.util.Vector;
import java.util.NoSuchElementException;
public class VectorTest
{
	private static final String colors[] = { "red", "white", "blue" };
	public VectorTest()
	{
		Vector< String > vector = new Vector< String >();
		printVector( vector );
		// adiciona elementos
		for ( String color : colors )
			vector.add( color );
		printVector( vector );

		// imprime o primeiro e o ultimo elementos
		try
		{
			System.out.printf( "Primeiro elemento: %s\n", vector.firstElement());
			System.out.printf( "Ultimo elemento: %s\n", vector.lastElement() );
		}
		catch ( NoSuchElementException exception )
		{
			exception.printStackTrace();
		}

		// testa se o vetor contem "red"
		if ( vector.contains( "red" ) )
			System.out.printf("\n\"red\" encontrado no indice %d\n\n", vector.indexOf("red"));
		else
			System.out.println( "\n\"red\" nao encontrado\n" );

		vector.remove( "red" ); // remove a string "red"
		System.out.println( "\"red\" foi removido" );
		printVector( vector ); //

		// testa se o vetor contem "red" depois da remocao
		if ( vector.contains( "red" ) )
			System.out.printf("\"red\" encontrado no indice %d\n", vector.indexOf("red"));
		else
			System.out.println( "\"red\" nao encontrado" );
		System.out.printf( "\nTamanho: %d\nCapacidade: %d\n", vector.size(), vector.capacity() );
	}

	private void printVector( Vector< String > vectorToOutput )
	{
		if ( vectorToOutput.isEmpty() )
			System.out.print( "Vetor esta vazio" );
		else // itera pelos elementos
		{
			System.out.print( "Vetor contem: " );
			//exibe os elementos
			for ( String element : vectorToOutput )
				System.out.printf( "%s ", element );
		}

		System.out.println( "\n" );
	}
	public static void main( String args[] )
	{
		new VectorTest();
	}
} 