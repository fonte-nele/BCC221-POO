import javax.swing.JOptionPane;

public class Adicao
{
	public static void main(String args[])
	{
		String primeiro,segundo;
		int num1,num2,soma;
		
		primeiro = JOptionPane.showInputDialog("Digite um número inteiro:");
		segundo = JOptionPane.showInputDialog("Digite outro número inteiro:");
		
		num1 = Integer.parseInt(primeiro);
		num2 = Integer.parseInt(segundo);
		
		soma = num1+num2;
		
		JOptionPane.showMessageDialog(null,"A soma é: "+soma, "Resultado!",JOptionPane.PLAIN_MESSAGE);
		return;
	}
}