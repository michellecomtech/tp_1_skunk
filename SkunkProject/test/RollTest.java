import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class RollTest
{
	private Roll roll;
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
		roll = new Roll(dice);
		
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void test_initialization_of_predictable_roll()
	{

		roll.roll();
		int value = roll.getRollScore();

		assertEquals("first value not 6", 6, value);
	}
	@Test
	public void test_roll_2_of_predictable_roll()
	{

		roll.roll();
		roll.roll();
		assertEquals("second value not 4", 4, roll.getRollScore());
	}
	
	@Test
	public void test_roll_3_of_predictable_roll()
	{

		roll.roll();
		roll.roll();
		roll.roll();
		assertEquals("third value not 2", 2, roll.getRollScore());
	}
	
	@Test
	public void test_roll_3_of_predictable_roll_DoubleSkunk()
	{

		roll.roll();
		roll.roll();
		roll.roll();
		assertEquals("Double Skunk is not true", true, roll.getDoubleSkunk());
	}
	
	@Test
	public void test_roll_4_of_predictable_dice_with_3_rolls()
	{

		roll.roll();
		roll.roll();
		roll.roll();
		roll.roll();
		assertEquals("fourth value not wrapping back to first value 6", 6, roll.getRollScore());
	}
	
	
	@Test(expected=RuntimeException.class)
	public void test_null_initial_int_array()
	{	
		Dice dice = new Dice(null, null);
		dice.roll();
	}

}
