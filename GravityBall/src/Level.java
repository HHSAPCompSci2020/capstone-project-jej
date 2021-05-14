import java.awt.Point;
import java.util.ArrayList;

/**
 * The level class
 * @author Jensen
 *
 */
public class Level {
	private ArrayList<Obstacle> obstacles;
	private int level;
	private StartPoint start;
	private EndPoint end;
	private DrawingSurface surface;
	//the int passed in is the level number
	public Level(int level, DrawingSurface surface) {
		this.level = level;
		this.surface = surface;
		setup();
	}
	
	public void setup() {
		obstacles = new ArrayList<Obstacle>();
		if(level == 1) {
			start = new StartPoint(200, 200, surface);
			end = new EndPoint(500, 500, surface);
			//add obstacles
			obstacles.add(new Obstacle());
		}
		else if(level == 2) {
			
		}
		else {
			System.out.println("ERROR: Level " + level + " wasn't found or doesn't exist");
		}
	}
	
	public void draw() {
		start.draw();
		end.draw();
		for(Obstacle o: obstacles) {
			o.draw();
		}
	}
}
