import java.util.Scanner;

import edu.princeton.cs.introcs.StdOut;

public class SkunkController 
{
	public SkunkUI skunkUI;
	public UI ui;
	public Turn turn;
	public Kitty kitty;
	public Player[] players;
	public Scanner scanner;	
	public boolean alive;
	public boolean reachTheGoal;
	public boolean finalTurn;
	
	public SkunkController(SkunkUI ui)
	{
		this.skunkUI = ui;
		this.ui = ui; 
		this.kitty = new Kitty();
	}

	public boolean run()
	{
		ui.println("--------------------------------------");
		ui.println("          Merry Christmas!!!");
		ui.println("--------------------------------------");
		ui.println("Welcome to Eric@47's <Game of Skunk>!");
		ui.println("--------------------------------------");
		scanner = new Scanner(System.in);
		ui.println("Please enter the number of players: ");
		String numberOfPlayers = scanner.nextLine();
		
		this.players = Player.InitializePlayers(Integer.valueOf(numberOfPlayers));
		for(int i = 0; i < Integer.valueOf(numberOfPlayers); i++)
		{
			ui.println("Please enter the name of the player: ");
			players[i].named (scanner.nextLine());
		}
		
		ui.println("Let us play!!!");
		ui.println(">>>>>>>>>>>>>>");

		int currentPlayerId = 0;
		this.reachTheGoal = false;
		this.finalTurn = false;
		int finalChance = Integer.valueOf(numberOfPlayers) - 1; 
		int[] winnerScores = new int[Integer.valueOf(numberOfPlayers)];
		int[] winnerIds = new int[Integer.valueOf(numberOfPlayers)];
		int winnerSearch = 0;
		
		while(!reachTheGoal)
		{
			Player currentPlayer = players[currentPlayerId];
			ui.println("Current player is " + "Player" + currentPlayer.getId() + ": " + currentPlayer.getName());
			currentPlayer.setTurnScore(0);
			this.alive = true;
			turn = new Turn(currentPlayer, kitty, ui);
			

			boolean notReady = true;
			
			while(notReady)
			{
				StdOut.println("Try the first roll in your Turn! Are you ready? ([Y]: Yes, I'm ready!) or ([C]:Check Score Board)");
				String playerReady = scanner.nextLine();
				if("C".equalsIgnoreCase(playerReady))
				{
					ui.println("-------------------------------------");
					ui.println("<GameScoreBroad> for All Players");
					ui.println("-------------------------------------");
					ui.println("Kitty has " + kitty.getChipTotal() + " chips!");
					ui.println("-------------------------------------");
					ui.println("PlayerId   GameScore  Chips");
					
				
					for (int i = 0; i < Integer.valueOf(numberOfPlayers); i++)
						ui.println("   " + players[i].getId() + "          " + String.format("%2d", players[i].getGameScore()) + "       " + String.format("%2d", players[i].getChip()));
					StdOut.println("Try the first roll in your Turn! Are you ready? ([Y]: Yes, I'm ready!) or ([N]: No, wait a minute!)");
					String ready = scanner.nextLine();
					if("Y".equalsIgnoreCase(ready))
					{	
						notReady = false;
						turn.aTurnFirstRoll();
					}
				}
					
				else if("Y".equalsIgnoreCase(playerReady))
				{
					notReady = false;
					turn.aTurnFirstRoll();
				}
				else
				{
					ui.println("Invalid Input!");
				}	
			}
			

			
			alive = turn.getAlive();
			
			while(alive)
			{
				StdOut.println("Do you want to roll again? [Y] or [N]");	
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
			turn.turnBoard();
			

			
			if(currentPlayer.getGameScore() >= 100 || finalTurn)
			{
				this.finalTurn = true;
				
				winnerScores[winnerSearch] = currentPlayer.getGameScore();
				winnerIds[winnerSearch] = currentPlayer.getId();
				
				if(finalChance == Integer.valueOf(numberOfPlayers) - 1)
				{
					ui.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
					ui.println("CAUTION! The accumulated game score of Player" + currentPlayer.getId() + "(" + currentPlayer.getName() + ") is already " +  currentPlayer.getGameScore() + "!");
					ui.println("All other players only receive a final turn to better it!");
					ui.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
					finalChance -= 1;
				}

				if(winnerSearch == Integer.valueOf(numberOfPlayers) - 1)
				{
					this.reachTheGoal = true;
				}
				winnerSearch += 1;
				
			}
			else
			{
				ui.println("Pass to Next Player >>>>>>");
			}
			
			currentPlayerId += 1;
			if(currentPlayerId == Integer.valueOf(numberOfPlayers))
			{
				currentPlayerId = currentPlayerId % (Integer.valueOf(numberOfPlayers));
			}
		}
		
		int winnerGoal = 100;
		int winnerId = 0;
		int [] badPlayerIds = new int[winnerSearch - 1];
		int badPlayerIndex = 0;
		
		for (int i = 0; i < winnerSearch; i++)
		{
			if(winnerScores[i] >= winnerGoal)
			{
				winnerGoal = winnerScores[i];
				winnerId = winnerIds[i];
			}
			
			else if(winnerScores[i] == 0)		
			{
				badPlayerIds[badPlayerIndex] = winnerIds[i]; 
				badPlayerIndex += 1;
			}
		}
		
		
		Player winner = players[winnerId - 1];
		
		int collectChips = 0;
		
		for(int i = 0; i < Integer.valueOf(numberOfPlayers); i++)
		{
			if(players[i].getId() != winner.getId())
			{
				players[i].addChip(-5);
				collectChips += 5;
			}
			
			for(int j = 0; j < badPlayerIndex; j++)
			{
				if(players[i].getId() == badPlayerIds[j])
				{
					players[i].addChip(-5);
					collectChips += 5;
				}
			}
		}
		
		collectChips += kitty.getChipTotal(); 		
		winner.addChip(collectChips);
		
		ui.println("------------------------------------------------");
		ui.println("Congratulation! Player" + winner.getId() + " (" + winner.getName() + ") is the winner!!!");
		ui.println("------------------------------------------------");
		ui.println("Winner collects all chips in Kitty!");
		ui.println("Plus 5 chips from each losing player!");
		ui.println("Plus 5 more chips from any player of 0 score!");
		ui.println("------------------------------------------------");
		ui.println("The Winner's total chips in this game is " + winner.getChip() + "!");
		ui.println("----------Great Job! End of the game!-----------");
		ui.println("---------------------Enjoy!---------------------");
		
		return true;		
	}

	public static void main(String[] args)
	{
		
	}

}
