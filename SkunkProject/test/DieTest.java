import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DieTest
{

	@Before
	public void setUp() throws Exception
	{
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void test_initialization_of_predictable_die()
	{
		int[] init_values = new int[]
		{ 3, 2, 1 };
		Die die = new Die(init_values);
		die.roll();
		int value = die.getLastRoll();

		assertEquals("first value not 3", 3, value);
	}

}
