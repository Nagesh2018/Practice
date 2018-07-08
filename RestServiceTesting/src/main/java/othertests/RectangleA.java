package othertests;

import java.io.Serializable;

public class RectangleA implements Serializable{

	private double length;
	private double width;
	

	public RectangleA(double length, double width) {
		this.length = length;
		this.width = width;
		
	}
	public double area() {
		return length*width;
	}
	
}
