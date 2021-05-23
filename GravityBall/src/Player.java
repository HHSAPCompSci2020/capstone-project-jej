import java.util.ArrayList;

import processing.core.PApplet;
/**
 * The player
 * @author Eddie
 *
 */
public class Player {
	private double xPos, yPos;
	private double initX, initY;
	private double xVel, yVel;
	public static double RADIUS = 20;
	
	public Player() {
		xPos = 0;
		yPos = 0;
		initX = 0;
		initY = 0;
		xVel = 0;
		yVel = 0;
	}
	
	public Player(double x, double y) {
		xPos = x;
		yPos = y;
		initX = x;
		initY = y;
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
	
	public void setInitCoords(double x, double y) {
		initX = x;
		initY = y;
	}
	
	public double getInitX() {
		return initX;
	}
	
	public double getInitY() {
		return initY;
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
	
	public void accelerate (double ax, double ay) {
		xVel += ax;
		yVel += ay;
	}
	
	
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
	}
	
	public void death() {
		this.setCoords(initX, initY);
		this.setVelRectangular(0, 0);
	}
	
	public void draw(PApplet surface) {
		surface.fill(150);
		surface.circle((float)xPos, (float)yPos, (float)RADIUS * 2);
	}
}
