import processing.core.PApplet;
import java.awt.Point;
/**
 * Wall class, can also be platform
 * @author jensen
 *
 */
public class Wall extends Obstacle {
	private int width, height;
	private int cx, cy; //center x and center y
	private double angle; //angle in radians
	public Wall(int x, int y, int width, int height, double angle) {
		super(x, y);
		this.width = width;
		this.height = height;
		this.angle = angle;
		this.cx = (int)(getX() + width/2);
		this.cy = (int)(getY() + height/2);
		
		Point topleft = calculatePoint(x, y, angle);
		Point topright = calculatePoint(x + width, y, angle);
		Point bottomleft = calculatePoint(x, y + height, angle);
		Point bottomright = calculatePoint(x + width, y + height, angle);
		
		hitbox.add(new Line(topleft.x, topleft.y, topright.x, topright.y));
		hitbox.add(new Line(topright.x, topright.y, bottomright.x, bottomright.y));
		hitbox.add(new Line(bottomright.x, bottomright.y, bottomleft.x, bottomleft.y));
		hitbox.add(new Line(bottomleft.x, bottomleft.y, topleft.x, topleft.y));
		
	}
	/**
	 * Calculates a point of the rectangle
	 * @param x
	 * @param y
	 * @param angle
	 * @author Aholio (StackOverflow)
	 */
	private Point calculatePoint(int x, int y, double theta) {
		// translate point to origin
		float tempX = x - cx;
		float tempY = y - cy;

		// now apply rotation
		float rotatedX = (float)(tempX*Math.cos(theta) - tempY*Math.sin(theta));
		float rotatedY = (float)(tempX*Math.sin(theta) + tempY*Math.cos(theta));

		// translate back
		x = (int)(rotatedX + cx);
		y = (int)(rotatedY + cy);
		return new Point(x, y);
	}
	
	public void draw(PApplet surface) {
		surface.fill(255);
		
		surface.pushMatrix();
		surface.translate(cx, cy);
		surface.rotate((float)angle);
		surface.rect(0-width/2, 0-height/2, width, height);
		surface.popMatrix();
		
		
		//testing purposes
		for(Line l: getHitbox()) {
			surface.push();
			surface.stroke(250, 0, 0);
			l.draw(surface);
			surface.pop();
		}
	}
}
