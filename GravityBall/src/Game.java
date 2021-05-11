import java.awt.event.KeyEvent;

public class Game extends Screen {
	private DrawingSurface surface;
	public Game(DrawingSurface surface) {
		super(800,600);
		this.surface = surface;
	}
	
	public void draw() {
		surface.pushStyle();

		surface.background(255);   // Clear the screen with a white background
		surface.stroke(0);     // Set line drawing color to white
		surface.noFill();
		
		surface.fill(0);
		surface.text("press space to exit", 100, 100);
		surface.popStyle();

		if (surface.isPressed(KeyEvent.VK_SPACE)) {
			surface.switchScreen(ScreenSwitcher.MENU);
		}
	}
}
