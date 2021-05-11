import processing.core.PApplet;
/**
 * The player
 * 
 *
 */
public class Player {
	private double xPos, yPos;
	private double xVel, yVel;
	
	public Player() {
		xPos = 0;
		yPos = 0;
		xVel = 0;
		yVel = 0;
	}
	
	public Player(double x, double y) {
		xPos = x;
		yPos = y;
		xVel = 0;
		yVel = 0;
	}
	
	public void setCoords(double x, double y) {
		xPos = x;
		yPos = y;
	}
	
	public double getX() {
		return xPos;
	}
	
	public double getY() {
		return yPos;
	}
	
	public void setVelRectangular(double xv, double yv) {
		xVel = xv;
		yVel = yv;
	}
	
	public void setVelPolar(double v, double theta) {
		setVelRectangular(v * Math.cos(theta), v * Math.sin(theta));
	}
	
	public void accelerate (double ax, double ay) {
		xVel += ax;
		yVel += ay;
	}
}
