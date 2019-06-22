import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*; 

public class teste2 extends JFrame { 
    
    private JButton buttons[] = new JButton[9];//Define um array para referenciar 9 botões 
    private JMenu menu; 
    private JMenuBar menuBar; 
    private JMenuItem menuSair; 
    private JMenuItem menuIniciar; 

    /* Construtor Genius */ 
    public teste2() { 
        initComponents(); 
        setSize(300,300);//Seta o tamanho do formulário 
    } 
    
    /* Inicializa o formulário e todos os seus componentes*/ 
    private void initComponents() { 
       for( int i=0; i<9; i++ ){ 
            buttons[i] = new JButton("");//Cria os botões e coloca a referência no array 
       getContentPane().add(buttons[i]);//Adiciona os botões ao formulário 
       buttons[i].setBackground(Color.WHITE); 
        } 
        
        menuBar = new JMenuBar(); 
        menu = new JMenu(); 
        menuSair = new JMenuItem(); 
        menuIniciar = new JMenuItem(); 

        getContentPane().setLayout(new java.awt.GridLayout(3, 3));//Layout para acomodar os botões na forma # 
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE); 

        /*Define um evento de pressionamento de botão para o botão 0*/ 
        buttons[0].addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent evt) { 
                piscaBotao(0); 
            } 
        }); 

        menu.setText("Jogo"); 
        menuSair.setText("Sair"); 
        menuSair.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent evt) { 
                System.exit(0); 
            } 
        }); 

        menuIniciar.setText("Iniciar"); 
        menuIniciar.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent evt) { 
               /*Efetua um teste em todos os botoes*/ 
                for( int i=0; i<9; i++){ 
                    piscaBotao(i); 
                } 
            } 
        }); 

        menu.add(menuIniciar); 
        menu.add(menuSair); 
        menuBar.add(menu); 
        setJMenuBar(menuBar); 
    } 
    private void piscaBotao(int index){ 
       buttons[index].setBackground(Color.YELLOW); 
        try{ 
            update(getGraphics());//Atualiza o formulário 
            Thread.sleep(200);//INterrompe a rotina em 0,5 segundos 
        }catch(InterruptedException e){ 
            System.err.println(e.getMessage()); 
        } 
        buttons[index].setBackground(Color.WHITE); 
    } 
    public static void main(String args[]) { 
        JFrame.setDefaultLookAndFeelDecorated(true);//Frescura :) 
        new teste2().setVisible(true);//Cria o objeto Genius e o torna visível 
    } 
}