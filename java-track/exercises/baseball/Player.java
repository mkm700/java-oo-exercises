package baseball;

public class Player {
	//has-a
	protected String name;
	private int number;
	private int salary;
	private String currentTeam;
	
	//behaviors:
	//be created
	//be traded or signed
	
	public Player(String name, int number) {
		this.name = name;
		this.number = number;
		this.salary = 0;
		this.currentTeam = null;
	}
	
	public void trade(Team newTeam) {
		this.update(newTeam);
	}
	
	public void sign() {
		updateTeam(newTeam);
		
	}
	
	public String toString() {
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
