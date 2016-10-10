package baseball;

public class Pitcher extends Player {
	//has-a
	//left/right handedness, innings pitched, earned runs, wins, losses
	private boolean isLefty;
	private double inningsPitched;
	private int earnedRuns;
	private int wins;
	private int losses;
	
	//constructor
	public Pitcher(String name, int number, boolean isLefty) {
		super(name, number); 
		this.isLefty = isLefty;
		this.inningsPitched = 0;
		this.earnedRuns = 0;
		this.wins = 0;
		this.losses = 0;
	}
	
	//behaviors
	//pitcher can calculate ERA, print record, toString
	public double calculateEra() {
		//earned runs per 9 innings pitched
		double inningsOver9 = this.inningsPitched / 9.0;
		return this.earnedRuns / inningsOver9;
	}
	
	public String toString() {
		return "Pitcher: " +  this.name + " is lefty: " + this.isLefty + " wins: " + wins + " loses: " + losses;
	}


}
