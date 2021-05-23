import java.util.ArrayList;

import processing.core.PApplet;

public abstract class Obstacle {
	
	private double x, y;
	protected ArrayList<Line> hitbox;
	protected String id;
	
	public Obstacle()
	{
		x = 0;
		y = 0;
		hitbox = new ArrayList<Line>();
	}
	
	public Obstacle(double x, double y)
	{
		this.x = x;
		this.y = y;
		hitbox = new ArrayList<Line>();
	}
	
	
	public double getX()
	{
		return x;
	}
	
	public double getY()
	{
		return y;
	}
	
	public ArrayList<Line> getHitbox(){
		return hitbox;
	}
	
	public String getID() {
		return id;
	}
	
	public void draw(PApplet Surface) {
		
	}
}
