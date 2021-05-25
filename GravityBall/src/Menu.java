
import java.awt.Point;
import java.awt.Rectangle;

import processing.core.PImage;
/**
 * @author APCS Demos 2021, modified for own use by Jensen
 */
public class Menu extends Screen {
	private DrawingSurface surface;
	private Rectangle start;
	private Rectangle howToPlay;
	private PImage title;
	private PImage background;
	
	public Menu(DrawingSurface surface) {
		super(800,600);
		this.surface = surface;
		start = new Rectangle(800/2-100,600/2-100,150,50);
		howToPlay =  new Rectangle(800/2-100,600/2,150,50);
	}
	
	public void setup()
	{
		title = surface.loadImage("gravityball1.png");
		background = surface.loadImage("nature.jpg");
	}
	
	public void draw() {
		surface.pushStyle();
		
		surface.background(255,255,255);
		surface.image(background,0,0,800,600);
		surface.fill(255);
		surface.rect(start.x, start.y, start.width, start.height, 10, 10, 10, 10);
		surface.fill(0);
		String str = "Play";
		float w = surface.textWidth(str);
		surface.text(str, start.x+start.width/2-w/2, start.y+start.height/2);
		surface.fill(255);
		surface.rect(howToPlay.x, howToPlay.y, howToPlay.width, howToPlay.height, 10, 10, 10, 10);
		surface.fill(0);
		str = "How to Play";
		w = surface.textWidth(str);
		surface.text(str, howToPlay.x+howToPlay.width/2-w/2, howToPlay.y+howToPlay.height/2);
		surface.image(title, 100, 80,600,100);
		
		
		
		
		surface.popStyle();
	}
	
	public void mousePressed() {
		Point p = surface.actualCoordinatesToAssumed(new Point(surface.mouseX,surface.mouseY));
		if (start.contains(p))
			surface.switchScreen(ScreenSwitcher.LVLSELECT);
		else if(howToPlay.contains(p))
			surface.switchScreen(ScreenSwitcher.INSTRUCTION);
	}
}
