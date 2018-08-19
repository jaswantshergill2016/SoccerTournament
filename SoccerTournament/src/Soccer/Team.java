package Soccer;

import java.util.ArrayList;


public class Team {
	
	public String name;
	
	public ArrayList<Player> players = new ArrayList<>();
	
	public ArrayList<Coach> coaches = new ArrayList<>();
	
	
	public Team(String name) {
		this.name = name;
	}
	
	public void addPlayer(Player player) {
		players.add(player);
	}

	public void addCoach(Coach coach) {
		coaches.add(coach);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}

	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}

	public ArrayList<Coach> getCoaches() {
		return coaches;
	}

	public void setCoaches(ArrayList<Coach> coaches) {
		this.coaches = coaches;
	}

	@Override
	public String toString() {
		return "Team [name=" + name + ", players=" + players + ", coaches=" + coaches + "]";
	}
	
	
	
}
