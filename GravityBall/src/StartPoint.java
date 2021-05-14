import java.awt.Point;
/**
 * 
 * @author jensen
 *
 */
public class StartPoint {
	private int x, y;
	private DrawingSurface surface;
	public StartPoint(int x, int y, DrawingSurface surface) {
		this.x = x;
		this.y = y;
		this.surface = surface;
	}
	public void draw() {
		surface.fill(0, 255, 0);
		surface.circle(x, y, 50);
	}
}
