package quiz;

import java.util.ArrayList;
import java.util.Scanner;
import computers.Computer;

public class Quiz {
	//has a: title, list of questions, scanner, total correct response
	private String title;
	private ArrayList<Question> questions;
	private Scanner s;
	static int totalCorrect;
	
	//constructor
	Quiz(String title) {
		this.title = title;
		questions = new ArrayList<Question>();
		s = new Scanner(System.in);
		totalCorrect = 0;
	}
	
	//take the quiz
	public void takeQuiz() {
		for (Question q : questions) {
			q.displayQuestion();
			String r = s.nextLine();
			if(q.compareAnswer(r)) {
				totalCorrect++;
			}
		}
		System.out.print("Thanks for taking the quiz. ");
		System.out.println("You got " + totalCorrect + " out of " + questions.size() + " questions correct!");
	}
	
	//create the quiz questions
	public void createQuestions() {
		Question q1 = new Question("Who is the creator of Peanuts (first and last name?)");
		q1.setAnswer("Charles Schulz");

		MultChoice q2 = new MultChoice("What breed of dog is Snoopy?");
		q2.addChoice("Corgi");
		q2.addChoice("Collie");
		q2.addChoice("Beagle");
		q2.addChoice("Golden Retriever");
		q2.setAnswer("C");
		
		MultChoice q3 = new MultChoice("What is Lucy's standard fee for psychiatric help?");
		q3.addChoice("5 cents");
		q3.addChoice("10 cents");
		q3.addChoice("1 dollar");
		q3.addChoice("Free");
		q3.setAnswer("A");
		
		Question q4 = new Question("What nickname does Peppermint Patty use for Charlie Brown?");
		q4.setAnswer("Chuck");
		
		Question q5 = new Question("Which character has the same name as a famous 60's event?");
		q5.setAnswer("Woodstock");
		
		MultChoice q6 = new MultChoice("Which character lives in the desert near Needles, CA?");
		q6.addChoice("Jorge");
		q6.addChoice("Spike");
		q6.addChoice("The little girl with red hair");
		q6.addChoice("All of the above");
		q6.addChoice("None of the above");
		q6.setAnswer("B");
		
		Question q7 = new Question("True or False: Linus and Lucy's last name is Van Pelt.");
		q7.setAnswer("True");
		
		questions.add(q1);
		questions.add(q2);
		questions.add(q3);
		questions.add(q4);
		questions.add(q5);
		questions.add(q6);
		questions.add(q7);
	}
	
	public static void main(String[] args) {		
		Quiz quiz = new Quiz("Peanuts Trivia");
		quiz.createQuestions();
		quiz.takeQuiz();

	}
	
		

}
