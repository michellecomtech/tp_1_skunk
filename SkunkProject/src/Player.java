
public class Player 
{
	private String playerName;
	private int playerId;
	private int playerScore;
	
	public Player(String playerName, int playerId)
	{
		this.playerName = playerName;
		this.playerId = playerId;
	}
	
	public void inputScore(int playerScore, int playerId)
	{	
		this.playerId = playerId;
		this.playerScore = playerScore;
	}
	
	public int getScore()
	{
		return this.playerScore;
	}
	
	public String getName()
	{
		return this.playerName;
	}
	
	public int getId()
	{
		return this.playerId;
	}	
}