import java.util.ArrayList;

import processing.core.PApplet;

public abstract class Obstacle {
	
	private double x, y;
	private ArrayList<Line> hitbox;
	
	public Obstacle()
	{
		x = 0;
		y = 0;
	}
	
	public Obstacle(double x, double y)
	{
		this.x = x;
		this.y = y;
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
	
	public void draw(PApplet Surface) {
		
	}
}
