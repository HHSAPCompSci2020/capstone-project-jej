import java.util.ArrayList;

import processing.core.PApplet;
/**
 * The Player can be represented as a circle with position and velocity vectors.
 * In Player's act method, collision detection is ran with an ArrayList of all
 * obstacles present in the current level, which is given by the Game class.
 * @author Edward
 *
 */
public class Player {
	private double xPos, yPos;
	private double initX, initY;
	private double xVel, yVel;
	public static double RADIUS = 20;
	
	/**
	 * Initializes a Player with all values (position, initial position, and velocity) being
	 * set to 0
	 */
	public Player() {
		xPos = 0;
		yPos = 0;
		initX = 0;
		initY = 0;
		xVel = 0;
		yVel = 0;
	}
	
	/**
	 * Initializes a Player with the starting position of (x, y) and velocities of 0
	 * @param x The x-coordinate of Player's position
	 * @param y The y-coordinate of Player's position
	 */
	public Player(double x, double y) {
		xPos = x;
		yPos = y;
		initX = x;
		initY = y;
		xVel = 0;
		yVel = 0;
	}
	
	/**
	 * Sets the Player's coordinates to (x, y)
	 * @param x The x-coordinate of Player's position
	 * @param y The y-coordinate of Player's position
	 */
	public void setCoords(double x, double y) {
		xPos = x;
		yPos = y;
	}
	
	/**
	 * Returns the x-coordinate of the Player
	 * @return The x-coordinate of the Player's position
	 */
	public double getX() {
		return xPos;
	}
	
	/**
	 * Returns the y-coordinate of the Player
	 * @return The y-coordinate of the Player's position
	 */
	public double getY() {
		return yPos;
	}
	
	/**
	 * Sets the initial coordinates of the Player
	 * @param x The x-coordinate of the initial position of the Player
	 * @param y The y-coordinate of the initial position of the Player
	 */
	public void setInitCoords(double x, double y) {
		initX = x;
		initY = y;
	}
	
	/**
	 * Returns the x-coordinate of the Player's initial position
	 * @return The x-coordinate of the Player's initial position
	 */
	public double getInitX() {
		return initX;
	}
	
	/**
	 * Returns the x-coordinate of the Player's initial position
	 * @return The x-coordinate of the Player's initial position
	 */
	public double getInitY() {
		return initY;
	}
	
	/**
	 * Sets the velocity vector of the Player to (xv, yv)
	 * @param xv The horizontal component of the velocity vector
	 * @param yv The vertical component of the velocity vector
	 */
	public void setVelRectangular(double xv, double yv) {
		xVel = xv;
		yVel = yv;
	}
	
	/**
	 * Sets the velocity vector of the Player to have a magnitude of v and an angle of theta
	 * @param v The magnitude of velocity
	 * @param theta The direction of velocity
	 */
	public void setVelPolar(double v, double theta) {
		setVelRectangular(v * Math.cos(theta), v * Math.sin(theta));
	}
	
	/**
	 * Returns the horizontal component of the Player's velocity
	 * @return The horizontal component of the Player's velocity
	 */
	public double getXVel() {
		return xVel;
	}
	
	/**
	 * Returns the vertical component of the Player's velocity
	 * @return The vertical component of the Player's velocity
	 */
	public double getYVel() {
		return yVel;
	}
	
	/**
	 * Returns the magnitude of the Player's velocity
	 * @return The magnitude of the Player's velocity
	 */
	public double getVelMagnitude() {
		return Math.sqrt(xVel * xVel + yVel * yVel);
	}
	
	/**
	 * Returns the direction of the Player's velocity
	 * @return The angle of the Player's velocity
	 */
	public double getVelAngle() {
		if(xVel == 0) {
			if(yVel >= 0) {
				return Math.PI/2;
			} else {
				return -Math.PI/2;
			}
		}
		double angle = Math.atan(yVel/xVel);
		if(xVel < 0) {
			angle += Math.PI;
		}
//		System.out.println(angle);
		return angle;
	}
	
	/**
	 * Accelerates the Player horizontally by ax and vertically by ay
	 * @param ax The horizontal acceleration of the Player
	 * @param ay The vertical acceleration of the Player
	 */
	public void accelerate (double ax, double ay) {
		xVel += ax;
		yVel += ay;
	}
	
