import processing.core.PApplet;
/**
 * Wall class, can also be platform
 * @author jensen
 *
 */
public class Wall extends Obstacle {
	private int width, height;
	private float angle; //angle in radians
	public Wall(int x, int y, int width, int height, float angle) {
		super(x, y);
		this.width = width;
		this.height = height;
		this.angle = angle;
	}
	
	public void draw(PApplet surface) {
		surface.fill(255);
		surface.rotate(angle);
		surface.rect((int)getX(), (int)getY(), width, height);
		surface.rotate(0); //reset angle back to 0
	}
}
