
public class Robot {
	//fields
	protected String name;
	//private int[][] position;
	private int posX;
	private int posY;
	private int speed;
	private int direction; //1=north; 2=east; 3=south; 4=east
	
	//create a robot (constructors)	
	public Robot(String name, int x, int y, int speed,int direction) {
		this.name = name;
		this.posX = x;
		this.posY = y;
		this.speed = speed;
		this.direction = direction;
	}
	
	//getters
	public int getPosX() {
		return this.posX;
	}
	
	public int getPosY() {
		return this.posY;
	}
	
	public int getDirection() {
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
	
	public void setDirection(int direction) {
		this.direction = direction;
	} 
	
	//methods / behaviors
	public void moveRobot(int dist) {
		if (this.direction == 1 ) {  //north
			this.posY = this.posY + dist;
		}
		if (this.direction == 2 ) {  //east
			this.posX = this.posX + dist;
		}
		if (this.direction == 3 ) { //south
			this.posY = this.posY - dist;
		}
		if (this.direction == 4 ) { //west
			this.posX = this.posX - dist;
		}
	}
	
	public void rotateRobot(String direction) {
		if (direction.equals("left")) {
			if (this.direction == 1 ) {
				this.direction = 4;
			}
			else {
				this.direction = this.direction - 1;
			}
		}
		if (direction.equals("right")) {
			if (this.direction == 4 ) {
				this.direction = 1;
			}
			else {
				this.direction = this.direction + 1;
			}
		} 
	}
	
	public double calcDistance(int x1, int y1, int x2, int y2) {
		double x = Math.pow((x2-x1),2.0);
		double y = Math.pow((y2-y1), 2.0);
		return Math.sqrt(x+y);
	}
	
	//toString
	public String toString() {
		return "Name: " + name +
				" Position: (" + posX + ", " + posY + ")" +
				" Speed: " + speed +
				" Direction: " + direction;
	}

	public static void main(String[] args) {
		Robot robot1 = new Robot("Harold", 22, 30, 10, 4);
		Robot robot2 = new Robot("Hilda", 10, 25, 20, 3);
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
		AttackRobot ar1 = new AttackRobot("George", 10, 10, 5, 2, 20);
		ar1.shootLaser();
	}

}
