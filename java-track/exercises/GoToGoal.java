
public class GoToGoal implements RobotBehavior {
	//move robot using specified increment until it reaches goal
	
	private int goalX;
	private int goalY;
	private int increment;
	
	public GoToGoal(int goalX, int goalY, int increment) {
		this.goalX = goalX;
		this.goalY = goalY;
		this.increment = increment;
	}
	
	@Override
	public boolean doNextMove(CarrierRobot cr) {
		
		int x = cr.getPosX();
		int y = cr.getPosY();
		
		int incX = increment;
		int incY = increment;
		int remainX = Math.abs(x - goalX);
		int remainY = Math.abs(y - goalY);
		
		if (remainX == 0 && remainY == 0) { 	//goal attained!
			return true;
		}
		
		//evaluate X
		if (remainX < incX) {				//if x distance left is smaller than increment, reduce it to remaining x
			incX = remainX;
		}
		
		if (x > goalX) {
			cr.setDirection("west");
			cr.moveRobot(incX);
		}
		
		if (x < goalX) {
			cr.setDirection("east");
			cr.moveRobot(incX);
		}
		
		//evaluate Y
		
		if (remainY < incY) {				//if y distance left is smaller than increment, reduce it to remaining y
			incY = remainY;
		}
			
		if (y > goalY) {
			cr.setDirection("south");
			cr.moveRobot(incY);
		}
			
		if (y < goalY) {
			cr.setDirection("north");
			cr.moveRobot(incY);
		}
		
		System.out.println("CR position: (" + cr.getPosX() + "," + cr.getPosY() + ")");
		return false;
		
	}
	
}
