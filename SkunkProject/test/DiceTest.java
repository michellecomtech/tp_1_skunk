import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class DiceTest
{
	private Dice dice;
	private Die die1;
	private Die die2;
	

	@Before
	public void setUp() throws Exception
	{
		int[] init_values = new int[]
		{ 3, 2, 1 };
		die1 = new Die(init_values);
		die2 = new Die(init_values);
		dice = new Dice(die1, die2);
		
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void test_initialization_of_predictable_dice()
	{

		dice.roll();
		int value = dice.getLastRoll();

		assertEquals("first value not 6", 6, value);
	}
	@Test
	public void test_roll_2_of_predictable_dice()
	{

		dice.roll();
		dice.roll();
		assertEquals("second value not 4", 4, dice.getLastRoll());
	}
	
	@Test
	public void test_roll_3_of_predictable_dice()
	{

		dice.roll();
		dice.roll();
		dice.roll();
		assertEquals("third value not 2", 2, dice.getLastRoll());
	}
	
	@Test
	public void test_roll_4_of_predictable_dice_with_3_rolls()
	{

		dice.roll();
		dice.roll();
		dice.roll();
		dice.roll();
		assertEquals("fourth value not wrapping back to first value 6", 6, dice.getLastRoll());
	}
	
	@Test
	public void test_roll_5_of_predictable_dice_with_3_rolls()
	{

		dice.roll();
		dice.roll();
		dice.roll();
		dice.roll();
		dice.roll();
		assertEquals("fifth value not wrapping back to second value 4", 4, dice.getLastRoll());
	}

}
