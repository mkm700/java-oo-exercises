
public class GoToGoal implements RobotBehavior {
	//move robot in increments of 1 until it reaches goal
			//if r.pos > goal.pos -> r.pos - 1
			//if r.pos < goal.pos -> r.pos + 1
			//if r.pos == goal.pos -> stop
	
	private int goalX;
	private int goalY;
	
	public GoToGoal(int goalX, int goalY) {
		this.goalX = goalX;
		this.goalY = goalY;
	}
	
	@Override
	public boolean doNextMove(CarrierRobot cr) {
		
		int x = cr.getPosX();
		int y = cr.getPosY();
		boolean status = false;

		if (x == goalX) { 			//goal x is met, check Y
			
			if (y == goalY) {
				status = true;
			}
			
			else if (y > goalY) {
				cr.setPosY(y-1);
				status = false;
			}
			
			else if (y < goalY) {
				cr.setPosY(y+1);
				status = false;
			}
		}
		
		else if (x > goalX) {
			cr.setPosX(x-1);
			status = false;
		}
		
		else if (x < goalX) {
			cr.setPosX(x+1);
			status = false;
		}
		
		System.out.println("CR position: (" + cr.getPosX() + "," + cr.getPosY() + ")");
		return status;
		
	}
	
	

}


