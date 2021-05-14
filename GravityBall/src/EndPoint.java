import processing.core.PApplet;
/**
 * 
 * @author jensen
 *
 */
public class EndPoint {
	private int x, y;
	public EndPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public void draw(PApplet surface) {
		surface.fill(255, 0, 0);
		surface.circle(x, y, 50);
	}
}

