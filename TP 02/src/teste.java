import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import java.util.Random;

public class teste extends JFrame
{
    private JButton button;
    private Timer timer;
    private int delay = 300; // a cada 0,3 segundos
    private static final long serialVersionUID = 1L;
    Random rand = new Random();

    public teste()
    {
        super("Teste");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        button = new JButton("O meu botão");
        JPanel contentPane = (JPanel) getContentPane();
        contentPane.add(button, BorderLayout.CENTER);
        contentPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        pack();

        ActionListener action = new ActionListener()
        {   
            @Override
            public void actionPerformed(ActionEvent event)
            {
                    float r = rand.nextFloat();
                    float g = rand.nextFloat();
                    float b = rand.nextFloat();

                    button.setBackground(new Color(r, g, b));
            }
        };

        timer = new Timer(delay, action);
        timer.setInitialDelay(0);
        timer.start();

        setVisible(true);
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                new teste();
            }
        });
    }
}