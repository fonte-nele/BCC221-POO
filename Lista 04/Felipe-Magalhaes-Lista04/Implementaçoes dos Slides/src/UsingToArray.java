import java.util.LinkedList;
import java.util.Arrays;
public class UsingToArray
{
	// cria uma LinkedList, adiciona elementos e converte para um vetor
	public UsingToArray()
	{
		String colors[] = { "black", "blue", "yellow" };
		LinkedList<String> links = new LinkedList< String >(Arrays.asList(colors));
 	links.addLast( "red" ); // adiciona o ultimo item
 	links.add( "pink" ); // adiciona ao final
 	links.add( 3, "green" ); // adiciona no indice 3
 	links.addFirst( "cyan" ); // adiciona como primeiro item
 	// converte para um vetor
 	colors = links.toArray( new String[ links.size() ] );
 	System.out.println( "colors: " );
 	for ( String color : colors )
 		System.out.println( color );
	}
	public static void main( String args[] )
	{
		new UsingToArray();
	}
}