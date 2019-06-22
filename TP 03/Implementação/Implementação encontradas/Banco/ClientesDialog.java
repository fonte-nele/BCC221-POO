import java.awt.Dialog;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;


public class ClientesDialog extends JDialog implements ActionListener, ListSelectionListener
{
   private JTextField tfNome;
   private JTextField tfCpf;
   private JTextField tfEndereco;
   private JButton bAlterar;
   private JButton bAdicionar;
   private JButton bRemover;
   private JButton bFechar;
   private JTable table;
   private ClienteModel model;
   
   private Banco banco;
   private List<Cliente> clientes;
      
   public ClientesDialog(Dialog frame, Banco banco)
   {
      super(frame, "Gerenciamento do cadastro de clientes", true);
      setLayout(new GridBagLayout());
      
      this.banco = banco;
      clientes = banco.getClientes();
      
      JLabel label = new JLabel(banco.getNome());
      Font font = label.getFont();
      label.setFont(font.deriveFont(Font.BOLD, font.getSize()*1.12f));
      add(label, new GBConstraints(0, 0, 2, 1).setInsets(8, 8, 8, 8).setAnchor(GBConstraints.Anchor.Center));
      
      model = new ClienteModel(clientes);
      table = new JTable(model);
      JScrollPane scrollPane = new JScrollPane(table);
      add(scrollPane, new GBConstraints(1, 0, 2, 1).setInsets(4, 4, 4, 4).setFill(GBConstraints.Fill.Both).setWeight(1, 1));
      table.getSelectionModel().addListSelectionListener(this);
      
      label = new JLabel("Nome");
      add(label, new GBConstraints(2, 0, 1, 1).setInsets(4, 4, 4, 4).setAnchor(GBConstraints.Anchor.West));
      tfNome = new JTextField(30);
      add(tfNome, new GBConstraints(2, 1, 1, 1).setInsets(4, 4, 4, 4).setFill(GBConstraints.Fill.Horizontal));
      tfNome.addActionListener(this);
      
      label = new JLabel("CPF");
      add(label, new GBConstraints(3, 0, 1, 1).setInsets(4, 4, 4, 4).setAnchor(GBConstraints.Anchor.West));
      tfCpf = new JTextField(30);
      add(tfCpf, new GBConstraints(3, 1, 1, 1).setInsets(4, 4, 4, 4).setFill(GBConstraints.Fill.Horizontal));
      tfCpf.addActionListener(this);
      
      label = new JLabel("Endereço");
      add(label, new GBConstraints(4, 0, 1, 1).setInsets(4, 4, 4, 4).setAnchor(GBConstraints.Anchor.West));
      tfEndereco = new JTextField(30);
      add(tfEndereco, new GBConstraints(4, 1, 1, 1).setInsets(4, 4, 4, 4).setFill(GBConstraints.Fill.Horizontal));
      tfEndereco.addActionListener(this);
      
      Box box = new Box(BoxLayout.LINE_AXIS);
      add(box, new GBConstraints(5, 0, 2, 1).setInsets(4, 4, 4, 4).setFill(GBConstraints.Fill.Horizontal));

      bAlterar = new JButton("Alterar");
      box.add(bAlterar);
      bAlterar.addActionListener(this);
      box.add(Box.createHorizontalStrut(8));

      bAdicionar = new JButton("Adicionar");
      box.add(bAdicionar);
      bAdicionar.addActionListener(this);
      box.add(Box.createHorizontalStrut(8));
      
      bRemover = new JButton("Remover");
      box.add(bRemover);
      bRemover.addActionListener(this);     
      box.add(Box.createHorizontalGlue());
      
      bFechar = new JButton("Fechar");
      box.add(bFechar);
      bFechar.addActionListener(this);
      
      setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      pack();
      setVisible(true);
   }

