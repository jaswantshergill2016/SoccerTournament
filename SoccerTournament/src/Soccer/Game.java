package Soccer;
public class Game {
	public String name;
	
	public Team team1;
	public Team team2;
	
	
	public String result;
	
	public Game() {
		
	}
	
	public Game(String name, Team team1, Team team2) {
		this.name = name;
		this.team1 = team1;
		this.team2 = team2;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Team getTeam1() {
		return team1;
	}


	public void setTeam1(Team team1) {
		this.team1 = team1;
	}


	public Team getTeam2() {
		return team2;
	}


	public void setTeam2(Team team2) {
		this.team2 = team2;
	}


	public String getResult() {
		return result;
	}


	public void setResult(String result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return name +" "+team1.getName()+" v/s "+team2.getName();
	}
	
	
	
	
}
