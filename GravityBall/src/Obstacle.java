import java.util.ArrayList;

import processing.core.PApplet;

public abstract class Obstacle {
	
	protected double x, y;
	protected double width, height;
	protected ArrayList<Line> hitbox;
	protected String id;
	
	public Obstacle()
	{
		x = 0;
		y = 0;
		width = 0;
		height = 0;
		hitbox = new ArrayList<Line>();
	}
	
	public Obstacle(double x, double y)
	{
		this.x = x;
		this.y = y;
		width = 0;
		height = 0;
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
	
	public double getWidth() {
		return width;
	}
	
	public double getHeight() {
		return height;
	}
	
	public ArrayList<Line> getHitbox(){
		return hitbox;
	}
	
	public String getID() {
		return id;
	}
	
	public abstract void draw(PApplet Surface);
}
