import java.util.ArrayList;
import java.util.Scanner;

public class RobotMenu {
	private ArrayList<Robot> robots;
	private Scanner s;
	
	//constructor
	RobotMenu() {
		s = new Scanner(System.in);
		robots = new ArrayList<Robot>();
	}
	
	//print menu options
	public int startMenu() {
		System.out.println("Main Menu: Robots R Us");
		System.out.println("----------------------");
		System.out.println("1. Create a Robot");
		System.out.println("2. Display the list of available robots");
		System.out.println("3. Move a robot");
		System.out.println("4. Rotate a robot");
		System.out.println("5. Compute the distance between two robots");
		System.out.println("6. Exit\n");
		System.out.println("Please enter an option: ");
		
		if (s.hasNextInt()) {		
			int option = s.nextInt();	
			while ((option < 1 || option > 6)) {
				System.out.println("Invalid entry. Please select a number between 1 and 6. ");
				option = s.nextInt();
			}
			return option;
		}
		else {
			return 6;
		}
	}

	//process input
	public void processInput(int x) {
		if (x == 1) {
			createRobot();
		}
		else if (x == 2) {
			displayRobots();
		}
		else if (x == 3) {
			displayRobots();
			Robot r = selectRobot();
			System.out.println("How far do you want to move the robot? ");
			int move = s.nextInt();
			r.moveRobot(move);
		}
		else if (x == 4) {
			displayRobots();
			Robot r = selectRobot();
			System.out.println("Do you want to go left or right? ");
			String dir = s.next();
			r.rotateRobot(dir);
		}
		else if (x == 5) {
			displayRobots();
			Robot r1 = selectRobot();
			Robot r2 = selectRobot();
			double dist = r1.calcDistance(r1.getPosX(), r1.getPosY(), r2.getPosX(), r2.getPosY());
			System.out.println("The distance between the 2 robots is " + dist + "\n");
		}	
		else if (x == 6) {
			System.out.println("Good-bye!");
		}
	}
	
	//create a robot
	public void createRobot() {
		System.out.println("What is the name of the robot? ");
		String name = s.next();
		System.out.println("Please enter an x position: ");
		int x = s.nextInt();
		System.out.println("Please enter a y position: ");
		int y = s.nextInt();
		System.out.println("Please enter a speed for your robot: ");
		int speed = s.nextInt();
		System.out.println("Please enter the orientation\n(1=north, 2=east, 3=south, 4=west): ");
		int dir = s.nextInt();
		
		robots.add(new Robot(name, x, y, speed, dir));
		System.out.println("Welcome to the world, " + name + "!");
	}
	
	//display a list of robots
	public void displayRobots() {
		for (int i=0; i < robots.size(); i++) {
			System.out.println("#" + (i+1) + " " + robots.get(i));
		}
	}
	
	//select a robot
	public Robot selectRobot() {
		System.out.println("Select a robot: ");
		int x = s.nextInt();
		while (x < 1 || x > robots.size()) {
			System.out.println("Invalid selection. Please try again.");
			x = s.nextInt();
		}
		System.out.println();
		return robots.get(x-1);
	}
	
	//move a robot
	public void moveRobot() {
		displayRobots();
		Robot r = selectRobot();
		System.out.println("How far do you want to move the robot? ");
		int x = s.nextInt();
		r.moveRobot(x);
	}

	public static void main(String[] args) {
		int x = 0;
		RobotMenu rm = new RobotMenu();
		do {
			x = rm.startMenu();
			rm.processInput(x);
		} while (x != 6);
	}

}
