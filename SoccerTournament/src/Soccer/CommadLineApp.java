package Soccer;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class CommadLineApp {

	public static void main(String[] args) {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String teamSizeStr; 
		int teamSizeInt=0;

		try {
			
			Tournament tournament = new Tournament();

			//============number of teams in tournament=================
			System.out.println("Please enter number of teams in the tournament. Even Number.");
			String noOfTeams = br.readLine();
			int noOfTeamsInt = Integer.parseInt(noOfTeams);
			
			for(int i=1;i<=noOfTeamsInt;i++) {
				//============first team==========================
				System.out.println("Please enter name of team "+i);
				String teamName = br.readLine();
				
				Team team = new Team(teamName);
				
				System.out.println("Please enter team size: int value ");
				teamSizeStr = br.readLine();
				teamSizeInt = Integer.parseInt(teamSizeStr);
				System.out.println("Team size "+teamSizeInt);
				
				for(int j=1; j<=teamSizeInt; j++) {
					System.out.println("Please enter name of player "+j);
					String playerName = br.readLine();
					Player player = new Player(playerName);
					team.addPlayer(player);
				}
				
				System.out.println("Please enter name of coach ");
				String coachName = br.readLine();
				Coach coach = new Coach(coachName);
				team.addCoach(coach);
				
				tournament.addTeam(team);
			}
			
			//=======creating games in Tournament
			tournament.createGames();
			
			
			//Report all game results from a tournament
			tournament.getGameResults();
			
		} catch (Exception e) {
			System.out.println("===Please enter a valid value=======.Restart the program");
			e.printStackTrace();
		}
	}
}

