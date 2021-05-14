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
	Point start;
	Point end;
	//the int passed in is the level number
	public Level(int level) {
		this.level = level;
		setup();
	}
	
	public void setup() {
		obstacles = new ArrayList<Obstacle>();
		if(level == 1) {
			start = new Point(100, 100);
			end = new Point(500, 500);
			//add obstacles
			obstacles.add(new Obstacle());
		}
		else {
			System.out.println("ERROR: Level " + level + " wasn't found or doesn't exist");
		}
	}
	
	public void draw() {
		for(Obstacle o: obstacles) {
			o.draw();
		}
	}
}
