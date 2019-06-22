import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;


public class Banco implements Serializable
{
   private String nome;
   private List<Cliente> clientes;
   private List<Conta> contas;
   private int ultimaConta;
   private String senha;
   
   public Banco(String nome, String senha)
   {
      this.nome = nome;
      this.senha = senha;
      this.clientes = new LinkedList<Cliente>();
      this.contas = new LinkedList<Conta>();
      this.ultimaConta = 0;
   }

   public String getNome()
   {
      return nome;
   }

   public List<Cliente> getClientes()
   {
      return clientes;
   }

   public List<Conta> getContas()
   {
      return contas;
   }

   @Override
   public String toString()
   {
      return nome;
   }
   
   public Cliente encontraCliente(int cpf)
   {
      for (Cliente x : clientes)
         if (x.getCpf() == cpf)
            return x;
      return null;
   }
   
   public Conta encontraConta(int numero)
   {
      for (Conta x : contas)
         if (x.getNumero() == numero)
            return x;
      return null;
   }
}