	/**
	 * Checks for the collision of the obstacles given, then moves to its next position
	 * @param obstacles The ArrayList containing all the obstacles in a given level
	 */
	public void act(ArrayList<Obstacle> obstacles) {
		boolean check = true;
		String id = "";
		double minLength = Double.MAX_VALUE;
		for(int i = 0; i < obstacles.size(); i++) {
			for(int j = 0; j < obstacles.get(i).getHitbox().size(); j++) {
				Line l = obstacles.get(i).getHitbox().get(j);
				double angle = l.getAngle();
				Line tester = new Line(xPos + getVelMagnitude() * Math.cos(angle - Math.PI/2),
						yPos + getVelMagnitude() * Math.sin(angle - Math.PI/2), 
						xPos + getVelMagnitude() * Math.cos(angle + Math.PI/2),
						yPos + getVelMagnitude() * Math.sin(angle + Math.PI/2 ));
				String x = l.getIntersectionX(tester);
				String y = l.getIntersectionY(tester);
				if(x.equals("UNDEFINED") || y.equals("UNDEFINED")) {
					continue;
				}
				double dist1 = Math.sqrt(Math.pow(xPos + getVelMagnitude() * Math.cos(angle - Math.PI/2) - Double.parseDouble(x), 2)
						+ Math.pow(yPos + getVelMagnitude() * Math.sin(angle - Math.PI/2) - Double.parseDouble(y), 2));
				double dist2 = Math.sqrt(Math.pow(xPos + getVelMagnitude() * Math.cos(angle + Math.PI/2) - Double.parseDouble(x), 2)
						+ Math.pow(yPos + getVelMagnitude() * Math.sin(angle + Math.PI/2) - Double.parseDouble(y), 2));
				
				if(dist1 < dist2) {
					angle -= Math.PI/2;
				} else {
					angle += Math.PI/2;
				}
				
				double xStart = xPos + RADIUS * Math.cos(angle);
				double yStart = yPos + RADIUS * Math.sin(angle);
				Line model = new Line(xStart, yStart, xStart + xVel, yStart + yVel);
				
				if(l.intersects(model) == false) {
					continue;
				}
				double xInter = Double.parseDouble(l.getIntersectionX(model));
				double yInter = Double.parseDouble(l.getIntersectionY(model));
				double dist = Math.sqrt(Math.pow(xInter - xStart, 2) + Math.pow(yInter - yStart, 2));
				if(dist < minLength) {
					minLength = dist;
					id = i + "," + j;
					check = false;
				}
			}
		}
		
		
		if(check) {
			xPos += xVel;
			yPos += yVel;
			
			for(int i = 0; i < obstacles.size(); i++) {
				for(int j = 0; j < obstacles.get(i).getHitbox().size(); j++) {
					double x = obstacles.get(i).getHitbox().get(j).getX1();
					double y = obstacles.get(i).getHitbox().get(j).getY1();
					
					double dist = Math.sqrt(Math.pow(xPos - x, 2) + Math.pow(yPos - y, 2));
					if(dist < RADIUS) {
						if(obstacles.get(i).getID().equals("spike")) {
							death();
							continue;
						}
						Line connector = new Line(x, y, xPos, yPos);
						double newAngle = 2 * (connector.getAngle() + Math.PI/2) - getVelAngle();
						double velMag = getVelMagnitude();
						
						xPos -= xVel;
						yPos -= yVel;
						
						xVel = velMag * Math.cos(newAngle);
						yVel = velMag * Math.sin(newAngle);
					}
				}
			}
		} else {
			String obstacleID = obstacles.get(Integer.parseInt(id.split(",")[0])).getID();
			if(obstacleID.equals("wall")){
				xPos += minLength * Math.cos(getVelAngle());
				yPos += minLength * Math.sin(getVelAngle());
				double velMag = getVelMagnitude();
				
				double lineAngle = obstacles.get(Integer.parseInt(id.split(",")[0])).getHitbox().get(Integer.parseInt(id.split(",")[1])).getAngle();
			
				double newAngle = 2 * lineAngle - getVelAngle();
				//System.out.println(newAngle);
				
				xPos +=  Math.cos(newAngle);
				yPos +=  Math.sin(newAngle);
				xVel = velMag * Math.cos(newAngle);
				yVel = velMag * Math.sin(newAngle);
			} else if(obstacleID.equals("spike")) {
				death();
			}
		}
		
		for(int i = 0; i < obstacles.size(); i++) {
			if(obstacles.get(i).getID().equals("boost")) {
				if(obstacles.get(i).getX() < xPos && xPos < obstacles.get(i).getX() + obstacles.get(i).getWidth() &&
						obstacles.get(i).getY() < yPos && yPos < obstacles.get(i).getY() + obstacles.get(i).getHeight()) {
					this.accelerate(0.25 * Math.cos(getVelAngle()), 0.25 * Math.sin(getVelAngle()));
					break;
				}
			} else if(obstacles.get(i).getID().equals("slow")) {
				if(obstacles.get(i).getX() < xPos && xPos < obstacles.get(i).getX() + obstacles.get(i).getWidth() &&
						obstacles.get(i).getY() < yPos && yPos < obstacles.get(i).getY() + obstacles.get(i).getHeight()) {
					double xAcc = -0.075 * Math.cos(getVelAngle());
					double yAcc = -0.075 * Math.sin(getVelAngle());
					if(Math.abs(xVel) < Math.abs(xAcc)) {
						xAcc = -xVel;
					}
					if(Math.abs(yVel) < Math.abs(yAcc)) {
						yAcc = -yVel;
					}
					this.accelerate(xAcc, yAcc);
					
					break;
				}
			}
		}
	}
	
	/**
	 * Sets the position of the Player to the set initial position and velocity to 0
	 */
	public void death() {
		this.setCoords(initX, initY);
		this.setVelRectangular(0, 0);
	}
	
	/**
	 * Draws this Player on the given PApplet
	 * @param surface The PApplet to be drawn on
	 * @post This Player will be drawn onto the PApplet
	 */
	public void draw(PApplet surface) {
		surface.push();
		surface.fill(150);
		surface.circle((float)xPos, (float)yPos, (float)RADIUS * 2);
		surface.pop();
	}
}
