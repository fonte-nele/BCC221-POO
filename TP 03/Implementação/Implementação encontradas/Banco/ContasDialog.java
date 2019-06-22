import java.awt.Dialog;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;


public class ContasDialog extends JDialog implements ActionListener, ListSelectionListener, ItemListener
{
   private Banco banco;
   private List<Conta> contas;
   
   private JTextField tfNumero;
   private JTextField tfCpf;
   private JTextField tfSenha;
   private JTextField tfLimite;
   private JTextField tfTaxa;
   private ButtonGroup grupo;
   private JRadioButton bSimples;
   private JRadioButton bEspecial;
   private JRadioButton bPoupanca;
   private JButton bAdicionar;
   private JButton bAlterar;
   private JButton bRemover;
   private JButton bFechar;
   private JTable table;
   private ContasModel model;
      
   public ContasDialog(Dialog frame, Banco banco)
   {
      super(frame, "Gerenciamento da carteira de contas");
      setLayout(new GridBagLayout());
      
      this.banco = banco;
      contas = banco.getContas();
      
      JLabel label = new JLabel(banco.getNome());
      Font font = label.getFont();
      label.setFont(font.deriveFont(Font.BOLD, font.getSize()*1.12f));
      add(label, new GBConstraints(0, 0, 2, 1).setInsets(8, 8, 8, 8).setAnchor(GBConstraints.Anchor.Center));
      
      model = new ContasModel(contas);
      table = new JTable(model);
      JScrollPane scrollPane = new JScrollPane(table);
      add(scrollPane, new GBConstraints(1, 0, 2, 1).setInsets(4, 4, 4, 4).setFill(GBConstraints.Fill.Both).setWeight(1, 1));
      table.getSelectionModel().addListSelectionListener(this);
      
      label = new JLabel("Número");
      add(label, new GBConstraints(2, 0, 1, 1).setInsets(4, 4, 4, 4).setAnchor(GBConstraints.Anchor.West));
      tfNumero = new JTextField(30);
      add(tfNumero, new GBConstraints(2, 1, 1, 1).setInsets(4, 4, 4, 4).setFill(GBConstraints.Fill.Horizontal));
      tfNumero.addActionListener(this);
      
      label = new JLabel("CPF do Titular");
      add(label, new GBConstraints(3, 0, 1, 1).setInsets(4, 4, 4, 4).setAnchor(GBConstraints.Anchor.West));
      tfCpf = new JTextField(30);
      add(tfCpf, new GBConstraints(3, 1, 1, 1).setInsets(4, 4, 4, 4).setFill(GBConstraints.Fill.Horizontal));
      tfCpf.addActionListener(this);
      
      label = new JLabel("Senha");
      add(label, new GBConstraints(4, 0, 1, 1).setInsets(2, 2, 2, 2).setAnchor(GBConstraints.Anchor.West));
      tfSenha = new JTextField(30);
      add(tfSenha, new GBConstraints(4, 1, 1, 1).setInsets(2, 2, 2, 2).setFill(GBConstraints.Fill.Both));
      tfSenha.addActionListener(this);
      
      grupo = new ButtonGroup();
      
      bSimples = new JRadioButton("Conta simples");
      grupo.add(bSimples);
      bSimples.setSelected(true);
      add(bSimples, new GBConstraints(5, 0, 1, 1).setInsets(2, 2, 2, 2).setFill(GBConstraints.Fill.Both));
      bSimples.addItemListener(this);
      
      bEspecial = new JRadioButton("Conta especial");
      grupo.add(bEspecial);
      add(bEspecial, new GBConstraints(6, 0, 1, 1).setInsets(2, 2, 2, 2).setFill(GBConstraints.Fill.Both));
      tfLimite = new JTextField(30);
      tfLimite.setEditable(false);
      add(tfLimite, new GBConstraints(6, 1, 1, 1).setInsets(2, 2, 2, 2).setFill(GBConstraints.Fill.Both));
      bEspecial.addItemListener(this);
      
      bPoupanca = new JRadioButton("Conta poupança");
      grupo.add(bPoupanca);
      add(bPoupanca, new GBConstraints(7, 0, 1, 1).setInsets(2, 2, 2, 2).setFill(GBConstraints.Fill.Both));
      tfTaxa = new JTextField(30);
      tfTaxa.setEditable(false);
      add(tfTaxa, new GBConstraints(7, 1, 1, 1).setInsets(2, 2, 2, 2).setFill(GBConstraints.Fill.Both));
      bPoupanca.addItemListener(this);
      
      Box box = new Box(BoxLayout.LINE_AXIS);
      add(box, new GBConstraints(8, 0, 2, 1).setInsets(4, 4, 4, 4).setFill(GBConstraints.Fill.Horizontal));

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
         int numero = -1;
         int cpf = -1;
         double limite = -1;
         double taxa = -1;
         try { numero = Integer.parseInt(tfNumero.getText()); }
         catch (NumberFormatException exception) { }
         try { cpf = Integer.parseInt(tfCpf.getText()); }
         catch (NumberFormatException exception) { }
         try { limite = Double.parseDouble(tfLimite.getText()); }
         catch (NumberFormatException exception) { }
         try { taxa = Double.parseDouble(tfTaxa.getText()); }
         catch (NumberFormatException exception) { }
         String senha = tfSenha.getText().trim();   
         if (numero <= 0)
            JOptionPane.showMessageDialog(this, "Número inválido", "Erro", JOptionPane.ERROR_MESSAGE);
         else if (cpf <= 0)
            JOptionPane.showMessageDialog(this, "CPF inválido", "Erro", JOptionPane.ERROR_MESSAGE);
         else if (banco.encontraCliente(cpf) == null)
            JOptionPane.showMessageDialog(this, "CPF não cadastrado", "Erro", JOptionPane.ERROR_MESSAGE);
         else if (senha.isEmpty())
            JOptionPane.showMessageDialog(this, "Senha inválida", "Erro", JOptionPane.ERROR_MESSAGE);
         else if (grupo.getSelection() == bEspecial && limite < 0)
            JOptionPane.showMessageDialog(this, "Limite inválido", "Erro", JOptionPane.ERROR_MESSAGE);
         else if (grupo.getSelection() == bPoupanca && taxa < 0)
            JOptionPane.showMessageDialog(this, "Taxa inválida", "Erro", JOptionPane.ERROR_MESSAGE);
         else
         {
            int pos;
            for (pos = 0; pos < contas.size(); pos++)
            {
               int numero_conta = contas.get(pos).getNumero();
               if (numero == numero_conta)
               {
                  JOptionPane.showMessageDialog(this, "Este número " + numero + " já está em uso", "Erro", JOptionPane.ERROR_MESSAGE);
                  pos = -1;
                  break;
               }
               else if (numero < numero_conta)
                  break;
            }
            if (pos >= 0)
            {
               Conta conta;
               if (grupo.getSelection() == bEspecial.getModel())
                  conta = new ContaEspecial(numero, cpf, senha, limite);
               else if (grupo.getSelection() == bPoupanca.getModel())
                  conta = new ContaPoupanca(numero, cpf, senha, taxa);
               else
                  conta = new Conta(numero, cpf, senha);
               model.addRow(conta, pos);
            }
        }
      }
      else if (e.getSource() == bAlterar)
         JOptionPane.showMessageDialog(this, "Não implementado", "Aviso", JOptionPane.INFORMATION_MESSAGE);
      else if (e.getSource() == bFechar)
      {
         dispose();
      }
   }
   
   @Override
   public void itemStateChanged(ItemEvent e)
   {
      if (e.getStateChange() == ItemEvent.SELECTED)
      {
         tfLimite.setEditable(false);
         tfTaxa.setEditable(false);
         if (e.getSource() == bEspecial)
            tfLimite.setEditable(true);
         if (e.getSource() == bPoupanca)
            tfTaxa.setEditable(true);
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
            Conta conta = contas.get(index);
            tfNumero.setText("" + conta.getNumero());
            tfCpf.setText("" + conta.getCpf());
            bSimples.setSelected(true);
            tfLimite.setText("");
            tfTaxa.setText("");
            if (conta instanceof ContaEspecial)
            {
               bEspecial.setSelected(true);
               tfLimite.setText("" + ((ContaEspecial)conta).getLimite());
            }
            if (conta instanceof ContaPoupanca)
            {
               bPoupanca.setSelected(true);
               tfTaxa.setText("" + ((ContaPoupanca)conta).getTaxa());
            }
         }
         else
         {
            tfNumero.setText("");
            tfCpf.setText("");
            tfLimite.setText("");
            tfTaxa.setText("");
            bSimples.setSelected(true);
         }
      }  
   }
}

