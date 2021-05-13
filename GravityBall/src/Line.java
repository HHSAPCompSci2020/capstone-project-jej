public class Line {
	private double x1, y1, x2, y2;
	
	public Line() {
		x1 = 0;
		y1 = 0;
		x2 = 0;
		y2 = 0;
	}
	
	public Line(double x1, double y1, double x2, double y2) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}
	
	public double getLength() {
		return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
	}
	
	public double getSlope() {
		return (y2 - y1)/(x2 - x1);
	}
	
	public double getAngle() {
		return Math.atan(getSlope());
	}
}