   @Override
   public void actionPerformed(ActionEvent e)
   {
      if (e.getSource() == bAdicionar)
      {
         int cpf = -1;
         try { cpf = Integer.parseInt(tfCpf.getText()); }
         catch (NumberFormatException ex) { }
         String nome = tfNome.getText().trim();
         String endereco = tfEndereco.getText().trim();
         if (nome.isEmpty())
             JOptionPane.showMessageDialog(this, "Nome do cliente não pode ser vazio.", "Erro", JOptionPane.ERROR_MESSAGE);
         else if (cpf < 0)
             JOptionPane.showMessageDialog(this, "CPF inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
         else
         {
            int pos;
            for (pos = 0; pos < clientes.size(); pos++)
            {
               int cpf_cliente = clientes.get(pos).getCpf();
                if (cpf == cpf_cliente)
                {
                    JOptionPane.showMessageDialog(this, "O CPF " + cpf + " já está em uso", "Erro", JOptionPane.ERROR_MESSAGE);
                    pos = -1;
                    break;
                }
                else if (cpf < cpf_cliente)
                    break;
            }
            if (pos >= 0)
            {
                model.addRow(new Cliente(cpf, nome, endereco), pos);
                tfNome.setText("");
                tfCpf.setText("");
                tfEndereco.setText("");
            }
        }
      }
      else if (e.getSource() == bAlterar)
      {
         int cpf = -1;
         try { cpf = Integer.parseInt(tfCpf.getText()); }
         catch (NumberFormatException ex) { }
         String nome = tfNome.getText().trim();
         String endereco = tfEndereco.getText().trim();
         if (nome.isEmpty())
             JOptionPane.showMessageDialog(this, "Nome do cliente não pode ser vazio.", "Erro", JOptionPane.ERROR_MESSAGE);
         else if (cpf < 0)
             JOptionPane.showMessageDialog(this, "CPF inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
         else
         {
            int pos;
            for (pos = 0; pos < clientes.size(); pos++)
            {
               int cpf_cliente = clientes.get(pos).getCpf();
                if (cpf == cpf_cliente && pos != table.getSelectedRow())
                {
                    JOptionPane.showMessageDialog(this, "O CPF " + cpf + " já está em uso", "Erro", JOptionPane.ERROR_MESSAGE);
                    pos = -1;
                    break;
                }
                else if (cpf < cpf_cliente)
                    break;
            }
            if (pos >= 0)
               model.updateRow(nome, cpf, endereco, table.getSelectedRow());
        }
      }
      else if (e.getSource() == bRemover)
      {
         int index = table.getSelectedRow();
         if (index >= 0)
         {
             int cpf = (Integer) table.getValueAt(index, 1);
             boolean inUse = false;
             for (Conta c : banco.getContas())
                if (cpf == c.getCpf())
                {
                   inUse = true;
                   break;
                }
             if (inUse)
                JOptionPane.showMessageDialog(this, "O CPF " + cpf + " é titular de alguma conta", "Erro", JOptionPane.ERROR_MESSAGE);                        
             else
                model.removeRow(index);
         }
      }
      else if (e.getSource() == bFechar)
      {
         dispose();
      }
   }

   @Override
   public void valueChanged(ListSelectionEvent e)
   {
      if (! e.getValueIsAdjusting())
      {
         int index = ((ListSelectionModel) e.getSource()).getMinSelectionIndex();
         if (index >= 0)
         {
            tfNome.setText((String) table.getValueAt(index, 0));
            tfCpf.setText("" + table.getValueAt(index, 1));
            tfEndereco.setText((String) table.getValueAt(index, 2));
         }
         else
         {
            tfNome.setText("");
            tfCpf.setText("");
            tfEndereco.setText("");
         }
      }  
   }
}

class ClienteModel extends AbstractTableModel
{
   private List<Cliente> clientes;
   
   public ClienteModel(List<Cliente> clientes)
   {
      this.clientes = clientes;
   }

   @Override
   public int getRowCount()
   {
      return clientes.size();
   }
   
   @Override
   public int getColumnCount()
   {
      return 3;
   }

   public String getColumnName(int col)
   {
      switch (col)
      {
         case 0: return "Nome";
         case 1: return "CPF";
         case 2: return "Endereço";
      }
      return null;
   }
   
   @Override
   public Object getValueAt(int rowIndex, int columnIndex)
   {
      switch (columnIndex)
      {
         case 0: return clientes.get(rowIndex).getNome();
         case 1: return clientes.get(rowIndex).getCpf();
         case 2: return clientes.get(rowIndex).getEndereco();
      }
      return null;
   }
   
   public void addRow(Cliente value, int row)
   {
       clientes.add(row, value);
       fireTableRowsInserted(row, row);
   }                             
   
   public void updateRow(String nome, int cpf, String endereco, int row)
   {
      Cliente c = clientes.get(row);
      c.setNome(nome);
      c.setCpf(cpf);
      c.setEndereco(endereco);
      fireTableRowsUpdated(row, row);
   }                             
   
   public void removeRow(int row)
   {
      clientes.remove(row);
      fireTableRowsDeleted(row, row);
   }                    
}
