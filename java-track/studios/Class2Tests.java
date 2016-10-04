import static org.junit.Assert.*;

import org.junit.Test;

public class Class2Tests {

	@Test
	public void RectangleTest1() {
		Rectangle r = new Rectangle(5,6);
		assertTrue("area calculation error", r.calcArea() == 30);
		assertTrue("perimeter", r.calcPerimeter() == 22);
		assertTrue("is smaller error", r.isSmaller(6, 4) == false);
		assertTrue("is smaller error", r.isSmaller(10, 4) == true);
		assertTrue("is square error", r.isSquare() == false);
	}
	
	@Test
	public void RectangleTest2() {
		Rectangle r = new Rectangle(8,8);
		assertTrue("area calculation error", r.calcArea() == 64);
		assertTrue("perimeter", r.calcPerimeter() == 32);
		assertTrue("is smaller error", r.isSmaller(6, 4) == false);
		assertTrue("is smaller error", r.isSmaller(10, 8) == true);
		assertTrue("is square error", r.isSquare() == true);
	}
	
	@Test
	public void FractionTest1() {
		Fraction f = new Fraction(3,4);
		//assertTrue("area calculation error", f.addFraction(1,8) == Fraction(7,8);
	}	

	

}
