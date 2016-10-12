package quiz;

public class Question {
	//has-a
	private String qTitle;
	private String qAnswer;
	
	//constructor
	public Question(String qTitle) {
		this.qTitle = qTitle;
		this.qAnswer = "";
	}
	
	//set answer
	public void setAnswer(String correctResponse) {
		this.qAnswer = correctResponse;
	}

	//compareAnswer
	public boolean compareAnswer(String response) {
		if (this.qAnswer.equalsIgnoreCase(response)) {
			System.out.println("Correct!\n");
			return true;
		}
		else {
			System.out.println("No, the correct answer is " + this.qAnswer + "\n");
			return false;
		}
	}
	
	//display question title
	public void displayQuestion() {
		System.out.println(qTitle);
	}
		
	//toString
	public String toString() {
		return qTitle + "\n" + qAnswer;
		return question + "\n" + answer;
	}

	public static void main(String[] args) {
		Question q = new Question("My awesome question", "My awesome answer");
		System.out.println(q);
	}


}
