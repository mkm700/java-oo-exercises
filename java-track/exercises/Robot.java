
public class Robot {
	//fields
	protected String name;
	//private int[][] position;
	private int posX;
	private int posY;
	private int speed;
	private String direction;
	private RobotBehavior behavior;
	
	//create a robot (constructors)	
	public Robot(String name, int x, int y, int speed, String direction) {
		this.name = name;
		this.posX = x;
		this.posY = y;
		this.speed = speed;
		this.direction = direction;
	}
	
	//getters
	public String getName() {
		return this.name;
	}
	
	public int getPosX() {
		return this.posX;
	}
	
	public int getPosY() {
		return this.posY;
	}
	
	public String getDirection() {
		return this.direction;
	}
	
	public int getSpeed() {
		return this.speed;
	}
	
	public RobotBehavior getBehavior() {
		return this.behavior;
	} 
	
	
	//setters
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPosX(int x) {
		this.posX = x;
	}
	
	public void setPosY(int y) {
		this.posY = y;
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public void setDirection(String direction) {
		this.direction = direction;
	} 
	
	public void setBehavior(RobotBehavior behavior) {
		this.behavior = behavior;
	} 
	
	//methods / behaviors
	public void moveRobot(int dist) {
		if (this.direction.equals("North") ) 
			this.posY = this.posY + dist;
		
		else if (this.direction.equals("East") )   
			this.posX = this.posX + dist;
		
		else if (this.direction.equals("South") )  
			this.posY = this.posY - dist;
		
		else   									
			this.posX = this.posX - dist;
	}
	
	public void rotateRobot(String direction) {
		if (direction.equals("Left")) {
			if (this.direction.equals("North") ) 
				this.direction = "West";
			
			else if (this.direction.equals("East") ) 
				this.direction = "North";
			
			else if (this.direction.equals("South") ) 
				this.direction = "East";
			
			else this.direction = "South";
			
		}
		if (direction.equals("Right")) {
			if (this.direction.equals("North") ) 
				this.direction = "East";
			
			else if (this.direction.equals("East") ) 
				this.direction = "South";
			
			else if (this.direction.equals("South") ) 
				this.direction = "West";
			
			else this.direction = "North";
		} 
	}
	
	public double calcDistance(int x1, int y1, int x2, int y2) {
		double x = Math.pow((x2-x1),2.0);
		double y = Math.pow((y2-y1), 2.0);
		return Math.sqrt(x+y);
	}

//	//doNextMove
//	public boolean doNextMove(CarrierRobot cr) {
//		this.behavior.doNextMove(cr);
//	}
	
	//toString
	public String toString() {
		return name + ": Pos(" + posX + ", " + posY + ")" +
				" Speed=" + speed + " Direction=" + direction + " Behavior: " + behavior;
	}

	public static void main(String[] args) {		
		CarrierRobot cr1 = new CarrierRobot("Betty",50,-12,0,"north",0);
		AttackRobot ar1 = new AttackRobot("Barbara",10,5,0,"north",10);
		cr1.setBehavior(new GoToGoal(2,-5));
		ar1.setBehavior(new DistanceAttack(ar1,20.0));
		boolean keepGoing = true;
		boolean crGoal = false;
		boolean arGoal = false;
		while (keepGoing) {
			crGoal = cr1.getBehavior().doNextMove(cr1);
			arGoal = ar1.getBehavior().doNextMove(cr1);
			if (crGoal) {
				keepGoing = false;
				System.out.print("Carrier Robot ");
			}
			else if (arGoal) {
				keepGoing = false;
				System.out.print("Attack Robot ");
			}
		}
		System.out.println("reached the goal!!");
		
	}

}
