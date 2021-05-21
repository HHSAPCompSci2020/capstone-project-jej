
public class EndScreen extends Screen {
	private DrawingSurface surface;
	public EndScreen(DrawingSurface surface) {
		super(800,600);
		this.surface = surface;
	}
	
	//display a "you did it" and then add buttons that go to the main menu, level select
	public void draw() {
		surface.background(255);   // Clear the screen with a white background
		surface.stroke(0);     // Set line drawing color to white
		surface.noFill();
		surface.fill(0);
		surface.text("you did it!", 50, 50);
	}
}
