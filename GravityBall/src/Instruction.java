import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.xml.stream.events.StartDocument;
/**
 * instructions
 * @author Siyi Ji
 *
 */
public class Instruction extends Screen {
	private DrawingSurface surface;
	private Rectangle back;
	public Instruction(DrawingSurface surface) {
		super(800,600);
		this.surface = surface;
		back = new Rectangle(600,0,200,200);
	}
	
	public void draw() {
		surface.pushStyle();

		surface.background(255);   // Clear the screen with a white background
		surface.stroke(0);     // Set line drawing color to white
		surface.noFill();
		
		surface.fill(0);
		surface.textSize(15);
		surface.textAlign(surface.CENTER);
		surface.text("You are a lost soul, and you are trying to get to the spirit world.\n In order to do this you must collect spirit orbs.\r\n" + 
				"Use keys to change gravity, most likely WASD. Get to the finish area.\nPress Space to exit\r\n",  400, 200);
		surface.fill(255);
		surface.rect(back.x, back.y, back.width, back.height, 10, 10, 10, 10);
		surface.fill(0);
		String str = "Back";
		float w = surface.textWidth(str);
		surface.text(str, back.x+back.width/2-w/2, back.y+back.height/2);
		
		surface.popStyle();

		Point p = surface.actualCoordinatesToAssumed(new Point(surface.mouseX,surface.mouseY));
		if (back.contains(p))
			surface.switchScreen(ScreenSwitcher.MENU);
	}
}
