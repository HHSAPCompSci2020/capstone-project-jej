import processing.core.PApplet;
/**
 * Drawn as a red circle, with 20 radius
 * When a player touches the EndPoint, the level ends
 * @author jensen
 *
 */
public class EndPoint {
	private int x, y;
	public static final int RADIUS = 20;
	public EndPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}
	/**
	 * Draws this EndPoint on the given PApplet
	 * @param surface The PApplet to be drawn on
	 * @post This EndPoint will be drawn onto the PApplet
	 */
	public void draw(PApplet surface) {
		surface.fill(255, 0, 0);
		surface.circle(x, y, RADIUS*2);
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
}

