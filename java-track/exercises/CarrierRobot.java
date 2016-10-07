
public class CarrierRobot extends Robot {
	//fields
	int maxLoad;
	
	//constructor
	public CarrierRobot(String name, int x, int y, 
						int speed, String direction, int maxLoad) {
		super(name, x, y, speed, direction);
		this.maxLoad = maxLoad;
	}
	
	//methods
	public boolean verifyLoad(int load) {
		if (load <= maxLoad) {
			return true;
		}
		else return false;
	}
	
	//toString
	public String toString() {
		return super.toString() + "\nMax Load = " + maxLoad;
	}
	
	public static void main(String[] args) {
		CarrierRobot cr1 = new CarrierRobot("Larry", 20, 0, 15, "North", 200);
		System.out.println(cr1);
		System.out.println(cr1.name + ", can you carry 100lbs?");
		System.out.println(cr1.verifyLoad(100));
		System.out.println(cr1.name + ", can you carry 200lbs?");
		System.out.println(cr1.verifyLoad(200));
		System.out.println(cr1.name + ", can you carry 300lbs?");
		System.out.println(cr1.verifyLoad(300));

	}

}
