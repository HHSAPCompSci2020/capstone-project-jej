import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import processing.core.PImage;

/**
 * a victory screen after a level
 * @author Jim Ji
 *
 */
public class EndScreen extends Screen {
	private DrawingSurface surface;
	private Rectangle nextLevel;
	private PImage background;
	public EndScreen(DrawingSurface surface) {
		super(800,600);
		this.surface = surface;
		nextLevel = new Rectangle(100,100,100,50);
	}
	
	public void setup() 
	{
		background = surface.loadImage("nature5.jpg");
	}
	//display a "you did it" and then add buttons that go to the main menu, level select
	public void draw() {
		surface.background(255);   // Clear the screen with a white background
		
		surface.stroke(0);     // Set line drawing color to white
		surface.noFill();
		surface.fill(0);
		surface.image(background, 0 ,0,800,600);
		surface.textSize(20);
		surface.text("You did it!", 50, 50);
		surface.fill(255);
		surface.rect(nextLevel.x, nextLevel.y, nextLevel.width, nextLevel.height, 10, 10, 10, 10);
		surface.fill(0);
		String str = "nextLevel";
		float w = surface.textWidth(str);
		surface.text(str, nextLevel.x+nextLevel.width/2-w/2, nextLevel.y+nextLevel.height/2);
	}
	
	public void mousePressed()
	{
		Point p = surface.actualCoordinatesToAssumed(new Point(surface.mouseX,surface.mouseY));
		if (nextLevel.contains(p))
			surface.changeLevel(Game.getLevelNumber()+1);
			surface.switchScreen(ScreenSwitcher.GAME);
	}
}
