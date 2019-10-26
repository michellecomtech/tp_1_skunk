
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
		return this.rollScore;
	}
	public void roll()
	{
		dice.roll();
		this.rollScore = dice.getLastRoll();
		this.die1Score = dice.GetDie1();
		this.die2Score = dice.GetDie2();
		
		if (this.rollScore == 2)
		{
			this.doubleSkunk = true;
		}		
		else if (this.rollScore == 3)
		{
			this.skunkDeuce = true;
		}
		else if (this.die1Score == 1 || this.die2Score == 1)
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
