import processing.core.PApplet;
import java.awt.Point;
/**
 * The Spike class is an obstacle which kills a Player when it's hitbox intercepts with the 
 * Player's hitbox.
 * Basis copied from Wall class, created by Jensen.
 * @author Edward
 *
 */
public class Spike extends Obstacle {
	private int numOfSpikes;
	private int cx, cy; //center x and center y
	private double angle; //angle in radians
	
	public static final int SPIKE_HEIGHT = 10;
	public static final int SPIKE_WIDTH = 10;
	public Spike(int x, int y, int n, double angle) {
		super(x, y);
		id = "spike";
		this.numOfSpikes = n;
		this.angle = angle;
		int width = SPIKE_WIDTH * numOfSpikes;
		int height = SPIKE_HEIGHT;
		this.cx = (int)(getX() + width/2.0);
		this.cy = (int)(getY() + height/2.0);
		
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
		surface.fill(150);
		int width = SPIKE_WIDTH * numOfSpikes;
		for(int i = 0; i < numOfSpikes; i++) {
			surface.triangle(i * SPIKE_WIDTH - width/2, -SPIKE_HEIGHT/2, 
					(float)((i + 0.5) * SPIKE_WIDTH - width/2), SPIKE_HEIGHT/2, 
					(i + 1) * SPIKE_WIDTH - width/2, -SPIKE_HEIGHT/2);
		}
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
