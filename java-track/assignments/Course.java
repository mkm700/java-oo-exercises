import java.util.ArrayList;

public class Course {
	private String name;
	private int courseCredits;
	private int numSeats;
	private ArrayList<Student> students;
	static ArrayList<Course> courseList = new ArrayList<Course>();
	
	//constructor 
	public Course(String name, int courseCredits, int numSeats) {
		this.name = name;
		this.courseCredits = courseCredits;
		this.numSeats = numSeats;
		students = new ArrayList<Student>();
		courseList.add(this);
	}
	
	//getters
	public String getName() {
		return name;
	}
	
	public int getCourseCredits () {
		return courseCredits;
	}
	
	public int getNumSeats () {
		return numSeats;
	}
	
	//setters
	public void setName(String courseName) {
		this.name = courseName;
	}
	
	public void setCourseCredits (int courseCredits) {
		this.courseCredits = courseCredits;
	}
	
	public void setNumSeats (int numSeats) {
		this.numSeats = numSeats;
	}
	
	//behaviors
	public boolean addStudent(Student s) {
		
		if (this.getRemainingSeats() == 0) {
			System.out.println("Sorry, " + s.getName() + ", this class is full.");
			return false;
		}
		
		for (int i = 0; i < students.size(); i++) {
			if (students.get(i).getName().equals(s.getName())) {

				System.out.println(s.getName() + " is already enrolled in the class.");
				return false;
	        }		
	    }
		students.add(s);

		return true;	
	}
	
	public String generateRoster() {
		String myRoster = "";
		for (int i=0; i < students.size(); i++) {
			myRoster = myRoster + students.get(i) + "\n";
		}
		return myRoster;
	}
	
	public int getRemainingSeats() {
		return numSeats - students.size();
	}
	
	public double averageGPA() {
		double gpaSum = 0;
		for (int i=0; i < students.size(); i++) {
			gpaSum = gpaSum + students.get(i).getGPA();
		}
		return gpaSum / students.size();
	}
	
	//add a static method getAllCourses that returns an ArrayList of all courses. 
	public static ArrayList<Course> getAllCourses() {
		return courseList;
	}
	
	//toString
	public String toString() {
		return name + " " + " Credits: " + courseCredits + " Total Seats : " + numSeats; 
	}
	
	public static void main(String[] args) {
		new Course("Java 101", 3, 25);
		new Course("SQL 101", 3, 25);
		new Course("Python 101", 3, 25);

//		Student s1 = new Student("Mary", "Jones", 123);
//		Student s2 = new Student("Tim", "Pip", 456);
		
//		c1.addStudent(s1);
//		c1.addStudent(s2);
//		c3.addStudent(s1);
		
		//print roster
//		System.out.println("Course: " + c1.getName() + "\n" + c1.generateRoster());
//		System.out.println("Course: " + c2.getName() + "\n" + c2.generateRoster());
//		System.out.println("Course: " + c1.getName() + "\n" + c3.generateRoster());
		
		System.out.println(Course.getAllCourses());

	}

}
