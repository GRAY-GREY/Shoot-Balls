/**
 *Author @Kurt Kelly
 *			-kurtbkelly@gmail.com
 *
 *Published May 12th, 2020
 */

public class Ball {

	private double x, y;
	private boolean xSwitched, ySwitched;
	
	
	/**Constructs a new Ball object
	 * 
	 * @param 'x' approximate x location Ball is painted
	 * 		  'y' approximate y location Ball is painted
	 */
	public Ball(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public void switchX() {
		xSwitched = !xSwitched;
	}
	
	public void switchY() {
		ySwitched = !ySwitched;
	}
	
	public boolean getXSwitched() {
		return xSwitched;
	}
	
	public boolean getYSwitched() {
		return ySwitched;
	}
	
}