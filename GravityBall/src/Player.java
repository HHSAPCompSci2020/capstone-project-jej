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
	public static double RADIUS = 10;
	
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
	
	public double getVelMagnitude() {
		return Math.sqrt(xVel * xVel + yVel * yVel);
	}
	
	public void accelerate (double ax, double ay) {
		xVel += ax;
		yVel += ay;
	}
	
	
	public void act(ArrayList<Obstacle> obstacles) {
		boolean check = true;
		String id = "";
		double minAngle = 0;
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
					minAngle = angle;
					id = i + "," + j;
					check = false;
				}
			}
		}
		
		
		if(check) {
			xPos += xVel;
			yPos += yVel;
		} else {
			xPos += minLength * Math.cos(minAngle);
			yPos += minLength * Math.sin(minAngle);
			double velMag = getVelMagnitude();
			
			double lineAngle = obstacles.get(Integer.parseInt(id.split(",")[0])).getHitbox().get(Integer.parseInt(id.split(",")[1])).getAngle();
			
			double newAngle = lineAngle - (minAngle - lineAngle);
			
			xVel = velMag * Math.cos(newAngle);
			yVel = velMag * Math.sin(newAngle);
		}
	}
	
	public void draw(PApplet surface) {
		surface.fill(150);
		surface.circle((float)xPos, (float)yPos, (float)RADIUS * 2);
	}
}
