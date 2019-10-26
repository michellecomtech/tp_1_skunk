import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TurnTest
{
	private Turn turn;
	private Roll roll;


	@Before
	public void setUp() throws Exception
	{
		int[] init_values_of_rolls = new int[]
		{ 6, 4, 2 };
		turn = new Turn();
		
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
	public void test_second_roll_of_predictable()
	{
		turn.AddRollScore(6);
		turn.AddRollScore(4);
		
		assertEquals("turn value of 2 rolls is not 10", 10, turn.getTurnScore());
	}
	
	@Test
	public void test_third_roll_of_predictable()
	{

		turn.AddRollScore(6);
		turn.AddRollScore(4);
		turn.AddRollScore(2);
		
		assertEquals("turn value of 3 rolls is not 12", 12, turn.getTurnScore());
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

}
