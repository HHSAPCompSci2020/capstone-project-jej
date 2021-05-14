import java.util.ArrayList;

import processing.core.PApplet;
/**
 * The player
 * @author Eddie
 *
 */
public class Player {
	private double xPos, yPos;
	private double xVel, yVel;
	public static double RADIUS = 50;
	
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
	
	public double getXVel() {
		return xVel;
	}
	
	public double getYVel() {
		return yVel;
	}
	
	public void accelerate (double ax, double ay) {
		xVel += ax;
		yVel += ay;
	}
	
	
	public void act(ArrayList<Obstacle> obstacles) {
		
		
		xPos += xVel;
		yPos += yVel;
	}
	
	public void draw(PApplet surface) {
		surface.fill(150);
		surface.circle((float)xPos, (float)yPos, (float)RADIUS);
	}
}
