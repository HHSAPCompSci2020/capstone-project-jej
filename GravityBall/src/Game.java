import java.awt.event.KeyEvent;
import java.awt.Point;

public class Game extends Screen {
	private DrawingSurface surface;
	private Level level;
	private Player player;
	private enum Gravity {
		UP, DOWN, LEFT, RIGHT;
	}
	Gravity g;
	
	public Game(DrawingSurface surface) {
		super(800,600);
		this.surface = surface;
		level = new Level(1, surface);
		Point start = level.getStartPoint();
		player = new Player(start.x, start.y);
		g = Gravity.DOWN;
	}
	
	public void draw() {
		surface.pushStyle();

		surface.background(255);   // Clear the screen with a white background
		surface.stroke(0);     // Set line drawing color to white
		surface.noFill();
		
		surface.fill(0);
		surface.text("press space to exit", 100, 100);
		surface.popStyle();
		
		player.act(level.getObstacles());
		player.draw(surface);
		level.draw(surface);
		

		if (surface.isPressed(KeyEvent.VK_SPACE)) {
			surface.switchScreen(ScreenSwitcher.MENU);
		}
		if(surface.isPressed(KeyEvent.VK_UP)) {
			g = Gravity.UP;
		}
		if(surface.isPressed(KeyEvent.VK_DOWN)) {
			g = Gravity.DOWN;
		}
		if(surface.isPressed(KeyEvent.VK_LEFT)) {
			g = Gravity.LEFT;
		}
		if(surface.isPressed(KeyEvent.VK_RIGHT)) {
			g = Gravity.RIGHT;
		}
	}
	
	public Gravity getGravity() {
		return g;
	}
}
