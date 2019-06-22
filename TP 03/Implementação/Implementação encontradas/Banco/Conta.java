import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;


public class Conta implements Serializable
{
   private int numero;
   private int cpf;
   private String senha;
   protected double saldo;
   protected List<Movimento> historico;

   public Conta(int numero, int cpf, String senha)
   {
      this.numero = numero;
      this.cpf = cpf;
      this.senha = senha;
      this.saldo = 0;
      this.historico = new LinkedList<Movimento>();
   }

   public int getNumero()
   {
      return numero;
   }

   public void setNumero(int numero)
   {
      this.numero = numero;
   }

   public int getCpf()
   {
      return cpf;
   }

   public void setCpf(int cpf)
   {
      this.cpf = cpf;
   }

   public String getSenha()
   {
      return senha;
   }

   public void setSenha(String senha)
   {
      this.senha = senha;
   }

   public double getSaldo()
   {
      return saldo;
   }
   
   @Override
   public String toString()
   {
      return String.format("Conta [numero=%s, cpf=%s, senha=%s, saldo=%s]",
            numero, cpf, senha, saldo);
   }

   public void deposito(double valor)
   {
      if (valor < 0)
         throw new BancoException("valor negativo");
      saldo += valor;
      historico.add(new Movimento(new GregorianCalendar(), "depósito", valor));
   }
   
   public void saque(double valor)
   {
      if (valor < 0)
         throw new BancoException("valor negativo");
      if (valor > saldo)
         throw new BancoException("saldo insuficiente");
      saldo = saldo - valor;
      historico.add(new Movimento(new GregorianCalendar(), "saque", valor));
   }
}
