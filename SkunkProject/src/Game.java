
public class Game 
{
	private static int gameGoal;
	private Player[] players;
	private Turn turn;
	private Kitty kitty;
	private int[] playerIds;
	private int numberOfPlayers;
	private boolean alive = true;

	public Game()
	{
		this.gameGoal = 100;
		this.numberOfPlayers = 1;
		this.players = new Player[numberOfPlayers];
		int[] playerIds = new int[numberOfPlayers];
	}
	
	public Game(int numberOfPlayers)
	{
		this.numberOfPlayers = numberOfPlayers;
	}
	
	public Game(Player[] players)
	{
		this.players = players;
	}
	
	//public static int[] gameWinner(Player[] players)
	//{
	//	int[] winnerData = new int[2];
	//	winnerData[0] = gameGoal;
	//	for (int i = 0; i < players.length; i++)
	//	{
	//		if()
	//	}
		
	
	public void aliveChange()
	{
		this.alive = false;
	}
	
	public boolean getAlive()
	{
		return this.alive;
	}
	
	public void aTurnFirstRoll(Player player, Turn turn)
	{
		//Turn turn = new Turn(player);
		turn.firstRoll(player);
		this.alive = turn.getAlive();
	}
	
	public void aTurnNextRoll(Player player, boolean alive, Turn turn)
	{
		//Turn turn = new Turn(player);
		turn.aRoll(player, alive);
		this.alive = turn.getAlive();
	}	
	
	
	//public void Switch()
	//{
	//	int currentId = players[]
	//	this.aTurn();
	//}
	
	//
	
	
	
	
}




