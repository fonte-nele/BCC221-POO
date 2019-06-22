public class Matriz
{
	public static void main(String[] args)
	{
		int i,j;
		for(i=0;i<3;i++)
		{
			for(j=0;j<3;j++)
			{
				System.out.print((i+1)+""+(j+1));
				if(j<2)
				{
					System.out.print("\t");
				}
			}
			if(i<2)
			{
				System.out.println();
			}
		}
	}
}