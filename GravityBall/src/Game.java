import java.awt.event.KeyEvent;
import java.awt.Point;

public class Game extends Screen {
	private DrawingSurface surface;
	private Level level;
	private Player player;
	private EndPoint end;
	private final double GRAVSTR = 0.1; //gravity strength
	private enum Gravity {
		UP, DOWN, LEFT, RIGHT;
	}
	Gravity g;
	
	public Game(DrawingSurface surface, int l) {
		super(800,600);
		this.surface = surface;
		level = new Level(l, surface);
		Point start = level.getStartPoint();
		player = new Player(start.x, start.y);
		g = Gravity.DOWN;
		end = level.getEnd();
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
		
		double px = player.getX();
		double py = player.getY();
		double ex = end.getX();
		double ey = end.getY();
		double distance = Math.sqrt((px-ex)*(px-ex) + (py-ey)*(py-ey));
		if(distance <= end.RADIUS*2) {
			surface.switchScreen(5);
		}
		
		
		player.accelerate(player.getXVel()*-0.015,player.getYVel()*-0.015);
		
		
		if(g == Gravity.LEFT) {
			player.accelerate(-GRAVSTR, 0);
			changeBackground(surface, 255, 255, 0);			
		}
		else if(g == Gravity.RIGHT) {
			player.accelerate(GRAVSTR, 0);
			changeBackground(surface, 0, 255, 0);
		}
		else if(g == Gravity.DOWN) {
			player.accelerate(0, GRAVSTR);
			changeBackground(surface, 0, 0, 255);
		}
		else if(g == Gravity.UP) {
			player.accelerate(0, -GRAVSTR);
			changeBackground(surface, 255, 0, 0);
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
	public void changeBackground(DrawingSurface surface, int r, int g, int b) {
		surface.push();
		surface.fill(r, g, b, 128);
		surface.rect(0, 0, 800, 600);
		surface.pop();
	}
	public Gravity getGravity() {
		return g;
	}
}
