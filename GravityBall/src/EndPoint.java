import processing.core.PApplet;
/**
 * 
 * @author jensen
 *
 */
public class EndPoint {
	private int x, y;
	public final int RADIUS = 20;
	public EndPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}
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

