import java.io.Serializable;


public class Cliente implements Serializable
{
   private int cpf;
   private String nome;
   private String endereco;
   
   public Cliente(int cpf, String nome, String endereco)
   {
      this.cpf = cpf;
      this.nome = nome;
      this.endereco = endereco;
   }

   public int getCpf()
   {
      return cpf;
   }

   public void setCpf(int cpf)
   {
      this.cpf = cpf;
   }

   public String getNome()
   {
      return nome;
   }

   public void setNome(String nome)
   {
      this.nome = nome;
   }

   public String getEndereco()
   {
      return endereco;
   }

   public void setEndereco(String endereco)
   {
      this.endereco = endereco;
   }

   @Override
   public String toString()
   {
      return String.format("Cliente [cpf=%s, nome=%s, endereco=%s]", cpf, nome,
            endereco);
   }
}
