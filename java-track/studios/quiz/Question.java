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
	
	//get question title
	public String getQTitle() {
		return this.qTitle;
	}
	
	//get question Answer
	public String getQAnswer() {
		return this.qAnswer;
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
	}



}
