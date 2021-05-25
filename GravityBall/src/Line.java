import java.awt.Color;

import processing.core.PApplet;

/**
 * The Line class represents a line that can be drawn onto a window.
 * @author Edward Min
 */
public class Line {
	private double x1, y1; // Coordinates of first point
	private double x2, y2; // Coordinates of second point
	
	public static final double MARGIN_OF_ERROR = 0.00000000000001;
	
	// Constructs a line from (x1, y1) to (x2, y2)
	/**
	 * Initializes a Line from point (x1,y1) to (x2,y2).
	 * @param x1 x coordinate of the first point
	 * @param y1 y coordinate of the first point
	 * @param x2 x coordinate of the second point
	 * @param y2 y coordinate of the second point
	 */
	public Line(double x1, double y1, double x2, double y2) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}
	
	public void setPoint1(double x1, double y1) {
		this.x1 = x1;
		this.y1 = y1;
	}
	
	// Sets this line's second point (x2, y2) to a new coordinate
	/**
	 * Sets the second point of this Line to (x2,y2).
	 * @param x2 x coordinate of the new point
	 * @param y2 y coordinate of the new point
	 */
	public void setPoint2(double x2, double y2) {
		this.x2 = x2;
		this.x2 = y2;
	}
	
	// Draws this line using the PApplet passed as an argument
	
	/**
	 * Sets up the colors/line widths, then draws this Line using marker.
	 * @param marker PApplet used to draw this Line
	 * @post marker now has a Line drawn onto it
	 */
	public void draw(PApplet marker) {
		marker.push();
		
		float x1 = (float)this.x1;
		float y1 = (float)this.y1;
		float x2 = (float)this.x2;
		float y2 = (float)this.y2;
		
		marker.line(x1, y1, x2, y2);
		
		marker.pop();
	}
	
	// Returns the x coordinate of the intersection point (assuming the lines continue forever)
	// Note: Changed output to String in order to give "UNDEFINED" values.
	/**
	 * Calculates the intersection point of this Line and the Line other. If they do not intersect, it 
	 * returns "UNDEFINED." If they do, this method returns the point's x coordinate in String format.
	 * @param other Another Line object
	 * @return The x coordinate of their intersection in String format or "UNDEFINED" if they do not intersect
	 */
	public String getIntersectionX(Line other) {
		
		double changeX1 = x1 - x2;
		double changeY1 = y1 - y2;
		
		double changeX2 = other.getX1() - other.getX2();
		double changeY2 = other.getY1() - other.getY2();
		
		// Accounting for divide by 0
		if(Math.abs(changeX1) <= MARGIN_OF_ERROR && Math.abs(changeX2) <= MARGIN_OF_ERROR) { 
			return "UNDEFINED";
		}
		
		if(Math.abs(changeX1) <= MARGIN_OF_ERROR) {
			return x1 + "";
		} else if(Math.abs(changeX2) <= MARGIN_OF_ERROR) {
			return other.getX1() + "";
		}
		
		double slope1 = changeY1/changeX1;
		double slope2 = changeY2/changeX2;
		
		if(Math.abs(slope1 - slope2) <= MARGIN_OF_ERROR) { // If parallel, accounting for the double error
			return "UNDEFINED";
		}
		
		double yIntercept1 = y1 - slope1 * x1;
		double yIntercept2 = other.getY1() - slope2 * other.getX1();
		
		// Solves for x given two lines in terms of y = mx + b (y = slope * x + yIntercept)
		double x = (yIntercept2 - yIntercept1) / (slope1 - slope2);
		return x + "";
	}
	
	// Returns the y coordinate of the intersection point (assuming the lines continue forever)
	/**
	 * Calculates the intersection point of this Line and the Line other. If they do not intersect, it 
	 * returns "UNDEFINED." If they do, this method returns the point's y coordinate in String format.
	 * @param other Another Line object
	 * @return The y coordinate of their intersection in String format or "UNDEFINED" if they do not intersect
	 */
	public String getIntersectionY(Line other) {
		String xString = getIntersectionX(other);
		if(xString.equals("UNDEFINED")) {
			return "UNDEFINED";
		}
		// Solves for x given two lines in terms of y = mx + b (y = slope * x + yIntercept)
		double x = Double.parseDouble(xString);

		double slope, yIntercept;
		if(Math.abs(x1 - x2) <= MARGIN_OF_ERROR) {
			slope = (other.getY1() - other.getY2())/(other.getX1() - other.getX2());
			yIntercept = other.getY1() - slope * other.getX1();
		} else {
			slope = (y1 - y2)/(x1 - x2);
			yIntercept = y1 - slope * x1;
		}
		
		double y = slope * x + yIntercept;
		return y + "";
	}
	
	// Returns true if this line segment and the other segment intersect each other
	/**
	 * Determines whether or not this Line and the Line other intersect.
	 * @param other Another Line object
	 * @return Returns a boolean if this Line and the Line other intersect
	 */
	public boolean intersects(Line other) {
		if(!this.getIntersectionX(other).equals("UNDEFINED") && 
				!this.getIntersectionY(other).equals("UNDEFINED")) {
			double x = Double.parseDouble(this.getIntersectionX(other));
			double y = Double.parseDouble(this.getIntersectionY(other));
			
			
			boolean thisLine = onTheLine(x, y);
			boolean otherLine = other.onTheLine(x, y);
			return thisLine && otherLine;
		}
		return false;
	}
	
	/**
	 * Determines whether a point is on this Line
	 * @param x x coordinate of the point
	 * @param y y coordinate of the point
	 * @return If the point (x,y) is on this Line
	 */
	public boolean onTheLine(double x, double y) {
		boolean xCheck = false;
		boolean yCheck = false;
		
		if(x1 > x2) {
			if(x - x2 >= -1 * MARGIN_OF_ERROR && x - x1 <= MARGIN_OF_ERROR) {
				xCheck = true;
			}
		} else {
			if(x - x1 >= -1 * MARGIN_OF_ERROR && x - x2 <= MARGIN_OF_ERROR) {
				xCheck = true;
			}
		}
		
		if(y1 > y2) {
			if(y - y2 >= -1 * MARGIN_OF_ERROR && y - y1 <= MARGIN_OF_ERROR) {
				yCheck = true;
			}
		} else {
			if(y - y1 >= -1 * MARGIN_OF_ERROR && y - y2 <= MARGIN_OF_ERROR) {
				yCheck = true;
			}
		}
		
		return xCheck && yCheck;
	}
	
	/**
	 * Returns the x coordinate of the first point.
	 * @return x1
	 */
	public double getX1() {
		return x1;
	}
	
	/**
	 * Returns the y coordinate of the first point.
	 * @return y1
	 */
	public double getY1() {
		return y1;
	}
	
	/**
	 * Returns the x coordinate of the second point.
	 * @return x2
	 */
	public double getX2() {
		return x2;
	}
	
	/**
	 * Returns the y coordinate of the second point
	 * @return y2
	 */
	public double getY2() {
		return y2;
	}

	/**
	 * Returns the length of the Line.
	 * @return Length of this Line
	 */
	public double getLength() {
		double changeX = x1 - x2;
		double changeY = x2 - y2;
		double pythagoras = changeX * changeX + changeY * changeY;
		return Math.sqrt(pythagoras);
	}
	
	/**
	 * Returns the angle of the Line on the interval -pi/2 to pi/2
	 * @return Angle of tilt of this Line
	 */
	public double getAngle() {
		if(x1 - x2 == 0) {
			return Math.PI/2;
		}
		return Math.atan((y1 - y2)/(x1 - x2));
	}
	
	/**
	 * Translates this Line by x units to the right and y units downwards.
	 * @param x Amount of units shifted to the right
	 * @param y Amount of units shifted downwards
	 */
	public void translate(double x, double y) {
		x1 += x;
		y1 += y;
		x2 += x;
		y2 += y;
	}
}
