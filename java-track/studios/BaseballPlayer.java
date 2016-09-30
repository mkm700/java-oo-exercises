
public class BaseballPlayer {
	//fields (has-a)
	String name;
	int jerseyNum;
	String hitDir; //left, right, both
	int games;
	int hits;
	int runs;
	int rbis;
	
	//constructor
	public BaseballPlayer  (String name,
							int jerseyNum, 
							String hitDir) {
		this.name = name;
		this.jerseyNum = jerseyNum;
		this.hitDir = hitDir;
		this.games = 0;
		this.hits = 0;
		this.runs = 0;
		this.rbis = 0;
	}
	
	//setters
	public void setGames() {
		this.games = this.games + 1;
	}
	
	public void setHits(int hits) {
		this.hits = this.hits + hits;
	}
	
	public void setRuns(int runs) {
		this.runs = this.runs + runs;
	}
	
	public void setRbis(int rbis) {
		this.rbis = this.runs + rbis;
	}
	
	//behaviors
	public void endGame(int hits, int runs, int rbis) {
		setGames();
		setHits(hits);
		setRuns(runs);
		setRbis(rbis);
	}
	
	public String toString(){
		return  "Name: " + name + "\njerseyNum: " + jerseyNum + 
				"\nHit Direction: " + hitDir + "\nGames: " + games +
				"\nHits: " + hits + "\nRuns: " + runs + "\nRBIs: " + rbis + "\n";
	}
		
	public static void main(String[] args) {
		BaseballPlayer bp1 = new BaseballPlayer("John Doe", 15, "both");
		BaseballPlayer bp2 = new BaseballPlayer("Larry Hamm", 33, "right");
		System.out.println(bp1);
		System.out.println(bp2);
		bp1.endGame(3, 2, 1);
		bp2.endGame(1, 1, 2);
		System.out.println(bp1);
		System.out.println(bp2);
		bp1.endGame(0, 2, 2);
		bp2.endGame(5, 4, 2);
		System.out.println(bp1);
		System.out.println(bp2);
	}

}
