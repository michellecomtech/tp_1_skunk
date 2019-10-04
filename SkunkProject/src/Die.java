
public class Die
{
	private int lastRoll;
	private boolean predictible = false;
	private int[] rolls;

	public Die()
	{
		this.roll();
	}

	public Die(int[] predictable_rolls)
	{
		this.predictible = true;
		this.rolls = predictable_rolls;
	}
	
	
	public int getLastRoll() // getter or accessor method
	{

		return this.lastRoll;
	}

	public void roll() // note how this changes Die's state, but doesn't return
						// anything
	{
		if(!predictible)
			this.lastRoll = (int) (Math.random() * 6 + 1);
		else
		{
			this.lastRoll = this.rolls[0];
		}
	}

	@Override
	public String toString() // this OVERRIDES the default Object.toString()
	{
		return "Die: " + this.getLastRoll();
	}

}
