import java.awt.*;
import javax.swing.*;

public class Desenho extends JPanel
{
    
    public void paintComponent( Graphics g)
    {
    	//Circunferência
    	g.setColor(Color.WHITE);
        g.fillRect(0, 0, 700, 700);
        //g.setColor(Color.DARK_GRAY);
        //g.fillOval(150, 200, 200, 40);
        g.setColor(Color.RED);
        g.fillOval(100, 80, 150, 150);
        g.setColor(Color.PINK);
        g.fillOval(120, 105, 30, 30);
        g.setColor(Color.BLUE);
    
        //Linha
        g.setColor(Color.BLACK);
        g.drawLine(50,65,50,200);
        
        //Quadrado
        g.setColor(Color.GREEN);
        g.fillRect(300, 300, 150, 150);
        
        //Triangulo
        g.setColor(Color.MAGENTA);
        Polygon poligono = new Polygon();
        poligono.addPoint(315,50);
        poligono.addPoint(250, 200);
        poligono.addPoint(380, 200);
        g.fillPolygon(poligono);
        
    }
    
    public static void main(String[] args)
    {
        Desenho pane = new Desenho();
        JFrame application = new JFrame("Editor de desenhos geométricos");
        
        application.add(pane);
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.setSize(700,700);
        application.setVisible(true);
    }   
}