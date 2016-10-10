package baseball;

import java.util.ArrayList;

public class Team {
	//has-a
	private String name;
	private ArrayList<Player> roster;
	private int wins;
	private int losses;
	private int totalSalary;
	
	//constructor
	
	//behaviors
	//sign players, trade a palyer, trade for a player, start a new ??, 
	//list players, play a game

	public void signPlayer(String name, int number, int salary, boolean isLefty) {
		//adding pitcher
		Pitcher p = new Pitcher(name, number,lefty);
		//p.sign(this,salary);
		addPlayer(p);
	}
	
	public void signPlayer(String name, int number, int salary, boolean isLefty, boolean isSwitchHitter, String position) {
		FieldPlayer p = new Player(name, number, salary, isLefty, isSwitchHitter, position);
		//p.sign(this,salary);
		addPlayer(p);
	}
	
	
	public void tradePlayer(Player p) {
		if(roster.remove(p)) {
			System.out.println("removed player");
			this.totalSalary -= p.getSalary();
		}
		else {
			System.out.println("player wasn't on team");
		}
	}
	
	public void tradeForPlayer() {
		addPlayer (p, p.getSalary());
	}
	
	public void addPlayer(Player p, int salary) {
		p.sign(this, salary);
		roster.add(p);
		
	}
	
	public void playGame() {
		
	}
	
	public void newSeason() {
		
	}
	
	public void listRoster() {
		
	}
	
	
	
	public static void main(String[] args) {
		//create a new team
		Team cards = newTeam("Cardinals");
		//sign players
		cards.signPlayer("Yadi", 4, 1500000, false, false, "Catcher");
		cards.signPlayer("Wainwright", 50, 1950000, false);
		cards.playGame(true);
		System.out.println(cards);
		//print roster
		cards.listRoster();
		

	}

}
