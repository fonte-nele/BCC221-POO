import javax.swing.JOptionPane;

public class Adicao
{
	public static void main(String args[])
	{
		String primeiro,segundo;
		int num1,num2,soma;
		
		primeiro = JOptionPane.showInputDialog("Digite um n�mero inteiro:");
		segundo = JOptionPane.showInputDialog("Digite outro n�mero inteiro:");
		
		num1 = Integer.parseInt(primeiro);
		num2 = Integer.parseInt(segundo);
		
		soma = num1+num2;
		
		JOptionPane.showMessageDialog(null,"A soma �: "+soma, "Resultado!",JOptionPane.PLAIN_MESSAGE);
		return;
	}
}