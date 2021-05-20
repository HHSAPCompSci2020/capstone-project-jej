import java.awt.event.KeyEvent;
import java.awt.Point;

public class Game extends Screen {
	private DrawingSurface surface;
	private Level level;
	private Player player;
	private final double GRAVSTR = 0.1; //gravity strength
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
		surface.text("press space to exit, p to pause", 100, 100);
		surface.popStyle();
		
		
		player.act(level.getObstacles());
		
		if(g == Gravity.LEFT) {
			player.accelerate(-GRAVSTR, 0);
		}
		else if(g == Gravity.RIGHT) {
			player.accelerate(GRAVSTR, 0);
		}
		else if(g == Gravity.DOWN) {
			player.accelerate(0, GRAVSTR);
		}
		else if(g == Gravity.UP) {
			player.accelerate(0, -GRAVSTR);
		}
		
		player.draw(surface);
		Line test = new Line(player.getX(), player.getY(), player.getX() + player.getXVel(), 
				player.getY() + player.getYVel());
		test.draw(surface);
		level.draw(surface);
		

		if (surface.isPressed(KeyEvent.VK_SPACE)) {
			surface.switchScreen(ScreenSwitcher.MENU);
		}
		if(surface.isPressed(KeyEvent.VK_P))
		{
			surface.switchScreen(ScreenSwitcher.PAUSE);
		}
		if(surface.isPressed(KeyEvent.VK_UP)) {
			g = Gravity.UP;
			player.setVelRectangular(0, -GRAVSTR);
		}
		if(surface.isPressed(KeyEvent.VK_DOWN)) {
			g = Gravity.DOWN;
			player.setVelRectangular(0, GRAVSTR);
		}
		if(surface.isPressed(KeyEvent.VK_LEFT)) {
			g = Gravity.LEFT;
			player.setVelRectangular(-GRAVSTR, 0);
		}
		if(surface.isPressed(KeyEvent.VK_RIGHT)) {
			g = Gravity.RIGHT;
			player.setVelRectangular(GRAVSTR, 0);
		}
	}
	
	public Gravity getGravity() {
		return g;
	}
}
