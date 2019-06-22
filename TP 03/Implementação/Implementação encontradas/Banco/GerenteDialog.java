import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class GerenteDialog extends JDialog implements ActionListener
{
   private Banco banco;

   private JButton bClientes;
   private JButton bContas;
   private JButton bFechar;
      
   public GerenteDialog(JFrame frame, Banco banco)
   {
      super(frame, "Gerenciamento do cadastro de clientes", true);
      setLayout(new GridBagLayout());
      
      this.banco = banco;
      
      JLabel label = new JLabel(banco.getNome());
      Font font = label.getFont();
      label.setFont(font.deriveFont(Font.BOLD, font.getSize()*1.12f));
      add(label, new GBConstraints(0, 0, 1, 1).setInsets(8, 8, 8, 8).setAnchor(GBConstraints.Anchor.Center));

      bClientes = new JButton("Clientes");
      add(bClientes, new GBConstraints(1, 0, 1, 1).setInsets(4, 4, 4, 4).setFill(GBConstraints.Fill.Horizontal));
      bClientes.addActionListener(this);
      
      bContas = new JButton("Contas");
      add(bContas, new GBConstraints(2, 0, 1, 1).setInsets(4, 4, 4, 4).setFill(GBConstraints.Fill.Horizontal));
      bContas.addActionListener(this);

      bFechar = new JButton("Fechar");
      add(bFechar, new GBConstraints(3, 0, 2, 1).setInsets(4, 4, 4, 4).setFill(GBConstraints.Fill.Horizontal));
      bFechar.addActionListener(this);
      
      setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      pack();
      setVisible(true);
   }

   @Override
   public void actionPerformed(ActionEvent e)
   {
      if (e.getSource() == bClientes)
         new ClientesDialog(this, banco);
      else if (e.getSource() == bContas)
         new ContasDialog(this, banco);
      else if (e.getSource() == bFechar)
      {
         dispose();
      }
   }
}
