import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
/**
 * The Game class, extends Screen
 * The Game class contains all of the components needed for the game.
 * The Game class creates a new level every time the previous level is complete.
 * @author Jensen
 *
 */
public class Game extends Screen {
	private DrawingSurface surface;
	private Level level;
	private static final int MAX_LEVEL = 7;
	private int levelNumber;
	private Player player;
	private Rectangle pause;
	private EndPoint end;
	private final double GRAVSTR = 0.1; //gravity strength
	private enum Gravity {
		UP, DOWN, LEFT, RIGHT;
	}
	Gravity g;
	/**
	 * Constructor of the game, should only be called 1 time on run
	 * @param surface Surface to draw the game on
	 * @param l Level number to create (levels are static)
	 */
	public Game(DrawingSurface surface, int l) {
		super(800,600);
		this.surface = surface;
		level = new Level(l, surface);
		levelNumber = l;
		Point start = level.getStartPoint();
		player = new Player(start.x, start.y);
		g = Gravity.DOWN;
		end = level.getEnd();
		pause = new Rectangle(5,15,100,25);
	}
	/**
	 * All the logic for the game is executed and drawn when this method is called
	 */
	public void draw() {
		surface.pushStyle();

		surface.background(255);   // Clear the screen with a white background
		surface.stroke(0);     // Set line drawing color to white
		surface.noFill();
		
		surface.fill(0);
		surface.text("press space to exit, p to pause", 150, 25);
		surface.popStyle();
		
		surface.fill(255);
		surface.rect(pause.x, pause.y, pause.width, pause.height, 10, 10, 10, 10);
		surface.fill(0);
		String str = "Pause";
		float w = surface.textWidth(str);
		surface.text(str, pause.x+pause.width/2-w/2, pause.y+pause.height/2);
		
		player.act(level.getObstacles());
		
		double px = player.getX();
		double py = player.getY();
		double ex = end.getX();
		double ey = end.getY();
		double distance = Math.sqrt((px-ex)*(px-ex) + (py-ey)*(py-ey));
		
		
		if(distance <= end.RADIUS*2) {
//			surface.switchScreen(ScreenSwitcher.ENDSCREEN);
//			surface.switchScreen(5);
			if(levelNumber == MAX_LEVEL) {
				surface.switchScreen(ScreenSwitcher.ENDSCREEN);
				surface.switchScreen(5);
			} else {
				level = new Level(++levelNumber, surface);
				end = level.getEnd();
				player = new Player(level.getStartPoint().x, level.getStartPoint().y);
			}
		}
		
		
		player.accelerate(player.getXVel()*-0.015,player.getYVel()*-0.015);
		
		
		int netX = 0;
		int netY = 0;
		
		ArrayList<Integer> keys = surface.getKeys();
		
		if(keys.contains(37)) {
			netX--;
		}
		if(keys.contains(38)) {
			netY--;
		}
		if(keys.contains(39)) {
			netX++;
		}
		if(keys.contains(40)) {
			netY++;
		}
		
		Color bg = new Color(0);
		int dir = -2;
		if(Math.abs(netX) + Math.abs(netY) == 2) {
			player.accelerate(GRAVSTR * netX * Math.sqrt(0.5), GRAVSTR * netY * Math.sqrt(0.5));
			if(netX == -1 && netY == -1) { // Up left
				bg = new Color(255, 127, 0);
				dir = 7;
			} else if(netX == 1 && netY == -1) { // Up right
				bg = new Color(127, 127, 0);
				dir = 1;
			} else if(netX == 1 && netY == 1) { // Down right
				bg = new Color(0, 127, 127);
				dir = 3;
			} else if(netX == -1 && netY == 1) { // Down left
				bg = new Color(127, 127, 127);
				dir = 5;
			}
			
		} else if(Math.abs(netX) + Math.abs(netY) == 1){
			player.accelerate(GRAVSTR * netX, GRAVSTR * netY);
			if(netX == -1) { // Directly left
				bg = new Color(255, 255, 0);
				dir = 6;
			} else if(netX == 1) { // Directly right
				bg = new Color(0, 255, 0);
				dir = 2;
			} else if(netY == -1) { // Directly up
				bg = new Color(255, 0, 0);
				dir = 0;
			} else if(netY == 1) { // Directly down
				bg = new Color(0, 0, 255);
				dir = 4;
			}
		} else {
			bg = new Color(255, 255, 255);
			dir = -1;
		}
		
		
//		if(g == Gravity.LEFT) {
//			player.accelerate(-GRAVSTR, 0);
//			changeBackground(surface, 255, 255, 0);			
//		}
//		else if(g == Gravity.RIGHT) {
//			player.accelerate(GRAVSTR, 0);
//			changeBackground(surface, 0, 255, 0);
//		}
//		else if(g == Gravity.DOWN) {
//			player.accelerate(0, GRAVSTR);
//			changeBackground(surface, 0, 0, 255);
//		}
//		else if(g == Gravity.UP) {
//			player.accelerate(0, -GRAVSTR);
//			changeBackground(surface, 255, 0, 0);
//		}
		
		player.draw(surface);
		level.draw(surface);
		changeBackground(surface, bg, dir);
		

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
	
	/**
	 * Changes the color of the background
	 * @param surface Surface of the background
	 * @param r	Amount of red
	 * @param g Amount of green
	 * @param b Amount of blue
	 */
	public void changeBackground(DrawingSurface surface, Color c, int dir) {
		surface.push();
		surface.fill(c.getRed(), c.getGreen(), c.getBlue(), 128);
		surface.stroke(0, 0, 0, 0);
		surface.translate(300, 200);
		if(dir == 0) {
			surface.quad(400, 300, 350, 350, 400, 225, 450, 350);
		} else if(dir == 1) {
			surface.quad(400, 300, 350, 300, 450, 250, 400, 350);
		} else if(dir == 2) {
			surface.quad(400, 300, 350, 250, 475, 300, 350, 350);
		} else if(dir == 3) {
			surface.quad(400, 300, 400, 250, 450, 350, 350, 300);
		} else if(dir == 4) {
			surface.quad(400, 300, 450, 250, 400, 375, 350, 250);
		} else if(dir == 5) {
			surface.quad(400, 300, 450, 300, 350, 350, 400, 250);
		} else if(dir == 6) {
			surface.quad(400, 300, 450, 350, 325, 300, 450, 250);
		} else if(dir == 7) {
			surface.quad(400, 300, 400, 350, 350, 250, 450, 300);
		}
		surface.pop();
	}
	
	public Gravity getGravity() {
		return g;
	}
	public void mousePressed()
	{
		Point p = surface.actualCoordinatesToAssumed(new Point(surface.mouseX,surface.mouseY));
		if (pause.contains(p))
			surface.switchScreen(ScreenSwitcher.PAUSE);
	}
}