class ContasModel extends AbstractTableModel
{
   private List<Conta> contas;
   
   public ContasModel(List<Conta> contas)
   {
      this.contas = contas;
   }

   @Override
   public int getRowCount()
   {
      return contas.size();
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
         case 0: return "Número";
         case 1: return "CPF Titular";
         case 2: return "Tipo";
      }
      return null;
   }
   
   @Override
   public Object getValueAt(int rowIndex, int columnIndex)
   {
      switch (columnIndex)
      {
         case 0: return contas.get(rowIndex).getNumero();
         case 1: return contas.get(rowIndex).getCpf();
         case 2: if (contas.get(rowIndex) instanceof ContaEspecial)
                    return "especial";
                 if (contas.get(rowIndex) instanceof ContaPoupanca)
                    return "poupança";
                 else
                    return "simples";
      }
      return null;
   }
   
   public void addRow(Conta value, int row)
   {
      contas.add(row, value);
      fireTableRowsInserted(row, row);
   }                             
   
   public void updateRow(int numero, int cpf, String senha, int row)
   {
      Conta c = contas.get(row);
      c.setNumero(numero);
      c.setCpf(cpf);
      c.setSenha(senha);
      fireTableRowsUpdated(row, row);
   }                             
   
   public void removeRow(int row)
   {
      contas.remove(row);
      fireTableRowsDeleted(row, row);
   }                    
}
