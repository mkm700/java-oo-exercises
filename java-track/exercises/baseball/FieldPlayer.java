package baseball;

public class FieldPlayer extends Player {
	//has-a
	//handedness, switch hitter, at bats, hits, position
	private boolean isLefty;
	private boolean isSwitchHitter;
	private int atBats;
	private int hits;
	private String position;
	
	public FieldPlayer(String name, int number, boolean isLefty, 
						boolean isSwitchHitter, String position) {
		super(name, number);
		this.isLefty = isLefty;
		this.isSwitchHitter = isSwitchHitter;
		this.atBats = 0;
		this.hits = 0;
		this.position = position;
	}

	public double calcBattingAvg() {
		return (double) hits / (double) atBats;
	}
	
	public String toString() {
		return super.toString() + " postion: " + position + " Batting Average: "
				+ this.calcBattingAvg();
	}

}
