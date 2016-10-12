package quiz;

import java.util.ArrayList;

public class MultChoice extends Question{
	//has-a
	private ArrayList<String> choices;

	//constructor
	public MultChoice(String question) {
		super(question);
		choices = new ArrayList<String>();
	}
	
	public void addChoice(String choice) {
		choices.add(choice);
	}

	//Display choices
	public void displayQuestion() {
		
		char[] abc = new char[] {'A','B','C','D','E','F'};
		
		super.displayQuestion();

		for (int i=0; i<choices.size(); i++) {
			char choiceLetter = abc[i];
			System.out.println(choiceLetter + ". " + choices.get(i));
		}


	}
	
}
