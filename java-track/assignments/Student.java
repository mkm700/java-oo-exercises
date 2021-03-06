
public class Student {
	static double TUITION = 20000.00;
	static int SEMESTER_CREDITS = 15;
	
	private String firstName;
	private String lastName;
	private int studentId;
	private int credits;
	private double gpa;
	
	//constructor
	public Student(String firstName, String lastName, int studentId) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.studentId = studentId;
		this.credits = 0;
		this.gpa = 0;
	}
	
	//getters
	public String getName() {
		return firstName + " " + lastName;
	}
	
	public int getStudentID() {
		return studentId;
	}
	
	public int getCredits() {
		return credits;
	}
	
	public double getGPA() {
		return gpa;
	}
	
	//setters
	public void setName(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public void setStudentID (int id) {
		studentId = id;
	}
	
	public void setCredits(int credits) {
		this.credits = this.credits + credits;
	}
	
	public void setGPA(double gpa) {
		this.gpa = gpa;
	}
	
	//behaviors
	public String getClassStanding() {
		int credits = this.credits;
		if (credits >= 0 && credits < 30) 
			return "Freshman";
		
		if (credits < 60) 
			return "Sophomore";
		
		if (credits < 90) 
			return "Junior";
		
		return "Senior";
		
	}
	
	public void submitGrade(double grade, int credits) {
		double qs = credits * grade;
		double qsTot = this.credits * this.gpa;
		setCredits(credits);
		qsTot = qsTot + qs;
		double gpaNew = qsTot / this.credits;
		gpaNew = (double)Math.round(gpaNew * 1000) / 1000;
		setGPA(gpaNew);
	}

	public double computeTuition() {
			int semesters = this.credits / SEMESTER_CREDITS;
			int creditsLeft = this.credits % SEMESTER_CREDITS;
			return semesters * TUITION + creditsLeft * 1333.33;   //use constant for both
		}
			
//	public Student createLegacy(Student s1, Student s2) {
//		Student newStudent = new Student(s1.firstName + " " + s1.lastName, s2.firstName + " " + s2.lastName, s1.studentId + s2.studentId);
//		newStudent.setGPA( (s1.gpa + s2.gpa) / 2 );					
//		newStudent.setCredits( Math.max(s1.credits, s2.credits) );	
//		return newStudent;
//	}
	
	//Refactor createLegacy so that createLegacy is a static method.
	public static Student createLegacy(Student s1, Student s2) {
		Student newStudent = new Student(s1.firstName + " " + s1.lastName, s2.firstName + " " + s2.lastName, s1.studentId + s2.studentId);
		newStudent.setGPA( (s1.gpa + s2.gpa) / 2 );					
		newStudent.setCredits( Math.max(s1.credits, s2.credits) );	
		return newStudent;		
	}
	
	//toString
	public String toString() {
		return firstName + " " + lastName + " " + studentId;
	}
	
	public static void main(String[] args) {
		Student myTest = new Student("My", "Test", 123);
		myTest.submitGrade(4.0,3);
		myTest.submitGrade(3.0,1);
		myTest.submitGrade(2.0,3);
		myTest.submitGrade(2.0,4);
		System.out.println(myTest.computeTuition());

	}

}
