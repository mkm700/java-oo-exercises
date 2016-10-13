import static org.junit.Assert.*;

import org.junit.Test;

public class RobotTest {
	
	@Test
	public void rotateRobotR() {
		Robot r = new Robot("Test", 0, 0, 20, "West");
		r.rotateRobot("Right");
		assertTrue("Problem rotating Right from the west",r.getDirection() == "North");
	}
	
	@Test
	public void rotateRobotR1() {
		Robot r = new Robot("Test", 0, 0, 20, "East");
		r.rotateRobot("Right");
		assertTrue("Problem rotating Right from the east",r.getDirection() == "South");
	}
	
	@Test
	public void rotateRobotL() {
		Robot r = new Robot("Test", 0, 0, 20, "North");
		r.rotateRobot("Left");
		assertTrue("Problem rotating Left from the north",r.getDirection() == "West");
	}
	
	@Test
	public void rotateRobotL1() {
		Robot r = new Robot("Test", 0, 0, 20, "West");
		r.rotateRobot("Left");
		assertTrue("Problem rotating Left from the west",r.getDirection() == "South");
	}

	@Test
	public void moveRobotN() {
		Robot r = new Robot("Test", 0, 0, 20, "North");
		r.moveRobot(10);
		assertTrue("Problem starting north",r.getPosX() == 0 && r.getPosY() == 10);	
	}
	
	@Test
	public void moveRobotS() {
		Robot r = new Robot("Test", 10, 5, 20, "South");
		r.moveRobot(10);
		assertTrue("Problem starting south",r.getPosX() == 10 && r.getPosY() == -5);	
	}
	
	@Test
	public void moveRobotW() {
		Robot r = new Robot("Test", 10, -5, 20, "West");
		r.moveRobot(20);
		assertTrue("Problem starting west",r.getPosX() == -10 && r.getPosY() == -5);	
	}
	
	@Test
	public void moveRobotE() {
		Robot r = new Robot("Test", 0, 0, 20, "East");
		r.moveRobot(10);
		assertTrue("Problem starting east",r.getPosX() == 10 && r.getPosY() == 0);	
	}
	
	@Test
	public void testInvalidSpeed() {
		try {
			Robot r = new Robot("Betty",10,12,-10,"north");
			fail("Exception was not thrown for new robot");
		}
		catch (IllegalArgumentException e) {
			assertTrue(true);
		}
	}

}
