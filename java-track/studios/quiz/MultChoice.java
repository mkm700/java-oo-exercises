package quiz;

public class MultChoice extends Question{
	String choiceA;
	String choiceB;
	String choiceC;
	String choiceD;
	
	public MultChoice(String question, String answer, String choiceA, 
			String choiceB, String choiceC, String choiceD ) {
		super(question, answer);
		this.choiceA = choiceA;
		this.choiceB = choiceB;
		this.choiceC = choiceC;
		this.choiceD = choiceD;
	}
	
	//Display choices
	public void displayChoices() {
		System.out.println("A. " + choiceA);
		System.out.println("B. " + choiceB);
		System.out.println("C. " + choiceC);
		System.out.println("D. " + choiceD);
	}
	
}
