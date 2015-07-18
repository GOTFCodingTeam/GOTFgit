package com.alvarpq.GOTF.coreGame;
import java.util.LinkedList;
import java.util.List;
import com.alvarpq.GOTF.coreGame.board.BoardHalf;
import com.alvarpq.GOTF.coreGame.cards.Card;
import com.alvarpq.GOTF.coreGame.cards.Deck;
public class Side
{
	private BoardHalf half;
	private Deck deck;
	private int maximumThreshold, threshold;
	private List<Resource> maximumResources, resources;
	private boolean hasSacrificed;
	private Player owner;
	private Game game;
	
	
	public Side(BoardHalf half, Deck deck)
	{
		this.half = half;
		this.deck = deck;
		maximumThreshold = 0;
		threshold = 0;
		maximumResources = new LinkedList<Resource>();
		resources = new LinkedList<Resource>();
		hasSacrificed = false;
	}
	
	public void setParentGame(Game g)
	{
		game = g;
	}
	
	public Game getParentGame()
	{
		return game;
	}
	public void resetResources()
	{
		threshold = maximumThreshold;
		resources = new LinkedList<Resource>(maximumResources);
		hasSacrificed = false;
	}
	
	//Call when user sacrifices for cards
	public boolean sacrificeForCards(int indexInHand)
	{
		if(!hasSacrificed)
		{
			deck.discardCard(indexInHand);
			deck.drawCards(2);
			hasSacrificed = true;
			return true;
		}
		return false;
	}
	
	//Call when user sacrifices for cards
	public boolean sacrificeForCards(Card card)
	{
		if(!hasSacrificed)
		{
			deck.discardCard(card);
			deck.drawCards(2);
			hasSacrificed = true;
			return true;
		}
		return false;
	}
	
	//Call when user sacrifices for resources
	public boolean sacrificeForResources(int indexInHand, Resource resource)
	{
		if(!hasSacrificed&&deck.getHand().get(indexInHand).getResourceCost().contains(resource))
		{
			deck.discardCard(indexInHand);
			maximumThreshold++;
			threshold++;
			maximumResources.add(resource);
			resources.add(resource);
			hasSacrificed = true;
			return true;
		}
		return false;
	}
	
	//Call when user sacrifices for cards
	public boolean sacrificeForResources(Card card, Resource resource)
	{
		if(!hasSacrificed&&card.getResourceCost().contains(resource)&&deck.discardCard(card))
		{
			maximumThreshold++;
			threshold++;
			maximumResources.add(resource);
			resources.add(resource);
			hasSacrificed = true;
			return true;
		}
		return false;
	}
	
	//Call when user presses a card to play it, in order to see if sufficient resources exist
	public boolean hasResources(int indexInHand)
	{
		if(threshold>=deck.getHand().get(indexInHand).getThresholdCost())
		{
			List<Resource> tempResources = new LinkedList<Resource>(resources);
			for(Resource resource:deck.getHand().get(indexInHand).getResourceCost())
			{
				if(tempResources.contains(resource))
				{
					tempResources.remove(resource);
				}
				else
				{
					return false;
				}
			}
			return true;
		}
		return false;
	}
	
	//Call when user presses a card to play it, in order to see if sufficient resources exist
	public boolean hasResources(Card card)
	{
		if(deck.getHand().contains(card)&&threshold>=card.getThresholdCost())
		{
			List<Resource> tempResources = new LinkedList<Resource>(resources);
			for(Resource resource:card.getResourceCost())
			{
				if(tempResources.contains(resource))
				{
					tempResources.remove(resource);
				}
				else
				{
					return false;
				}
			}
			return true;
		}
		return false;
	}
	
	//Do not call unless you know what you are doing. But you can't know what your doing unless you call it. So there.
	public boolean payForCard(int indexInHand)
	{
		if(threshold>=deck.getHand().get(indexInHand).getThresholdCost())
		{
			List<Resource> tempResources = new LinkedList<Resource>(resources);
			for(Resource resource:deck.getHand().get(indexInHand).getResourceCost())
			{
				if(tempResources.contains(resource))
				{
					tempResources.remove(resource);
				}
				else
				{
					return false;
				}
			}
			threshold-=deck.getHand().get(indexInHand).getThresholdCost();
			resources = tempResources;
			return true;
		}
		return false;
	}
	
	//Do not call unless you know what you are doing. See above.
	public boolean payForCard(Card card)
	{
		if(deck.getHand().contains(card)&&threshold>=card.getThresholdCost())
		{
			List<Resource> tempResources = new LinkedList<Resource>(resources);
			for(Resource resource:card.getResourceCost())
			{
				if(tempResources.contains(resource))
				{
					tempResources.remove(resource);
				}
				else
				{
					return false;
				}
			}
			threshold-=card.getThresholdCost();
			resources = tempResources;
			return true;
		}
		return false;
	}
	
	public BoardHalf getHalf()
	{
		return half;
	}
	
	public Deck getDeck()
	{
		return deck;
	}
	
	public int getMaximumThreshold()
	{
		return maximumThreshold;
	}
	
	public int getThreshold()
	{
		return threshold;
	}
	
	public List<Resource> getMaximumResources()
	{
		return maximumResources;
	}
	
	public List<Resource> getResources()
	{
		return resources;
	}
	
	public Player getOwner()
	{
		return owner;
	}
}