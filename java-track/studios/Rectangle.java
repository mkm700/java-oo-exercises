
public class Rectangle {
	//fields (has-a)
	private int length;
	private int width;
	
	//constructor
	public Rectangle(int l, int w) {
		this.length = l;
		this.width = w;
	}
	
	//behaviors
	
	//calculate area
	public int calcArea() {
		return this.length * this.width;
	}
	
	//calculate perimeter
	public int calcPerimeter() {
		return (this.length * 2) + (this.width * 2);
	}
	
	//compare area to find smaller rectangle
	public boolean isSmaller(int l, int w) {
		int area1 = calcArea();
		int area2 = l*w;
		if (area1 < area2) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//is square
	public boolean isSquare() {
		if (this.length == this.width) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//toString
	public String toString() {
		return "Length: " + this.length + "\nWidth: " + width;
	}
	
	public static void main(String[] args) {
		Rectangle rec1 = new Rectangle(10,10);
		Rectangle rec2 = new Rectangle(2,10);
		System.out.println(rec1);
		System.out.println("Area: " + rec1.calcArea());
		System.out.println("Perimeter: " + rec1.calcPerimeter());
		System.out.println("Is Square: " + rec1.isSquare());
		System.out.println("isSmaller: " + rec1.isSmaller(12, 8));
		System.out.println();
		System.out.println(rec2);
		System.out.println("Area: " + rec2.calcArea());
		System.out.println("Perimeter: " + rec2.calcPerimeter());
		System.out.println("Is Square: " + rec2.isSquare());
		System.out.println("isSmaller: " + rec2.isSmaller(12, 8));
		

	}

}
