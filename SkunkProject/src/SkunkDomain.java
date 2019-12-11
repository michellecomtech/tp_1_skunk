import edu.princeton.cs.introcs.*;

import java.util.Scanner;

public class SkunkDomain
{
	public SkunkUI skunkUI;
	public UI ui;
	public Turn turn;
	public Kitty kitty;
	public Player[] players;
	public Scanner scanner;

	//public int numberOfPlayers;
	//public String[] playerNames;
	//public ArrayList<Player> players;


	public Player currentPlayer;
	//public int activePlayerIndex;
	
	public boolean alive;
	public boolean wantsToQuit;
	public boolean oneMoreRoll;

	//public Dice skunkDice;

	public SkunkDomain(SkunkUI ui)
	{
		this.skunkUI = ui;
		this.ui = ui; // hide behind the interface UI
		//this.turn = new Turn();
		this.kitty = new Kitty();
		
		//this.playerNames = new String[20];
		//this.players = new ArrayList<Player>();
		//this.skunkDice = new Dice();
		this.wantsToQuit = false;
		this.oneMoreRoll = false;
	}

	public boolean run()
	{
		ui.println("Merry Christmas!!!");
		ui.println("Welcome to Eric@47's <Game of Skunk!>");	
		scanner = new Scanner(System.in);
		ui.println("Please enter the number of players: ");
		String numberOfPlayers = scanner.nextLine();
		
		this.players = Player.InitializePlayers(Integer.valueOf(numberOfPlayers));
		for(int i = 0; i < Integer.valueOf(numberOfPlayers); i++)
		{
			ui.println("Please enter the name of the player: ");
			players[i].named (scanner.nextLine());
		}
		//scanner.close();
		
		
		ui.println("Let us play! \n");
		
		int currentPlayerId = 0;
		//activePlayer = players.get(activePlayerIndex);
		Player currentPlayer = players[currentPlayerId];
		ui.println("Current player is " + "player" + currentPlayer.getId() + ": " + currentPlayer.getName());
		
		
		this.alive = true;
		
		
		
		turn = new Turn(currentPlayer, kitty, ui);
		turn.aTurnFirstRoll();
		alive = turn.getAlive();
		
		while(alive)
		{
			StdOut.println("Do you want to roll again? (Y) or (N)");	
			String playerDecision = scanner.nextLine();
			if("N".equalsIgnoreCase(playerDecision))
			{
				this.alive = false;
				ui.println("The final score of this turn is: " + turn.getTurnScore());		
			}	
			else if ("Y".equalsIgnoreCase(playerDecision))
			{	
				turn.aTurnNextRoll();
				alive = turn.getAlive();
			}
			else
			{
				ui.println("Invalid Input!");
			}
		}
		currentPlayer.addGameScore(currentPlayer.getTurnScore());
		turn.turnBoard();
		
		return true;
		
	}

	public static void main(String[] args)
	{}

}