import java.util.List;
import java.util.LinkedList;
import java.util.ListIterator;
public class ListTest
{
	private static final String colors[] = { "black", "yellow", "green", "blue", "violet","silver" };
	private static final String colors2[] = { "gold", "white", "brown", "blue", "gray","silver" };

	// define e manipula objetos LinkedList
	public ListTest()
	{
		List< String > list1 = new LinkedList< String >();
		List< String > list2 = new LinkedList< String >();
		// adiciona elementos
		for ( String color : colors )
			list1.add( color );
		// adiciona elementos
		for ( String color : colors2 )
			list2.add( color );
		list1.addAll( list2 ); // concatena as listas
		list2 = null; // libera
		printList( list1 ); // exibe os elementos
		convertToUppercaseStrings( list1 ); // converte para maiusculas
		printList( list1 ); // exibe os elementos
		System.out.print( "\nDeletando os elementos de 4 a 7..." );
		removeItems( list1, 4, 7 ); // remove os itens 4-7 da lista
		printList( list1 ); // exibe os elementos
		printReversedList( list1 ); // exibe os elementos na ordem inversa
	}
	// exibe os elementos da lista
	public void printList( List< String > list )
	{
		System.out.println( "\nLista: " );

		for ( String color : list )
			System.out.printf( "%s ", color );
		System.out.println();
	}
	// converte para maiusculas
	private void convertToUppercaseStrings( List< String > list )
	{
		ListIterator< String > iterator = list.listIterator();
		while ( iterator.hasNext() )
		{
			String color = iterator.next(); // retorna o item
			iterator.set( color.toUpperCase() ); // converte
		}
	}
	// obtem a sublista e a deleta usando o metodo clear
	private void removeItems( List< String > list, int start, int end )
	{
		list.subList( start, end ).clear(); // remove os itens
	}
	// imprime a lista invertida
	private void printReversedList( List< String > list )
 	{
		ListIterator< String > iterator = list.listIterator( list.size() );
		System.out.println( "\nLista reversa:" );
		// imprime a lista invertida
		while ( iterator.hasPrevious() )
			System.out.printf( "%s ", iterator.previous() );
 	}	

	public static void main( String args[] )
	{
		new ListTest();
	}
}