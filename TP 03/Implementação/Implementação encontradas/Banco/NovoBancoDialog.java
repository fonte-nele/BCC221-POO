import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class NovoBancoDialog extends JDialog implements ActionListener
{
   private JTextField tfNome;
   private JPasswordField pfSenha;
   private JButton bCancel;
   private JButton bOk;
   private DefaultComboBoxModel model;
      
   public NovoBancoDialog(GerenciaBancos frame, DefaultComboBoxModel model)
   {
      super(frame, "Criação de Novo Banco", true);
      setLayout(new GridBagLayout());
      
      this.model = model;
      
      JLabel label = new JLabel("Nome do Banco");
      add(label, new GBConstraints(0, 0, 1, 1).setInsets(4, 4, 4, 4).setAnchor(GBConstraints.Anchor.West));
      tfNome = new JTextField(30);
      add(tfNome, new GBConstraints(0, 1, 1, 1).setInsets(4, 4, 4, 4).setFill(GBConstraints.Fill.Horizontal));
      tfNome.addActionListener(this);
      
      label = new JLabel("Senha de Gerenciamento");
      add(label, new GBConstraints(1, 0, 1, 1).setInsets(4, 4, 4, 4).setAnchor(GBConstraints.Anchor.West));
      pfSenha = new JPasswordField(30);
      add(pfSenha, new GBConstraints(1, 1, 1, 1).setInsets(4, 4, 4, 4).setFill(GBConstraints.Fill.Horizontal));
      pfSenha.addActionListener(this);
      
      Box box = new Box(BoxLayout.LINE_AXIS);
      add(box, new GBConstraints(2, 0, 2, 1).setInsets(4, 4, 4, 4).setFill(GBConstraints.Fill.Horizontal));
      box.add(Box.createHorizontalGlue());
      
      bCancel = new JButton("Cancelar");
      box.add(bCancel);
      bCancel.addActionListener(this);
      box.add(Box.createHorizontalStrut(8));
      
      bOk = new JButton("Aceitar");
      box.add(bOk);
      bOk.addActionListener(this);
      
      setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      pack();
      setVisible(true);
   }

   @Override
   public void actionPerformed(ActionEvent e)
   {
      if (e.getSource() == bCancel)
      {
         dispose();
      }
      else if (e.getSource() == bOk)
      {
         String nome = tfNome.getText().trim();
         String senha = new String(pfSenha.getPassword());
         if (nome.isEmpty())
            JOptionPane.showMessageDialog(this, "Nome do banco não pode ser vazio", "Erro", JOptionPane.ERROR_MESSAGE);
         else if (senha.length() < 3)
            JOptionPane.showMessageDialog(this, "Senha deve ter pelo menos três caracteres", "Erro", JOptionPane.ERROR_MESSAGE);
         else
         {
            int n = model.getSize();
            int pos;
            for (pos = 0; pos < n; pos++)
            {
               int cmp = ((Banco)model.getElementAt(pos)).getNome().compareTo(nome);
               System.out.printf("%s.compare(%s) = %d\n", ((Banco)model.getElementAt(pos)).getNome(), nome, cmp);
               if (cmp == 0) { pos = -1; break; }
               else if (cmp > 0) break;
            }
            if (pos >= 0) model.insertElementAt(new Banco(nome, senha), pos);
            dispose();
         }
      }
   }
}
