import edu.princeton.cs.introcs.*;

public class Turn 
{
	private int turnScore;
	private int numberOfRolls;	
	private Roll roll;
	private Player player;
	
	public Turn()
	{
		this.turnScore = 0;
		this.roll= new Roll();
		this.numberOfRolls = 0;
	}
	
	public Turn(Player player, Roll roll)
	{
		this.roll = roll;
		this.player = player; 
	}
	
	public void AddRollScore(int rollScore)
	{
		this.numberOfRolls += 1;
        this.turnScore = this.turnScore + rollScore;
	}
	
	public int getTurnScore()
	{
		return this.turnScore;
	}	
	
	public int getNumberofRolls()
	{
		return this.numberOfRolls;
	}	

}
