import edu.princeton.cs.introcs.StdOut;
import java.util.Scanner;

public class SkunkApp
{
	private static Turn turn;
	private static Roll roll;
	private static Scanner scanner; 
	
	public static void main(String[] args)
	{
		StdOut.println("Welcome to 635 Skunk!");	
		Scanner textScan = new Scanner(System.in);
		StdOut.println("Please enter the name of the player: ");
		String name = textScan.nextLine();
		Player player = new Player(name, 1);
		aTurn(player);
		textScan.close();
	}
	
	private static void aTurn(Player player)
	{
		roll = new Roll();
		turn = new Turn();
		scanner = new Scanner(System.in);
		StdOut.println("Player: " +  player.getName());
		StdOut.println("Your ID is: " +  player.getId());
		roll.roll();
		int firstRoll = roll.getRollScore();
		StdOut.println("Your Die1 is: " + roll.getDie1());
		StdOut.println("Your Die2 is: " + roll.getDie2());
		StdOut.println("The score of the frist roll is: " + firstRoll);
		if (roll.getDoubleSkunk())
		{
			StdOut.println("Sorry, your first rOll got a DoubleSkunk! Your turn is over!");
			StdOut.println("The final score of this turn is: 0");
		}
		else if(roll.getSkunkDeuce())
		{
			StdOut.println("Sorry, your first rOll got a SkunkDeuce! Your turn is over!");
			StdOut.println("The final score of this turn is: 0");
		}
		else if(roll.getSkunk())
		{
			StdOut.println("Sorry, your first rOll got a Skunk! Your turn is over!");
			StdOut.println("The final score of this turn is: 0");
		}
		else
		{
			turn.AddRollScore(firstRoll);
			boolean stop = false;
			while (!stop)
			{
				String playerDecision = null;
				StdOut.println("Do you want to roll again? (Y) or (N)");
				playerDecision = scanner.nextLine();
				if("N".equalsIgnoreCase(playerDecision))
				{
					stop = true;
					StdOut.println("The final score of this turn is: " + turn.getTurnScore());
				}	
				else if ("Y".equalsIgnoreCase(playerDecision))
				{	roll.roll();
					int rollScore = roll.getRollScore();
					StdOut.println("Your Die1 is: " + roll.getDie1());
					StdOut.println("Your Die2 is: " + roll.getDie2());
						if (roll.getDoubleSkunk())
						{
							StdOut.println("Sorry, your got a DoubleSkunk! Your turn is over!");
							StdOut.println("The final score of this turn is: 0");
							break;
						}
						else if(roll.getSkunkDeuce())
						{
							StdOut.println("Sorry, your got a SkunkDeuce! Your turn is over!");
							StdOut.println("The final score of this turn is: 0");
							break;
						}
						else if(roll.getSkunk())
						{
							StdOut.println("Sorry, your first rill got a Skunk! Your turn is over!");
							StdOut.println("The final score of this turn is: 0");
							break;
						}
						else 
						{
							StdOut.println("The score of this roll is: " + rollScore);
							turn.AddRollScore(rollScore);
							StdOut.println("The score of this turn is: " + turn.getTurnScore());
						}
				}
				else 
				{
					StdOut.println("Invalid Input!");
				}
		     }
		}
	}
}
