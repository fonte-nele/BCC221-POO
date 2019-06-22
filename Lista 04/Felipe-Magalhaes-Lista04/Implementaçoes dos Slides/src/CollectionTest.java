import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
public class CollectionTest
{
	private static final String[] colors = { "MAGENTA", "RED", "WHITE", "BLUE", "CYAN" };
	private static final String[] removeColors = { "RED", "WHITE", "BLUE" };
	// cria um ArrayList, adiciona cores e manipula
	public CollectionTest()
	{
		List< String > list = new ArrayList< String >();
		List< String > removeList = new ArrayList< String >();
		// adiciona elementos a lista
		for ( String color : colors )
			list.add( color );
		// adiciona elementos a lista
		for ( String color : removeColors )
			removeList.add( color );
		System.out.println( "Lista: " );
		 // exibe o conteudo
		for ( int count = 0; count < list.size(); count++ )
			System.out.printf( "%s ", list.get( count ) );
		// remove elementos
		removeColors( list, removeList );
			System.out.println( "\n\nLista apos chamar o metodo removeColors: " );
		// exibe o conteudo
			for ( String color : list )
		System.out.printf( "%s ", color );
	 }
	 // remove elementos especificados em collection2 de collection1
	 private void removeColors(Collection< String > collection1, Collection< String > collection2 )
	 {
		 // retorna o iterador
		 Iterator< String > iterator = collection1.iterator();
		 // percorre a colecao enquanto houverem itens
		 while ( iterator.hasNext() )
			 if ( collection2.contains( iterator.next() ) )
				 iterator.remove(); // remove
	 }
	 public static void main( String args[] )
	 {
		 new CollectionTest();
	 }
}