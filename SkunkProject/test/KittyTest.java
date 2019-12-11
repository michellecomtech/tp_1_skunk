import static org.junit.Assert.*;

import org.junit.Test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class KittyTest
{
	private Kitty kitty ;


	@Before
	public void setUp() throws Exception
	{
		int[] init_values = new int[]
		{ 10, 20, 30};
		kitty = new Kitty();
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void test_initialization_of_predictable_add_10()
	{
		kitty.addChipToKitty(10);
		
		int chips = kitty.getChipTotal();

		assertEquals("the total chips in Kitty is not 10", 10, chips);
	}

	@Test
	public void test_add_20_of_predictable()
	{
		kitty.addChipToKitty(10);
		kitty.addChipToKitty(20);
		
		int chips = kitty.getChipTotal();

		assertEquals("the total chips in Kitty is not 30", 30, chips);
	}
	
	@Test
	public void test_add_30_of_predictable()
	{
		kitty.addChipToKitty(10);
		kitty.addChipToKitty(20);
		kitty.addChipToKitty(30);
		
		int chips = kitty.getChipTotal();

		assertEquals("the total chips in Kitty is not 60", 60, chips);
	}
	
	@Test
	public void test_remove_10_of_predictable()
	{
		kitty.addChipToKitty(10);
		kitty.addChipToKitty(20);
		kitty.addChipToKitty(30);
		kitty.removeChipFromKitty(10);
		
		int chips = kitty.getChipTotal();

		assertEquals("the total chips in Kitty is not 50", 50, chips);
	}
	
	@Test
	public void test_remove_all_of_predictable()
	{
		kitty.addChipToKitty(10);
		kitty.addChipToKitty(20);
		kitty.addChipToKitty(30);
		int allChip = kitty.getChipTotal();
		kitty.removeChipFromKitty(allChip);
		int chips = kitty.getChipTotal();

		assertEquals("the total chips in Kitty is not 0", 0, chips);
	}

}


