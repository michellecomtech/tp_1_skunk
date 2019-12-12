import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class PlayerTest
{
	private Player player;


	@Before
	public void setUp() throws Exception
	{
		String[] init_values_of_players = new String[]
		{ "Mike", "Joe", "David" };
		player = new Player();
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void test_initialization_of_predictable_first_player()
	{
		player = new Player("Mike", 1);
		
		String name = player.getName();;

		assertEquals("the first player is not Mike", "Mike", name);
	}

	@Test
	public void test_second_player_of_predictable()
	{
		player = new Player("Joe", 2);
		
		String name = player.getName();

		assertEquals("the second player is not Joe", "Joe", name);
	}
	
	@Test
	public void test_change_name_player_of_predictable()
	{
		player = new Player("David", 3);
		player.named("Rob");
		String name = player.getName();

		assertEquals("the thrid player's name is not Rob", "Rob", name);
	}
	
	@Test
	public void test_first_player_Id_of_predictable()
	{
		player = new Player("Mike", 1);
		
		int Id = player.getId();

		assertEquals("the first player's Id is not 1", 1, Id);
	}
	
	@Test
	public void test_second_player_Id_of_predictable()
	{
		player = new Player("Joe", 2);
		
		int Id = player.getId();

		assertEquals("the second player's Id is not 2", 2, Id);
	}
	
	@Test
	public void test_roll_score_of_thrid_player_of_predictable()
	{
		player = new Player(3);
		player.setRollScore(0);
		player.addRollScore(8);
		int scoreOfPlayer = player.getRollScore();
		assertEquals("the score of the thrid player is not 8", 8, scoreOfPlayer);
	}
	
	@Test
	public void test_turn_score_of_thrid_player_of_predictable()
	{
		player = new Player("David", 3);
		player.setTurnScore(0);
		player.addTurnScore(28);
		int scoreOfPlayer = player.getTurnScore();
		assertEquals("the score of the thrid player is not 28", 28, scoreOfPlayer);
	}
	
	@Test
	public void test_game_score_of_thrid_player_of_predictable()
	{
		player = new Player("David", 3);
		player.setGameScore(0);
		player.addGameScore(28);
		int scoreOfPlayer = player.getGameScore();
		assertEquals("the score of the thrid player is not 28", 28, scoreOfPlayer);
	}
	
	@Test
	public void test_add_10_chip_of_player_of_predictable()
	{
		player.setChip(0);
		player.addChip(10);
		int chipOfPlayer = player.getChip();
		assertEquals("the chips of the default player is not 10", 10, chipOfPlayer);
	}
	

	@Test
	public void test_Id1_init_of_3_players_of_predictable()
	{
		Player[] players = player.InitializePlayers(3);
		int playerId1 = players[0].getId();
		assertEquals("the ID of the first player is not 1", 1, playerId1);
	}
	
	@Test
	public void test_name2_init_of_3_players_of_predictable()
	{
		Player[] players = player.InitializePlayers(3);
		String playerName2 = players[1].getName();
		assertEquals("the Name of the second player is not Player2", "Player_2", playerName2);
	}
	
}
