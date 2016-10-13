
public class DistanceAttack implements RobotBehavior {
	//if the carrier robot gets inside the attack robot's safe zone, shoot a laser and set goal attained 

	//has-a: attack robot
	private AttackRobot ar;
	private double safeZone;
	
	//constructor
	public DistanceAttack(AttackRobot ar, double safeZone) {
		this.ar = ar;
		this.safeZone = safeZone;
	}
	
	@Override
	public boolean doNextMove(CarrierRobot cr) {
		double distance = ar.calcDistance(ar.getPosX(), ar.getPosY(), cr.getPosX(), cr.getPosY());
		System.out.println("AR position: " + "(" + ar.getPosX() + "," + ar.getPosY() + ")\nDistance: " + distance);
		if (distance < safeZone) {
			ar.shootLaser();
			return true;
		}
		return false;
	}

}
