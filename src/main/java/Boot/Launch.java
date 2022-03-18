package Boot;
import javax.swing.JFrame;


public class Launch
{
	public static void main(String[] args)
	{
		Portal portal = new Portal();
		portal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		portal.setSize(450,300);
		portal.setVisible(true);
		portal.setLocation(450,200);
                portal.setResizable(false);
                
	}
}