import java.util.GregorianCalendar;


public class ContaPoupanca extends Conta
{
   private double taxa;

   public ContaPoupanca(int numero, int cpf, String senha, double taxa)
   {
      super(numero, cpf, senha);
      this.taxa = taxa;
   }

   public double getTaxa()
   {
      return taxa;
   }

   public void setTaxa(double taxa)
   {
      this.taxa = taxa;
   }

   @Override
   public String toString()
   {
      return String.format("ContaPoupanca [taxa=%s, toString()=%s]", taxa,
            super.toString());
   }
   
   public void juro()
   {
      double valor = taxa * saldo; 
      saldo = saldo + valor;
      historico.add(new Movimento(new GregorianCalendar(), "poupança", valor));
   }
}
