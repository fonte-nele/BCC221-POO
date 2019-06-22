import javax.swing.JFrame;

public class MouseTracker
{
	public static void main(String args[])
	{
		MouseTrackerFrame mouse = new MouseTrackerFrame();
		mouse.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mouse.setSize(700,400);
		mouse.setVisible(true);
	}
}
