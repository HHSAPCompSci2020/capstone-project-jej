import java.awt.Point;
import java.util.ArrayList;
import processing.core.PApplet;

/**
 * The level class
 * @author Jensen
 *
 */
public class Level {
	private ArrayList<Obstacle> obstacles;
	private int level;
	private Point start;
	private EndPoint end;
	//the int passed in is the level number
	public Level(int level, DrawingSurface surface) {
		this.level = level;
		setup();
	}
	
	private void setup() {
		obstacles = new ArrayList<Obstacle>();
		if(level == 1) {
			start = new Point(200, 200);
			end = new EndPoint(500, 500);
			//add things that extend from obstacles
			obstacles.add(new Wall(150, 225, 100, 25, 0));
			obstacles.add(new Wall(400, 400, 200, 25, (float)Math.PI/6));
			obstacles.add(new Wall(100, 400, 200, 200, (float)Math.PI/4));
			obstacles.add(new Spike(400, 200, 5, Math.PI/4));
		}
		else if(level == 2) {
			
		}
		else {
			System.out.println("ERROR: Level " + level + " wasn't found or doesn't exist");
		}
	}
	
	public void draw(PApplet surface) {
		//no need to draw the start lol
		end.draw(surface);
		for(Obstacle o: obstacles) {
			o.draw(surface);
		}
	}
	
	public Point getStartPoint() {
		return start;
	}
	
	public EndPoint getEnd() {
		return end;
	}
	
	public ArrayList<Obstacle> getObstacles(){
		return obstacles;
	}
}
