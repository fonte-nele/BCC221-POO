import java.util.Calendar;

public class Movimento
{
   private Calendar data;
   private String descricao;
   private double valor;
   
   public Movimento(Calendar data, String descricao, double valor)
   {
      this.data = data;
      this.descricao = descricao;
      this.valor = valor;
   }

   public Calendar getData()
   {
      return data;
   }
   public String getDescricao()
   {
      return descricao;
   }
   public double getValor()
   {
      return valor;
   }

   @Override
   public String toString()
   {
      return String.format(
            "Movimento [data=%s, descricao=%s, valor=%s]",
            data, descricao, valor);
   }   
}
