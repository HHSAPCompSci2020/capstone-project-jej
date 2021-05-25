import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.xml.stream.events.StartDocument;

import processing.core.PImage;
/**
 * This the pause screen, used during the game
 * @author Siyi Ji
 *
 */
public class Pause extends Screen {
	private DrawingSurface surface;
	private Rectangle back, menu;
//	private PImage background;
	public Pause(DrawingSurface surface) {
		super(800,600);
		this.surface = surface;
		back = new Rectangle(400-50,250,100,50);
		menu = new Rectangle(400-50,350,100,50);
		
	}
	/**
	 * sets up the Images
	 */
	public void setup()
	{
//		background = surface.loadImage("nature4.jpg");
	}
	/**
	 * draws the screen
	 */
	public void draw() {
		surface.pushStyle();

		surface.background(255);   // Clear the screen with a white background
//		surface.image(background,0,0, 800, 600);
		surface.stroke(0);     // Set line drawing color to white
		surface.noFill();
		
		surface.fill(0);
		surface.textSize(40);
		surface.textAlign(surface.CENTER);
		surface.text("Paused",  400, 200);
		surface.fill(255);
		surface.rect(back.x, back.y, back.width, back.height, 10, 10, 10, 10);
		surface.fill(0);
		surface.textSize(15);
		surface.textAlign(surface.LEFT);
		String str = "Back";
		float w = surface.textWidth(str);
		surface.text(str, back.x+back.width/2-w/2, back.y+back.height/2);
		surface.fill(255);
		surface.rect(menu.x, menu.y, menu.width, menu.height, 10, 10, 10, 10);
		surface.fill(0);
		surface.textAlign(surface.LEFT);
		str = "Main Menu";
		w = surface.textWidth(str);
		surface.text(str, menu.x+menu.width/2-w/2, menu.y+menu.height/2);
		
		
		
		surface.popStyle();

		
	}
	/**
	 * detects the buttons
	 */
	public void mousePressed()
	{
		Point p = surface.actualCoordinatesToAssumed(new Point(surface.mouseX,surface.mouseY));
		if (back.contains(p))
			surface.switchScreen(ScreenSwitcher.GAME);
		if(menu.contains(p))
			surface.switchScreen(ScreenSwitcher.MENU);
	}
}