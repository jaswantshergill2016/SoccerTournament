package Soccer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Tournament {
	
	public String name;
	
	boolean firstTime=true;
	boolean firstTimeCreateGames= true;
	
	public ArrayList<Team> teams = new ArrayList<>();
	public ArrayList<Game> games = new ArrayList<>();
	
	public void createGames() throws IOException{
		if(teams.size() > 1) {
			int j;
			if(firstTimeCreateGames) {
				j=1;
				firstTimeCreateGames=false;
			}else {
				j=games.size()+1;
			}
			for(int i=0;i<teams.size();i+=2,j++) {
				games.add(new Game("Game"+j,teams.get(i),teams.get(i+1)));
				System.out.println(games.get(j-1));
				
			}
			setResults4GamesPlayed();
		}
		
	}
	
	public void setResults4GamesPlayed() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int j=0;
		int k=1;
		if(firstTime) {
			j=0;
			k=1;
			firstTime=false;
		}else {
			j=games.size()-1;
			k=games.size();
		}
		for(int i=0;i<teams.size();i+=2,j++,k++) {
			System.out.println("Please enter winner of the Game"+k);
			String gameResult = br.readLine();
			games.get(j).setResult(gameResult);
		}
		
		//add winner team in next round
		addWinnerTeamsInNextRound();
	}
	
	public void addWinnerTeamsInNextRound() throws IOException {
		if(teams.size() >2) {
			teams.removeAll(teams);
			
			for(int i=0;i<games.size();i++) {
				Game gamePlayed = games.get(i);
				
				// if game result contains team1 name , then add team1 else add team2
				
				if(gamePlayed.getResult().toLowerCase().contains(gamePlayed.getTeam1().getName().toLowerCase())) {
					teams.add(gamePlayed.getTeam1());
				}else {
					teams.add(gamePlayed.getTeam2());
				}
			}
			//calling createGames() again to create games in next round
			createGames();
		}
	}
	
	
	public void addGame(Game game) {
		games.add(game);
	}
	
	public void addTeam(Team team) {
		teams.add(team);
	}
	
	public void removeTeam(Team team) {
		teams.remove(team);
	}

	public void getGameResults() {
		System.out.println("===========Tournament game results=============");
		System.out.println("===============================================");
		for(Game game :games) {
			System.out.println(game.getName()+" "+game.getTeam1().getName()+" v/s "+game.getTeam2().getName()+" Game Result : " +game.getResult());
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Team> getTeams() {
		return teams;
	}

	public void setTeams(ArrayList<Team> teams) {
		this.teams = teams;
	}

	public ArrayList<Game> getGames() {
		return games;
	}

	public void setGames(ArrayList<Game> games) {
		this.games = games;
	}
	
	
	
}
