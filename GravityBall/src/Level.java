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
			obstacles.add(new Wall(150, 225, 150, 25, 0));
			obstacles.add(new Wall(400, 400, 200, 25, (float)Math.PI/6));
			obstacles.add(new Wall(100, 400, 200, 200, (float)Math.PI/4));
			obstacles.add(new Spike(400, 200, 5, Math.PI/4));
			obstacles.add(new Wall(300, 190, 250, 10, Math.PI/4));
			obstacles.add(new Spike(400, 400, 10, Math.PI/6));
			obstacles.add(new Wall(185, 300, 150, 25, -Math.PI/4));
			obstacles.add(new Wall(100, 163, 100, 25, Math.PI/2));
			obstacles.add(new Wall(150, 100, 200, 25, 0));
			obstacles.add(new Wall(400, 300, 150, 25, 3*Math.PI/4));
			obstacles.add(new Wall(300, 540, 200, 25, 0));
			obstacles.add(new Wall(495, 500, 100, 25, -Math.PI/4));
			obstacles.add(new Spike(320, 530, 15, Math.PI));
		}
		else if(level == 2) {
			start = new Point(100, 100);
			end = new EndPoint(500, 500);
			
			obstacles.add(new Wall(50, 50, 600, 25, 0));
			obstacles.add(new Wall(-200, 310, 500, 30, -Math.PI/2));
			obstacles.add(new Wall(0, 260, 400, 30, -Math.PI/2));
			obstacles.add(new Wall(65, 550, 555, 25, 0));
			obstacles.add(new Wall(180, 360, 400, 30, -Math.PI/2));
			obstacles.add(new Wall(385, 310, 500, 30, -Math.PI/2));
			obstacles.add(new Wall(500, 300, 120, 25, 0));
			
			obstacles.add(new Spike(65, 540, 30, Math.PI));
			obstacles.add(new Spike(215, 75, 40, 0));
			obstacles.add(new Spike(500, 290, 12, Math.PI));
		}
		else if(level == 3) {
			start = new Point(500, 500);
			end = new EndPoint(500, 100);
			
			obstacles.add(new Wall(50, 50, 600, 25, 0));
			obstacles.add(new Wall(-200, 310, 500, 30, -Math.PI/2));
			obstacles.add(new Wall(65, 550, 555, 25, 0));
			obstacles.add(new Wall(385, 310, 500, 30, -Math.PI/2));

			obstacles.add(new Wall(450, 400, 100, 25, 0));
			obstacles.add(new Wall(425, 400, 25, 150, 0));
			obstacles.add(new Spike(545, 408, 2, -Math.PI/2));
			
			obstacles.add(new Wall(400, 300, 220, 25, 0));
			obstacles.add(new Spike(425, 390, 12, Math.PI));
			obstacles.add(new Spike(400, 325, 22, 0));
			
			obstacles.add(new Wall(220, 370, 200, 25, -Math.PI/4));
			obstacles.add(new Spike(70, 540, 35, Math.PI));
			obstacles.add(new Wall(215, 160, 25, 300, 0));
			
			obstacles.add(new Spike(70, 75, 40, 0));
			obstacles.add(new Spike(218, 150, 2, Math.PI));
			
		}
		else if(level == 4) {
			start = new Point(500, 500);
			end = new EndPoint(500, 100);
			
			obstacles.add(new Booster(100, 100, 200, 200));
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
