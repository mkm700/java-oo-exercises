import static org.junit.Assert.*;

import org.junit.Test;

public class RobotTest {
	
	@Test
	public void rotateRobotR() {
		Robot r = new Robot("Test", 0, 0, 20, 4);
		r.rotateRobot("right");
		assertTrue("Problem rotating right from the west",r.getDirection() == 1);
	}
	
	@Test
	public void rotateRobotR1() {
		Robot r = new Robot("Test", 0, 0, 20, 2);
		r.rotateRobot("right");
		assertTrue("Problem rotating right from the east",r.getDirection() == 3);
	}
	
	@Test
	public void rotateRobotL() {
		Robot r = new Robot("Test", 0, 0, 20, 1);
		r.rotateRobot("left");
		assertTrue("Problem rotating left from the north",r.getDirection() == 4);
	}
	
	@Test
	public void rotateRobotL1() {
		Robot r = new Robot("Test", 0, 0, 20, 4);
		r.rotateRobot("left");
		assertTrue("Problem rotating left from the west",r.getDirection() == 3);
	}

	@Test
	public void moveRobotN() {
		Robot r = new Robot("Test", 0, 0, 20, 1);
		r.moveRobot(10);
		assertTrue("Problem starting north",r.getPosX() == 0 && r.getPosY() == 10);	
	}
	
	@Test
	public void moveRobotS() {
		Robot r = new Robot("Test", 10, 5, 20, 3);
		r.moveRobot(10);
		assertTrue("Problem starting south",r.getPosX() == 10 && r.getPosY() == -5);	
	}
	
	@Test
	public void moveRobotW() {
		Robot r = new Robot("Test", 10, -5, 20, 4);
		r.moveRobot(20);
		assertTrue("Problem starting west",r.getPosX() == -10 && r.getPosY() == -5);	
	}
	
	@Test
	public void moveRobotE() {
		Robot r = new Robot("Test", 0, 0, 20, 2);
		r.moveRobot(10);
		assertTrue("Problem starting east",r.getPosX() == 10 && r.getPosY() == 0);	
	}

}
