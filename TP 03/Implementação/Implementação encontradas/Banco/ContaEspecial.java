import java.util.GregorianCalendar;


public class ContaEspecial extends Conta
{
   private double limite;
   
   public ContaEspecial(int numero, int cpf, String senha, double limite)
   {
      super(numero, cpf, senha);
      this.limite = limite;
   }

   public double getLimite()
   {
      return limite;
   }

   public void setLimite(double limite)
   {
      this.limite = limite;
   }

   @Override
   public String toString()
   {
      return String.format("ContaEspecial [limite=%s, toString()=%s]", limite,
            super.toString());
   }

   @Override
   public void saque(double valor)
   {
      if (valor < 0)
         throw new BancoException("valor negativo");
      if (valor > saldo + limite)
         throw new BancoException("saldo insuficiente");
      saldo = saldo - valor;
      historico.add(new Movimento(new GregorianCalendar(), "saque", valor));
}

}
