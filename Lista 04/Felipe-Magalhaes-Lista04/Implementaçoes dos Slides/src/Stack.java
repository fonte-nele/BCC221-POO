public class Stack< E >
{
	private final int size; // numero de elementos da pilha
	private int top; // indice do topo
	private E[] elements; // vetor para armazenar os elementos
	
	// o tamanho padrao e 10
	
	public Stack()
	{
		this( 10 );
	}

	// constroi uma pilha com um tamanho especificado
	public Stack( int s )
	{	
		size = s > 0 ? s : 10;
		top = -1; // pilha vazia inicialmente
		elements = ( E[] ) new Object[ size ]; // cria o vetor
	}

	public void push( E pushValue )
	{
		if ( top == size - 1 )
			//throw new FullStackException( String.format( +"Stack is full, cannot push%s", pushValue ) );
		elements[ ++top ] = pushValue;
	}
	public E pop()
	{
		if ( top == -1 )
			//throw new EmptyStackException( "Stack is empty, cannot pop" );
		return elements[ top-- ];
	}
}