
public class Student {

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
		if (credits >= 0 && credits < 30) {
			return "Freshman";
		}
		else if (credits >= 30 && credits < 60) {
			return "Sophomore";
		}
		else if (credits >= 60 && credits < 90) {
			return "Junior";
		}
		else if (credits >= 90) {
			return "Senior";
		}
		else return "error";
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
		int credits = getCredits();
		if (credits == 0 ) {
			return 0;
		} 
		else if (credits > 0 && credits <= 15) {
			return 20000.0;
		}
		else if (credits > 15 && credits <= 30) {
			return 40000.0;
		}
		else if (credits > 30 && credits <= 45) {
			return 60000.0;
		}
		else if (credits > 45 && credits <= 60) {
			return 80000.0;
		}
		else if (credits > 60 && credits <= 75) {
			return 100000.0;
		}
		else if (credits > 75 && credits <= 90) {
			return 120000.0;
		}
		else if (credits > 90 && credits <= 105) {
			return 140000.0;
		}
		else {
			return 160000.0;
		}
	}
	
	public Student createLegacy(Student s) {
		Student newStudent = new Student(this.firstName + " " + this.lastName, s.firstName + " " + s.lastName, this.studentId + s.studentId);
		newStudent.gpa = (this.gpa + s.gpa) / 2;
		newStudent.credits = Math.max(this.credits, s.credits);
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
