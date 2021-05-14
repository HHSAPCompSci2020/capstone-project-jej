import java.awt.event.KeyEvent;
import java.awt.Point;

public class Game extends Screen {
	private DrawingSurface surface;
	private Level level;
	private Player player;
	public Game(DrawingSurface surface) {
		super(800,600);
		this.surface = surface;
		level = new Level(1, surface);
		Point start = level.getStartPoint();
		player = new Player(start.x, start.y);
	}
	
	public void draw() {
		surface.pushStyle();

		surface.background(255);   // Clear the screen with a white background
		surface.stroke(0);     // Set line drawing color to white
		surface.noFill();
		
		surface.fill(0);
		surface.text("press space to exit", 100, 100);
		surface.popStyle();
		
		player.draw(surface);
		level.draw(surface);
		

		if (surface.isPressed(KeyEvent.VK_SPACE)) {
			surface.switchScreen(ScreenSwitcher.MENU);
		}
	}
}
