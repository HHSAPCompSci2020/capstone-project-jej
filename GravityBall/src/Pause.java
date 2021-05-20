import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.xml.stream.events.StartDocument;

import processing.core.PImage;
/**
 * instructions
 * @author Siyi Ji
 *
 */
public class Pause extends Screen {
	private DrawingSurface surface;
	private Rectangle back;
	private PImage background;
	public Pause(DrawingSurface surface) {
		super(800,600);
		this.surface = surface;
		back = new Rectangle(0,550,100,50);
		
	}
	public void setup()
	{
		background = surface.loadImage("nature4.jpg");
	}
	public void draw() {
		surface.pushStyle();

		surface.background(255);   // Clear the screen with a white background
		surface.image(background,0,0, 800, 600);
		surface.stroke(0);     // Set line drawing color to white
		surface.noFill();
		
		surface.fill(0);
		surface.textSize(40);
		surface.textAlign(surface.CENTER);
		surface.text("Paused",  400, 200);
		surface.fill(255);
		surface.rect(back.x, back.y, back.width, back.height, 10, 10, 10, 10);
		surface.fill(0);
		String str = "Back";
		float w = surface.textWidth(str);
		surface.text(str, back.x+back.width/2-w/2, back.y+back.height/2);
		
		surface.popStyle();

		
	}
	
	public void mousePressed()
	{
		Point p = surface.actualCoordinatesToAssumed(new Point(surface.mouseX,surface.mouseY));
		if (back.contains(p))
			surface.switchScreen(ScreenSwitcher.GAME);
	}
}