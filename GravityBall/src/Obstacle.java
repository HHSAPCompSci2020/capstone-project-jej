import processing.core.PApplet;

public class Obstacle {
	
	private double x, y;
	
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
}
