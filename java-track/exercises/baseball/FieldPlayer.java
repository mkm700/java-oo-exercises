package baseball;

public class FieldPlayer extends Player {
	//has-a
	//handedness, switch hitter, at bats, hits, position
	private int atBats;
	private int hits;
	private int homeRuns;
	
	public FieldPlayer(String name, int number) {
		super(name, number);
		this.atBats = 0;
		this.hits = 0;
		this.homeRuns = 0;
	}

	public double calcBattingAvg() {
		return (double) hits / (double) atBats;
	}
	
	public void simulateAtBat() {
		double r = Math.random();
		if (r <= 0.3) {				//avg batting average .300
			this.hits++;
			if(r<.015) {
				this.homeRuns++;
			}
		}
	}
	
	public String toString() {
		return super.toString() + " Batting Average: "
				+ this.calcBattingAvg();
	}
	
	public static void main(String[] args) {
		FieldPlayer fp = newFieldPlayer("Matt Holliday", 7);
		Team cards = new Team("Cardinals");
		for(int i=0;i<400:i++) {
			fp.simulateAtBat();
		}
	}

}
