/**
 *Author @Kurt Kelly
 *			-kurtbkelly@gmail.com
 *
 *Published May 12th, 2020
 */

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class PaintingBalls extends JPanel {

	private final int[] Y_BOUNDS = {148, 748};
	private final int[] X_BOUNDS = {111, 561};
	private int numOfBalls;
	private double angle;
	private boolean rainbowMode;
	private ArrayList<Ball> balls;
	private ArrayList<Integer[]> colors; //rainbow mode only
	
	
	/**Constructor passes the values of the final variables from the Run Class to the PaintingBalls Object 
	 * 
	 * @param 'numOfBalls' number of balls painted on screen
	 * 		  'angle' angle the balls will be shot at (0 is left with no change in y, 180 is right with no change in y)
	 * 		  'rainbowMode' adds rainbow effect to original program by changing colors only
	 */
	public PaintingBalls(int numOfBalls, double angle, boolean rainbowMode) {
		super();
		this.numOfBalls = numOfBalls;
		this.angle = angle;
		this.rainbowMode = rainbowMode;
		balls = new ArrayList<Ball>();
		if(rainbowMode)
			colors = new ArrayList<Integer[]>();
	}
	
	public void paintComponent(Graphics g) {
		if(rainbowMode) {
			g.setColor(new Color(125, 115, 125));
			g.fillRect(109, 146, 454, 604);
			g.setColor(new Color(17, 15, 15));
			g.fillRect(X_BOUNDS[0], Y_BOUNDS[0], X_BOUNDS[1]-X_BOUNDS[0], Y_BOUNDS[1]-Y_BOUNDS[0]);
		} else {
			g.setColor(new Color(180, 180, 50));
			g.fillRect(109, 146, 454, 604);
			g.setColor(new Color(50, 50, 85));
			g.fillRect(X_BOUNDS[0], Y_BOUNDS[0], X_BOUNDS[1]-X_BOUNDS[0], Y_BOUNDS[1]-Y_BOUNDS[0]);
		}
		
		//initial algorithm to get the balls out at the right angle and at the right position relative to time
		if(balls.size() < numOfBalls)
			if((balls.size() == 0) || ((Math.abs(((X_BOUNDS[1]+X_BOUNDS[0])/2) - balls.get(balls.size()-1).getX()) > 20) || (Math.abs(Y_BOUNDS[1] - balls.get(balls.size()-1).getY()) > 20))) {  //make the '20's a lower number if you want the balls to come out faster, make them a bigger number if you want more delay  
				if(rainbowMode)
					colors.add(new Integer[]{255, 0, 0, 0});
				balls.add(new Ball((double) (X_BOUNDS[1]+X_BOUNDS[0])/2, (double) (Y_BOUNDS[1]))); //change @params of the Ball Object to move the starting point of the balls
			}		
		
		/**Tracing algorithm
		 * 
		 * draws the balls
		 * assures the balls maintain their trajectory
		 * detects when balls hit any walls and reflects trajectory properly
		**/
		g.setColor(new Color(235, 235, 235));
		for(int i = 0; i < balls.size(); i++) {
			Ball ball = balls.get(i);
			if(rainbowMode) {
				g.setColor(new Color(colors.get(i)[0], colors.get(i)[1], colors.get(i)[2]));
				if(colors.get(i)[3]>=1530)
					colors.get(i)[3]=0;
				if((colors.get(i)[3]/255)%2==0)
					colors.get(i)[(2*(colors.get(i)[3]/255)+1)%3]+=5;
				else colors.get(i)[(colors.get(i)[3]/255)/2]-=5;
				colors.get(i)[3]+=5;
			}
			if(ball.getX() < X_BOUNDS[0] || ball.getX() > X_BOUNDS[1])
				ball.switchX();
			if(ball.getY() < Y_BOUNDS[0] || ball.getY() > Y_BOUNDS[1])
				ball.switchY();
			if(ball.getXSwitched())
				ball.setX(ball.getX() + (Math.cos((Math.PI)*(angle/180)))*5);
			else 
				ball.setX(ball.getX() - (Math.cos((Math.PI)*(angle/180)))*5);
			if(ball.getYSwitched())
				ball.setY(ball.getY() + (Math.sin((Math.PI)*(angle/180)))*5);
			else 
				ball.setY(ball.getY() - (Math.sin((Math.PI)*(angle/180)))*5);
			g.fillOval((int) (ball.getX()-5),(int) (ball.getY()-5), 10, 10); //change last two numbers of @params of 'fillOval' to make the balls bigger or smaller, or an oval if you want, ex. [..., 5, 20)]
		}
		
	}
		
}
