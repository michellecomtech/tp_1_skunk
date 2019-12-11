
public class Roll 
{ 
	private int rollScore;
	private int die1Score;
	private int die2Score;
	private Dice dice;
	private boolean skunk = false;
	private boolean skunkDeuce = false;
	private boolean doubleSkunk = false;
	
	public Roll()
	{
		this.dice = new Dice();	
	}
	public int getRollScore()
	{
		return rollScore;
	}
	
	public Roll(Dice dice)
	{
		this.dice = dice;
	}
	
	public void roll()
	{	
		dice.roll();
		this.rollScore = dice.getLastRoll();
		this.die1Score = dice.getDie1();
		this.die2Score = dice.getDie2();
		if(rollScore == 2)
		{
			this.doubleSkunk = true;
		}		
		else if (rollScore == 3)
		{
			this.skunkDeuce = true;
		}
		else if (die1Score == 1 || die2Score == 1)
		{
			this.skunk = true;
		}
	}
	
	public int getDie1()
	{
		return this.die1Score;
	}
	
	public int getDie2()
	{
		return this.die2Score;	
	}
	
	public boolean getSkunk()
	{
		return this.skunk;
	}
	
	public boolean getSkunkDeuce()
	{
		return this.skunkDeuce;
	}
	
	public boolean getDoubleSkunk()
	{
		return this.doubleSkunk;
	}
	
	public String toString()
	{
		return "The Score of this Roll: " + getRollScore();
	}
}
