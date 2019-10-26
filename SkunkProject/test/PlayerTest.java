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
	public void test_third_player_of_predictable()
	{
		player = new Player("David", 3);
		
		String name = player.getName();

		assertEquals("the thrid player is not David", "David", name);
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
	public void test_score_of_thrid_player_of_predictable()
	{
		player = new Player("David", 3);
		player.inputScore(28, 3);
		int scoreOfPlayer = player.getScore();
		assertEquals("the score of the thrid player is not 28", 28, scoreOfPlayer);
	}

}
