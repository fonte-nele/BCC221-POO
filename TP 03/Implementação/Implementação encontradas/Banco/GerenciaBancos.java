import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class GerenciaBancos extends JFrame implements ActionListener
{
   private File file = new File("bancos.ser");
   
   private Vector<Banco> bancos;

   private JComboBox cbBancos;
   private JButton bNovoBanco;
   private JButton bGerenciar;
   private JButton bCaixaAutomatico;
   private JButton bSair;
   private DefaultComboBoxModel model;

   public GerenciaBancos()
   {
      super("Gerenciamento de Bancos");
      
      if (file.canRead())
         try
         {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream(file));
            bancos = (Vector<Banco>) (input.readObject());
            input.close();
         }
         catch (IOException ioException)
         {
            JOptionPane.showMessageDialog(this, "Erro lendo arquivo", "Erro", JOptionPane.ERROR_MESSAGE);
         }
         catch (ClassNotFoundException classNotFoundException)
         {
            JOptionPane.showMessageDialog(this, "Erro criando objeto", "Erro", JOptionPane.ERROR_MESSAGE);         
         }
      else
      {
         JOptionPane.showMessageDialog(this, "Arquivo não pode ser lido", "Aviso", JOptionPane.WARNING_MESSAGE);         
         bancos = new Vector<Banco>();
         bancos.add(new Banco("Banco BCC221", "123"));
      }
      if (! file.canWrite())
         JOptionPane.showMessageDialog(this, "Arquivo não pode ser escrito", "Aviso", JOptionPane.WARNING_MESSAGE);         
      
      GridBagLayout layout = new GridBagLayout();
      setLayout(layout);
      
      JLabel label = new JLabel("Banco");
      add(label, new GBConstraints(0, 0, 1, 1).setInsets(4, 4, 4, 4).setAnchor(GBConstraints.Anchor.West));
      
      model = new DefaultComboBoxModel(bancos);
      cbBancos = new JComboBox(model);
      cbBancos.setEditable(false);
      add(cbBancos, new GBConstraints(0, 1, 1, 1).setInsets(4, 4, 4, 4).setFill(GBConstraints.Fill.Horizontal).setWeightX(1));
      
      bNovoBanco = new JButton("Criar Novo Banco");
      add(bNovoBanco, new GBConstraints(1, 0, 2, 1).setInsets(4, 4, 4, 4).setFill(GBConstraints.Fill.Horizontal));
      
      bGerenciar = new JButton("Gerenciar Banco");
      add(bGerenciar, new GBConstraints(2, 0, 2, 1).setInsets(4, 4, 4, 4).setFill(GBConstraints.Fill.Horizontal));
      
      bCaixaAutomatico = new JButton("Caixa Automático");
      add(bCaixaAutomatico, new GBConstraints(3, 0, 2, 1).setInsets(4, 4, 4, 4).setFill(GBConstraints.Fill.Horizontal));
      
      bSair = new JButton("Sair");
      add(bSair, new GBConstraints(4, 0, 2, 1).setInsets(4, 4, 4, 4).setFill(GBConstraints.Fill.Horizontal));

      bNovoBanco.addActionListener(this);
      bGerenciar.addActionListener(this);
      bCaixaAutomatico.addActionListener(this);
      bSair.addActionListener(this);
      
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      pack();
   }
   
   @Override
   public void actionPerformed(ActionEvent e)
   {
      if (e.getSource() == bNovoBanco)
         new NovoBancoDialog(this, model);
      else if (e.getSource() == bGerenciar)
         new GerenteDialog(this, (Banco) model.getSelectedItem());
      else if (e.getSource() == bCaixaAutomatico)
         JOptionPane.showMessageDialog(this, "Não implementado", "Aviso", JOptionPane.INFORMATION_MESSAGE);
      else if (e.getSource() == bSair)
      {
         try
         {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(file));
            output.writeObject(bancos);
            output.close();
         }
         catch (IOException ioException)
         {
            JOptionPane.showMessageDialog(this, "Erro escrevendo arquivo", "Erro", JOptionPane.ERROR_MESSAGE);
         }
         dispose();
      }
   }

   public Vector<Banco> getBancos()
   {
      return bancos;
   }
}
