import javax.swing.JFrame;

public class MouseDetails
{
	public static void main(String args[])
	{
		MouseDetailsFrame mouse = new MouseDetailsFrame();
		mouse.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mouse.setSize(400,150);
		mouse.setVisible(true);
	}
}
