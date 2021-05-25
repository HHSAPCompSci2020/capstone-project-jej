
import java.awt.Point;
import java.io.IOException;
import java.io.InputStream;
import java.awt.Rectangle;
import javax.imageio.ImageIO;
import java.awt.Image;

import processing.core.PImage;
/**
 * @author APCS Demos 2021, modified for own use by Jensen and Jim
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
	/**
	 * sets up the image
	 */
	public void setup()
	{	
		InputStream is = getClass().getClassLoader().getResourceAsStream("gravityball1.png");
		try {
			Image i = ImageIO.read(is);
			title = new PImage(i);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		is = getClass().getClassLoader().getResourceAsStream("nature.jpg");
		try {
			Image i = ImageIO.read(is);
			background = new PImage(i);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//title = surface.loadImage("gravityball1");
		//background = surface.loadImage("data/nature.jpg");
	}
	/**
	 * draws the screen
	 */
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
	/**
	 * detects the buttons
	 */
	public void mousePressed() {
		Point p = surface.actualCoordinatesToAssumed(new Point(surface.mouseX,surface.mouseY));
		if (start.contains(p))
			surface.switchScreen(ScreenSwitcher.LVLSELECT);
		else if(howToPlay.contains(p))
			surface.switchScreen(ScreenSwitcher.INSTRUCTION);
	}
}
