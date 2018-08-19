package Soccer;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

class TestCase {

	@Test
	void test() {
		
		//=============first team============
		Player player1 = new Player("Tom");
		Player player2 = new Player("John");
		
		Coach coach1 = new Coach("Tim");
		Coach coach2 = new Coach("Harry");
		
		Team teamCanada = new Team("Canada");
		
		teamCanada.addPlayer(player1);
		teamCanada.addPlayer(player2);
		
		teamCanada.addCoach(coach1);
		teamCanada.addCoach(coach2);
		
		//=============second team============
		
		Player player3 = new Player("Hardy");
		Player player4 = new Player("Jenny");
		
		Coach coach3 = new Coach("Donald");
		Coach coach4 = new Coach("Horton");
		
		Team teamUsa = new Team("USA");
		
		teamUsa.addPlayer(player3);
		teamUsa.addPlayer(player4);
		
		teamUsa.addCoach(coach3);
		teamUsa.addCoach(coach4);
		
		//=============third team============
		Player player5 = new Player("Chi");
		Player player6 = new Player("Chan");
		
		Coach coach5 = new Coach("Johny");
		
		
		Team teamChina = new Team("China");
		
		teamChina.addPlayer(player5);
		teamChina.addPlayer(player6);
		
		teamChina.addCoach(coach5);
		
		
		//=============Fourth team============
		
		Player player7 = new Player("Ram");
		Player player8 = new Player("Sham");
		
		Coach coach6 = new Coach("Binny");
		
		
		Team teamIndia = new Team("India");
		
		teamIndia.addPlayer(player7);
		teamIndia.addPlayer(player8);
		
		teamIndia.addCoach(coach6);
						
		// ========Adding Teams to tournament==============
		
		Tournament tournament = new Tournament();
		tournament.addTeam(teamCanada);
		tournament.addTeam(teamUsa);
		tournament.addTeam(teamChina);
		tournament.addTeam(teamIndia);
		
		
		//=======creating games in Tournament
		try {
			tournament.createGames();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//Report all game results from a tournament
		tournament.getGameResults();

		assertEquals("","");
		
		
	}

}
