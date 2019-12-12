
public class Turn 
{
	private int turnScore;	
	private int rollNumber;
	private Roll roll;
	private int[] die1s;
	private int[] die2s;
	private UI ui;
	private Player player;
	private Kitty kitty;
	private boolean alive = true;
	private boolean predictible = false;
	
	public Turn(Player player, Kitty kitty, UI ui)
	{
		this.player = player;
		this.kitty = kitty;
		this.roll = new Roll();
		this.ui = ui;
		this.turnScore = 0; 
		this.rollNumber = 0;
		this.die1s = new int[255];
		this.die2s = new int[255];
	}
	
	public Turn(Player player, Roll roll, Kitty kitty, UI ui)
	{
		this.roll = roll;
		this.player = player;
		this.kitty = kitty;
		this.ui = ui;
		this.turnScore = 0; 
		this.rollNumber = 0;
		this.die1s = new int[255];
		this.die2s = new int[255];
		this.predictible = true;
	}
	
	public void aTurnFirstRoll()
	{	
		//if(!predictible)
		//{
		//	roll.roll();
		//}
		
		roll.roll();
		
		this.rollNumber += 1;
		int firstRoll = roll.getRollScore();
		ui.println("Your Die1 is: " + roll.getDie1());
		ui.println("Your Die2 is: " + roll.getDie2());
		ui.println("The score of the frist roll is: " + firstRoll);
	
		die1s[0] = roll.getDie1();
		die2s[0] = roll.getDie2();
		
		this.AddRollScore(firstRoll);
		
		if (roll.getDoubleSkunk())
		{
			this.alive = false;
			AddRollScore(-firstRoll);
			this.player.setTurnScore(0);
			this.player.setGameScore(0);
			this.player.addChip(-4);
			this.kitty.addChipToKitty(4);
			ui.println("Sorry, your first rOll got a DoubleSkunk! Your turn is over! ");
			ui.println("You lose the entire game score & 4 chips!");
		}
		else if(roll.getSkunkDeuce())
		{
			this.alive = false;
			AddRollScore(-firstRoll);
			this.player.setTurnScore(0);
			this.player.addGameScore(0);
			this.player.addChip(-2);
			this.kitty.addChipToKitty(2);
			ui.println("Sorry, your first rOll got a SkunkDeuce! Your turn is over!");
			ui.println("You lose this turn score & 2 chips!");
		}
		else if(roll.getSkunk())
		{
			this.alive = false;
			AddRollScore(-firstRoll);
			this.player.setTurnScore(0);
			this.player.addGameScore(0);
			this.player.addChip(-1);
			this.kitty.addChipToKitty(1);
			ui.println("Sorry, your first rOll got a Skunk! Your turn is over!");
			ui.println("You lose this turn score & 1 chip!");
		}
		else
		{
			this.player.addTurnScore(firstRoll);
			this.player.addGameScore(firstRoll);
		}
	}
	
	public void aTurnNextRoll()
	{
		roll.roll();
		this.rollNumber += 1;

		die1s[rollNumber - 1] = roll.getDie1();
		die2s[rollNumber - 1] = roll.getDie2();
		
		int rollScore = roll.getRollScore();
		ui.println("Your Die1 is: " + roll.getDie1());
		ui.println("Your Die2 is: " + roll.getDie2());
		ui.println("The score of this roll is: " + rollScore);
		
		if (roll.getDoubleSkunk())
		{
			this.alive = false;
			this.player.setTurnScore(0);
			this.player.setGameScore(0);
			this.player.addChip(-4);
			this.kitty.addChipToKitty(4);
			ui.println("Sorry, you got a DoubleSkunk! Your turn is over!");
			ui.println("You lose the entire game score & 4 chips!");
		}
		else if(roll.getSkunkDeuce())
		{
			this.alive = false;
			this.player.addGameScore(-player.getTurnScore());
			this.player.setTurnScore(0);
			this.player.addChip(-2);
			this.kitty.addChipToKitty(2);
			ui.println("Sorry, you got a SkunkDeuce! Your turn is over!");
			ui.println("You lose this turn score & 2 chips!");
		}
		else if(roll.getSkunk())
		{
			this.alive = false;
			this.player.addGameScore(-player.getTurnScore());
			this.player.setTurnScore(0);
			this.player.addChip(-1);
			this.kitty.addChipToKitty(1);
			ui.println("Sorry, you rOll got a Skunk! Your turn is over!");
			ui.println("You lose this turn score & 1 chip!");
		}
		else
		{
			this.player.addTurnScore(rollScore);
			this.player.addGameScore(rollScore);
			ui.println("Accumulated score of this turn is: " + player.getTurnScore());
			ui.println("Accumulated score of this game is: " + player.getGameScore());
		}
		
	}
	
	public void turnBoard()
	{
		ui.println("-------------------------------------");
		ui.println("<TurnScoreBroad> for Player" + player.getId() + ": " + player.getName());
		ui.println("-------------------------------------");
		ui.println("Roll_#   Die1   Die2   RollScore");
		for (int i = 0; i < rollNumber; i++)
		{ 
			String d1s = String.format("%2d", die1s[i]);
			String d2s = String.format("%2d", die2s[i]);
			String rs = String.format("%2d", die1s[i] + die2s[i]);
			ui.println("Roll#" + (i+1) + "   " + d1s + "     " + d2s + "      " + rs);
		}
		ui.println("-------------------------------------");
		ui.println("TurnScore  GameScore  Chips  Kitty");
		ui.println("   "+ player.getTurnScore() + "          " + player.getGameScore() + "        " + player.getChip() + "      " + kitty.getChipTotal());	
	}
	
	public void AddRollScore(int rollScore)
	{
        this.turnScore += rollScore;
	}
	
	public int getTurnScore()
	{
		return this.turnScore;
	}	
	
	public int getNumberofRolls()
	{
		return this.rollNumber;
	}	

	public boolean getAlive()
	{
		return this.alive;
	}	
}
