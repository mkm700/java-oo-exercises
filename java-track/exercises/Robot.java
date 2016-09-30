
public class Robot {
	//fields
	private String name;
	private int[][] position;
	private int speed;
	private int direction; //0=north; 90=east; 180=south; 270=east
		
	//behaviors
	
	//create a robot (constructors)
	public Robot(String name) {
		this.name = name;
		this.position = new int[2][1];
		this.position[0][0] = 0;
		this.position[1][0] = 0;
		this.speed = 10;
		this.direction = 0;
	}
	
	public Robot(String name, int x, int y, int speed,int direction) {
		this.name = name;
		this.position = new int[2][1];
		this.position[0][0] = x;
		this.position[1][0] = y;
		this.speed = speed;
		this.direction = direction;
	}
	
	//getters
	public String getName() {
		return this.name;
	}
	
	public int getPositionX() {
		return this.position[0][0];
	}
	
	public int getPositionY() {
		return this.position[1][0];
	}
	
	public int getSpeed() {
		return this.speed;
	}
	
	public int getDirection() {
		return this.direction;
	}
	
	//setters
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPosition(int x, int y) {
		this.position[0][0] = x;
		this.position[1][0] = y;
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public void setDirection(int direction) {
		this.direction = direction;
	} 
	
	//methods
	public void moveRobot(int speed) {
		if (this.direction == 0 ) {  //north
			this.position[1][0] = this.position[1][0] + speed;
		}
		if (this.direction == 90 ) {  //east
			this.position[0][0] = this.position[0][0] + speed;
		}
		if (this.direction == 180 ) { //south
			this.position[1][0] = this.position[1][0] - speed;
		}
		if (this.direction == 270 ) { //west
			this.position[0][0] = this.position[1][0] - speed;
		}
	}
	
	public void rotateRobot(String direction) {
		if (direction.equals("left")) {
			if (this.direction == 0 ) {
				this.direction = 270;
			}
			else {
				this.direction = this.direction - 90;
			}
		}
		if (direction.equals("right")) {
			if (this.direction == 270 ) {
				this.direction = 0;
			}
			else {
				this.direction = this.direction + 90;
			}
		} 
	}
	
	public double calcDistance (int x1, int y1, int x2, int y2) {
		double x = Math.pow((x2-x1),2.0);
		double y = Math.pow((y2-y1), 2.0);
		return Math.sqrt(x+y);
	}
	
	//toString
	public String toString() {
		return "Name: " + name + "\nPosition: (" + position[0][0] + ", " + position[1][0] + ") \nSpeed: " + speed + "\nDirection: " + direction;
	}

	public static void main(String[] args) {
		Robot robot1 = new Robot("Harold");
		Robot robot2 = new Robot("Hilda", 10, 25, 20, 90);
		System.out.println(robot1);
		System.out.println();
		System.out.println(robot2);
		double distance = robot1.calcDistance(robot1.getPositionX(), robot1.getPositionY(), robot2.getPositionX(), robot2.getPositionY());
		System.out.println("\nDistance: " + distance + "\n");
		robot1.rotateRobot("left");
		robot1.moveRobot(10);
		System.out.println(robot1);
		distance = robot1.calcDistance(robot1.getPositionX(), robot1.getPositionY(), robot2.getPositionX(), robot2.getPositionY());
		System.out.println("\nDistance: " + distance + "\n");
		robot1.rotateRobot("left");
		robot1.moveRobot(50);
		System.out.println(robot1);
		distance = robot1.calcDistance(robot1.getPositionX(), robot1.getPositionY(), robot2.getPositionX(), robot2.getPositionY());
		System.out.println("\nDistance: " + distance + "\n");
	
	}

}
