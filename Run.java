import java.awt.Color;
import javax.swing.JFrame;

public class Run {

	//only change these three variables
	final static int NUM_OF_BALLS = 50;
	final static double ANGLE = 20; //0 - 180 for degrees, but won't fail on run time with any rational number
	final static boolean RAINBOW_MODE = true;
	
	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame("JFrame");
		frame.setSize(672, 896); //final size
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new PaintingBalls(NUM_OF_BALLS, ANGLE, RAINBOW_MODE));
		
		if(RAINBOW_MODE)
			frame.setBackground(new Color(40, 35, 35));
		else
			frame.setBackground(new Color(65, 65, 105));
		
		frame.setVisible(true);
		
		while(true) {
			frame.repaint();
			Thread.sleep(30);
		}	
	}
	
}