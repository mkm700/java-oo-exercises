package quiz;

import java.util.ArrayList;

public class Quiz {
	//has-a
	//questions
	private ArrayList<Question> questions;
	
	//constructor
	public Quiz() {
		questions = new ArrayList<Question>();
	}
	
	//print all questions
	public void printQuestions() {
		if (questions.size() > 0) {
			for (int i=0; i < questions.size(); i++) {
				System.out.println(questions.get(i));
			}
			
		}
		else {
			System.out.println("There are no questions.");
		}
	}
	
	
	//present it to the user
	
	//accept the user's response
	
	//tell them whether their answer was correct or incorrect.
	
	
	

	public static void main(String[] args) {
		//add new fillin question
		//myQuestions.add(new Question("my sample question", "my sample answer"));
		
		
		//print all questions
		//printQuestions();
//		String q1 = "This is my sample question";
//		String a1 = "This is my sample answer";
//		users.add(new User(uname, fname, lname, email, photoLink));
//		myQuestions.add(new Question(q1,a1));
//		System.out.println(q1);
		
		Question q = new Question("Another awesome question", "Another awesome answer");
		questions.add(q);
		System.out.println(q);
		
		
		//create questions
//		new MultChoice("What is Lucy's standard fee for psychiatric help?",
//						"5 cents",
//						"10 cents",
//						"1 dollar",
//						"5 cents",
//						"Free");
//		
//		new MultChoice("What breed of dog is Snoopy?",
//				"Beagle",
//				"Beagle",
//				"Collie",
//				"Golden Retriever",
//				"Corgi");
//		
//		new Question("What does Peppermint Patty call Charlie Brown?",
//				"Chuck");

	}
	
		

}
