
public class AttackRobot extends Robot {
	//fields
	private int maxLaserDist;

	//constructor
	public AttackRobot(String name, int x, int y, 
						int speed,int direction, int maxLaserDist) {
		super(name, x, y, speed, direction);
		this.maxLaserDist = maxLaserDist;
	}
	
	//behaviors
	public void shootLaser() {
		//return a random distance up to the max laser dist
		int dist = (int)((Math.random() * this.maxLaserDist)+1);
		System.out.println("Your laser went a distance of " + dist + ".");
		if (dist < .25 * this.maxLaserDist) {
			System.out.println("That was a dud. Better luck next time, " + name + ".");
		}
		if (dist > .75 * this.maxLaserDist) {
			System.out.println("Great shot, " + name + "!!!");
		}
	}
	
	//toString
	public String toString() {
		return super.toString() + "\nMax Laser Dist = " + maxLaserDist;
	}
	
	public static void main(String[] args) {
		AttackRobot ar1 = new AttackRobot("George", 10, 10, 5, 2, 20);
		System.out.println(ar1);
		ar1.shootLaser();
		

	}

}
