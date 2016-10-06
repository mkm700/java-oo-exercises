import java.util.ArrayList;

public class Course {
	private String name;
	private int courseCredits;
	private int numSeats;
	private ArrayList<Student> students;
	
	//constructor 
	public Course(String name, int courseCredits, int numSeats) {
		this.name = name;
		this.courseCredits = courseCredits;
		this.numSeats = numSeats;
		students = new ArrayList<Student>();
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
	
	//toString
	public String toString() {
		return name + " " + courseCredits; 
	}
	
	public static void main(String[] args) {
//		Student myTest = new Student("Sue", "Jones", 123);
//		Student myTest1 = new Student("Joe", "Smith", 111);
//		Student myTest2 = new Student("Betty", "Lou", 222);
//		Course math101 = new Course("Math 101",3,2);
//		math101.addStudent(myTest);
//		math101.addStudent(myTest1);
//		math101.addStudent(myTest);
//		math101.addStudent(myTest2);
//		System.out.println(math101.generateRoster());
	}

}
