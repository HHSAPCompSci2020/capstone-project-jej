import processing.core.PApplet;
import java.awt.Point;
/**
 * The Boost class is represented by a slightly transparent green
 * rectangle, which accelerates the Player in the direction that
 * it is moving. This class intentionally doesn't have a hitbox,
 * as the interaction with the Player is calculated in its act
 * method. This class extends Obstacle.
 * Basis copied from Wall class, created by Jensen.
 * @author Edward
 *
 */
public class Booster extends Obstacle {
	private int cx, cy; //center x and center y
	
	public Booster(int x, int y, int width, int height) {
		super(x, y);
		id = "boost";
		this.width = width;
		this.height = height;
		this.cx = (int)(getX() + width/2);
		this.cy = (int)(getY() + height/2);
	}
	
	/**
	 * Draws this Booster on the given PApplet
	 * @param surface The PApplet to be drawn on
	 * @post This Booster will be drawn onto the PApplet
	 */
	public void draw(PApplet surface) {
		surface.fill(255);
		
		surface.pushMatrix();
		surface.translate(cx, cy);
		surface.fill(0, 150, 0, 150);
		surface.stroke(0, 0);
		surface.rect((float)(0-width/2), (float)(0-height/2), (float)(width), (float)(height));
		surface.popMatrix();
		
		
		//testing purposes
		/*for(Line l: getHitbox()) {
			surface.push();
			surface.stroke(250, 0, 0);
			l.draw(surface);
			surface.pop();
		}*/
	}
}
