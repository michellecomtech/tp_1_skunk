
public class Player 
{
	private String playerName;
	private int playerId;
	private int rollScore;
	private int turnScore;
	private int gameScore;
	private int playerChip;
	
	public Player()
	{	
		this.playerName = "Eric";
		this.playerId = 47;
		this.rollScore = 0;
		this.turnScore = 0;
		this.gameScore = 0;
		this.playerChip = 50;
	}
	public Player(int i)
	{
		this.playerName = "Player_" + String.valueOf(i);
		this.playerId = i;
		this.rollScore = 0;
		this.turnScore = 0;
		this.gameScore = 0;
		this.playerChip = 50;
	}
	
	public Player(String playerName, int playerId)
	{
		this.playerName = playerName;
		this.playerId = playerId;
	}
	
	public static Player[] InitializePlayers(int numberOfPlayers)
	{
		Player[] thePlayers = new Player[numberOfPlayers];
		for(int i = 1; i < thePlayers.length + 1; i++)
		{
			thePlayers[i-1] = new Player(i);
		}
		return thePlayers;
	}
	
	public void named(String name)
	{
		this.playerName = name;
	}
	
	public void setRollScore(int playerScore)
	{	
		this.rollScore = playerScore;
	}
	
	public void setTurnScore(int playerScore)
	{	
		this.turnScore = playerScore;
	}
	
	public void setGameScore(int playerScore)
	{	
		this.gameScore = playerScore;
	}
	
	public void setChip(int chip)
	{	
		//this.playerId = playerId;
		this.playerChip = chip;
	}
		
	public void addRollScore(int playerScore)
	{	
		this.rollScore += playerScore;
	}
	
	public void addTurnScore(int playerScore)
	{	
		this.turnScore += playerScore;
	}
	
	public void addGameScore(int playerScore)
	{	
		this.gameScore += playerScore;
	}
	
	public void addChip(int chip)
	{	
		//this.playerId = playerId;
		this.playerChip += chip;
	}
	
	public String getName()
	{
		return this.playerName;
	}
	
	public int getId()
	{
		return this.playerId;
	}
		
	public int getRollScore()
	{
		return this.rollScore;
	}
	
	public int getTurnScore()
	{
		return this.turnScore;
	}
	
	public int getGameScore()
	{
		return this.gameScore;
	}
	
	public int getChip()
	{
		return this.playerChip;
	}
	

	
}