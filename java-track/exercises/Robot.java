
public class Robot {
	//fields
	protected String name;
	//private int[][] position;
	private int posX;
	private int posY;
	private int speed;
	private String direction;
	
	//create a robot (constructors)	
	public Robot(String name, int x, int y, int speed,String direction) {
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
	
	//toString
	public String toString() {
		return name + ": Pos(" + posX + ", " + posY + ")" +
				" Speed=" + speed +
				" Direction=" + direction;
	}

	public static void main(String[] args) {
		Robot robot1 = new Robot("Harold", 22, 30, 10, "North");
		Robot robot2 = new Robot("Hilda", 10, 25, 20, "West");
		System.out.println(robot1);
		System.out.println();
		System.out.println(robot2);
		double distance = robot1.calcDistance(robot1.posX, robot1.posY, robot2.posX, robot2.posY);
		System.out.println("\nDistance: " + distance + "\n");
		robot1.rotateRobot("left");
		robot1.moveRobot(10);
		System.out.println(robot1);
		distance = robot1.calcDistance(robot1.posX, robot1.posY, robot2.posX, robot2.posY);
		System.out.println("\nDistance: " + distance + "\n");
		robot1.rotateRobot("left");
		robot1.moveRobot(50);
		System.out.println(robot1);
		distance = robot1.calcDistance(robot1.posX, robot1.posY, robot2.posX, robot2.posY);
		System.out.println("\nDistance: " + distance + "\n");
		AttackRobot ar1 = new AttackRobot("George", 10, 10, 5, "East", 20);
		ar1.shootLaser();
	}

}
