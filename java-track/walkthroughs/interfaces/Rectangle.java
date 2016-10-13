package interfaces;

import java.util.ArrayList;

public class Rectangle implements Measurable {
	//has-a
	private float height;
	private float width;
	
	public Rectangle(float h, float w) {
		this.height = h;
		this.width = w;
	}

	@Override
	public float getArea() {

		return this.height * this.width;
	}

	@Override
	public float getPerimeter() {

		return (2 * this.height) + (2 * this.width);
	}
	//has-a
	
	public static void main(String[] args) {
		Rectangle r = new Rectangle(7,8);
		Circle c = new Circle(5);
		
		ArrayList<Measurable> shapes = new ArrayList<Measurable>();
		shapes.add(r);
		shapes.add(c);
		
		for (int i = 0; i<shapes.size(); i++) {
			Measurable shape = shapes.get(i);
			System.out.println("Area: " + shape.getArea());
			System.out.println("Perimeter: " + shape.getPerimeter());
		}
	}
	

}


