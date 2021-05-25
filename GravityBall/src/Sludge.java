import processing.core.PApplet;

/**
 * The Sludge class is represented by a slightly transparent brown
 * rectangle, which decelerates the Player in the direction that
 * it is moving. This class intentionally doesn't have a hitbox,
 * as the interaction with the Player is calculated in its act
 * method. This class extends Obstacle.
 * Basis copied from Booster class.
 * @author Edward
 *
 */
public class Sludge extends Obstacle {
	private int cx, cy; //center x and center y
	
	public Sludge(int x, int y, int width, int height) {
		super(x, y);
		id = "slow";
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
		surface.fill(150, 75, 0, 150);
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
