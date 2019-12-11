import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TurnTest
{
	private Turn turn;
	private Roll roll;
	private Player player;
	private Dice dice;
	private Die die1;
	private Die die2;


	@Before
	public void setUp() throws Exception
	{
		int[] init_values_1 = new int[]
		{ 3, 2, 1,};
		int[] init_values_2 = new int[]
		{ 1, 1, 1,};	
		die1 = new Die();
		die2 = new Die();
		die1 = new Die(init_values_1);
		die2 = new Die(init_values_2);
		dice = new Dice();
		dice = new Dice(die1, die2);
		roll = new Roll();
		roll = new Roll(dice);
		player = new Player();
		turn = new Turn(player);
		turn = new Turn(player, roll);		
		int testScore = 0;
		
		
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void test_initialization_of_predictable_first_roll()
	{

		turn.AddRollScore(6);
		int value = turn.getTurnScore();

		assertEquals("turn value of 1 roll is not 6", 6, value);
	}
	
	
	@Test
	public void test_number_of_2_rolls_of_predictable()
	{
		turn.AddRollScore(6);
		turn.AddRollScore(4);
		
		assertEquals("number of 2 rolls is not 2", 2, turn.getNumberofRolls());
	}
	
	@Test
	public void test_number_of_3_rolls_of_predictable()
	{
		turn.AddRollScore(6);
		turn.AddRollScore(4);
		turn.AddRollScore(2);
		
		assertEquals("number of 3 rolls is not 3", 3, turn.getNumberofRolls());
	}
	
	@Test
	public void test_skunk_of_predictable_first_roll()
	{
		roll.roll();
		turn = new Turn(player, roll);
		turn.firstRoll(player);
		int value = turn.getTurnScore();

		assertEquals("turn value of 1 roll is not 0", 0, value);
	}
	
	@Test
	public void test_skunk_deuce_of_predictable_first_roll()
	{
		roll.roll();
		roll.roll();
		turn = new Turn(player, roll);
		turn.firstRoll(player);
		int value = turn.getTurnScore();

		assertEquals("turn value of 1 roll is not 0", 0, value);
	}
	
	@Test
	public void test_double_skunk_of_predictable_first_roll()
	{
		roll.roll();
		roll.roll();
		roll.roll();
		turn = new Turn(player, roll);
		turn.firstRoll(player);
		int value = turn.getTurnScore();

		assertEquals("turn value of 1 roll is not 0", 0, value);
	}
	
	@Test
	public void test_double_skunk_of_predictable_roll()
	{
		roll.roll();
		roll.roll();
		roll.roll();
		turn = new Turn(player, roll);
		turn.aRoll(player, true);
		int value = turn.getTurnScore();

		assertEquals("final turn value of rolls is not 0", 0, value);
	}
	
	@Test
	public void test_skunk_deuce_of_predictable_roll()
	{
		roll.roll();
		roll.roll();
		turn = new Turn(player, roll);
		turn.aRoll(player, true);
		int value = turn.getTurnScore();

		assertEquals("final turn value of rolls is not 0", 0, value);
	}
	
	@Test
	public void test_skunk_of_predictable_roll()
	{
		roll.roll();
		turn = new Turn(player, roll);
		turn.aRoll(player, true);
		int value = turn.getTurnScore();

		assertEquals("final turn value of rolls is not 0", 0, value);
	}
	
	@Test
	public void test_not_alive_of_predictable_roll()
	{
		roll.roll();
		turn = new Turn(player, roll);
		turn.aRoll(player, false);
		int value = turn.getTurnScore();

		assertEquals("final turn value of rolls is not 0", 0, value);
	}
	
	@Test
	public void test_random_of_predictable_first_roll()
	{
		int[] init_values_3 = new int[]
		{ 2, 3 };
		int[] init_values_4 = new int[]
		{ 3, 2 };
		die1 = new Die(init_values_3);
		die2 = new Die(init_values_4);
		dice = new Dice(die1, die2);
		roll = new Roll(dice);
		roll.roll();
		turn = new Turn(player, roll);
		turn.aRoll(player, true);
		int value = turn.getTurnScore();

		assertEquals("final value of rolls is not 5", 5, value);
	}
	
	@Test
	public void test_alive_skunk_of_predictable_first_roll()
	{
		roll.roll();
		turn = new Turn(player, roll);
		turn.firstRoll(player);
		boolean alive = turn.getAlive();

		assertEquals("the boolean alive when getting a skunk of first roll is not false", false, alive);
	}
}
