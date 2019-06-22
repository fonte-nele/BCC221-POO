import java.util.Stack;

public class StackTest
{
	public StackTest()
	{
		Stack < Number > stack = new Stack < Number >();

		Long longNumber = 12L;
		Integer intNumber = 34567 ;
		Float floatNumber = 1.0F;
		Double doubleNumber = 1234.5678 ;
		stack.push( longNumber );
		printStack( stack );
		stack.push( intNumber );
		printStack(stack );
		stack.push( floatNumber );
		printStack( stack );
		stack.push( doubleNumber );
		printStack( stack );
	 }
	 private void printStack( Stack< Number > stack )
	 {
		 if ( stack.isEmpty() )
			 System.out.print("Stack esta vazia\n\n");
		 else
		 {
			 System.out.print("Conteudo Stack: " );

	  
		 for ( Number number : stack )
			 System.out.printf( "%s ", number );

		 System.out.print( "(top) \n\n" );
		 }
	  }
	 public static void main( String args[] )
	 {
		 new StackTest();
	 }
}