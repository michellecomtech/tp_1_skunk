import edu.princeton.cs.introcs.StdOut;

public class SkunkApp
{

	public static void main(String[] args)
	{
		StdOut.println("Welcome to 635 Skunk!");
		Dice dice1 = new Dice();
		dice1.roll();
		StdOut.println(dice1);

	}

}
