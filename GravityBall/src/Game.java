import java.awt.event.KeyEvent;

public class Game extends Screen {
	private DrawingSurface surface;
	private Level level;
	public Game(DrawingSurface surface) {
		super(800,600);
		this.surface = surface;
		//
		level = new Level(1, surface);
	}
	
	public void draw() {
		surface.pushStyle();

		surface.background(255);   // Clear the screen with a white background
		surface.stroke(0);     // Set line drawing color to white
		surface.noFill();
		
		surface.fill(0);
		surface.text("press space to exit", 100, 100);
		surface.popStyle();
		
		level.draw();
		

		if (surface.isPressed(KeyEvent.VK_SPACE)) {
			surface.switchScreen(ScreenSwitcher.MENU);
		}
	}
}
