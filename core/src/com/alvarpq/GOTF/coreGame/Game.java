package com.alvarpq.GOTF.coreGame;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
<<<<<<< HEAD
import com.alvarpq.GOTF.cards.Card;
import com.alvarpq.GOTF.cards.Deck;
=======

>>>>>>> Stuff.
import com.alvarpq.GOTF.coreGame.board.BoardHalf;
import com.alvarpq.GOTF.gui.BoardDraw;
public class Game
{
<<<<<<< HEAD
	/*Gonna fix better instructions for tomorrow on how to use Requirement system*/
	private Map<Player, Side> sides;
	private Player currentPlayer;
	private static final Random random = new Random();
	public Game(Deck deck1, Deck deck2)
	{
		sides = new HashMap<Player, Side>();
		sides.put(Player.PLAYER1, new Side(new BoardHalf(5, 3, 8, Player.PLAYER1), deck1));
		sides.put(Player.PLAYER2, new Side(new BoardHalf(5, 3, 8, Player.PLAYER2), deck2));
		BoardHalf.createBoard(sides.get(Player.PLAYER1).getHalf(), sides.get(Player.PLAYER2).getHalf());
		//currentPlayer = Player.values()[random.nextInt(2)]; temporarily Player1 always start
		currentPlayer = Player.PLAYER1;
=======
	public final BoardHalf half1 = new BoardHalf(5, 3, 8, Player.PLAYER1);
	public final BoardHalf half2 = new BoardHalf(5, 3, 8, Player.PLAYER2);
	Player currentPlayer;
	Player p1=Player.PLAYER1;
	Player p2=Player.PLAYER2;
	private static final Random random = new Random();
	BoardDraw boardDraw;
	public Game()
	{
		BoardHalf.createBoard(half1, half2);
		p1.setBoard(half1);
		p2.setBoard(half2);
		half1.setParentGame(this);
		half2.setParentGame(this);
		currentPlayer = Player.values()[random.nextInt(2)];
		boardDraw=new BoardDraw();
	}
	
	public BoardDraw getBoard(){
		return boardDraw;
>>>>>>> Stuff.
	}
	//Call directly after endTurn
	public void startTurn()
	{
		if(currentPlayer==Player.PLAYER1)
		{
			sides.get(Player.PLAYER1).resetResources();
			sides.get(Player.PLAYER1).getHalf().allCountDown();
			sides.get(Player.PLAYER1).getDeck().drawCards(1);
		}
		else
		{
			sides.get(Player.PLAYER2).resetResources();
			sides.get(Player.PLAYER2).getHalf().allCountDown();
			sides.get(Player.PLAYER2).getDeck().drawCards(1);
		}
	}
	//Call when user presses end turn button
	public void endTurn()
	{
		if(currentPlayer==Player.PLAYER1)
		{
			sides.get(Player.PLAYER1).getHalf().allAttack();
		}
		else
		{
			sides.get(Player.PLAYER2).getHalf().allAttack();
		}
		currentPlayer = currentPlayer.otherPlayer();
	}
	public Player getCurrentPlayer()
	{
		return currentPlayer;
	}
	public void setCurrentPlayer(Player currentPlayer)
	{
		this.currentPlayer = currentPlayer;
	}
	public Side getSide(Player owner)
	{
		return sides.get(owner);
	}
	//Call when user has inputed all needed data to play a card
	public boolean playCard(Player side, int indexInHand)
	{
		if(sides.get(side).getDeck().getHand().get(indexInHand).isReady()&&sides.get(side).payForCard(indexInHand))
		{
			return sides.get(side).getDeck().getHand().get(indexInHand).play(sides.get(side).getHalf(), sides.get(side.otherPlayer()).getHalf());
		}
		return false;
	}
	//Call when user has inputed all needed data to play a card
	public boolean playCard(Player side, Card card)
	{
		if(card.isReady()&&sides.get(side).payForCard(card))
		{
			return card.play(sides.get(side).getHalf(), sides.get(side.otherPlayer()).getHalf());
		}
		return false;
	}
}
