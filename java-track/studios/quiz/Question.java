package quiz;

public class Question {
	//has-a
	//question
	//answer
	private String question;
	private String answer;
	
	//constructor
	public Question(String question, String answer) {
		this.question = question;
		this.answer = answer;
	}

	//display the question
	public void displayQuestion() {
		System.out.println(question);
	}
	
	//Check for correct answer
	

		
	//toString
	public String toString() {
		return question + "\n" + answer;
	}


	public static void main(String[] args) {
		Question q1 = new Question("my first question", "my first answer");
		System.out.println(q1);
	}

}