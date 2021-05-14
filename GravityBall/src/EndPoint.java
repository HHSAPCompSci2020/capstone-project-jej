import java.awt.Point;
/**
 * 
 * @author jensen
 *
 */
public class EndPoint {
	private int x, y;
	private DrawingSurface surface;
	public EndPoint(int x, int y, DrawingSurface surface) {
		this.x = x;
		this.y = y;
		this.surface = surface;
	}
	public void draw() {
		surface.fill(255, 0, 0);
		surface.circle(x, y, 50);
	}
}

