import java.awt.event.KeyEvent;
/**
 * instructions
 * @author Siyi Ji
 *
 */
public class Instruction extends Screen {
	private DrawingSurface surface;
	public Instruction(DrawingSurface surface) {
		super(800,600);
		this.surface = surface;
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
		
		surface.popStyle();

		if (surface.isPressed(KeyEvent.VK_SPACE)) {
			surface.switchScreen(ScreenSwitcher.MENU);
		}
	}
}
