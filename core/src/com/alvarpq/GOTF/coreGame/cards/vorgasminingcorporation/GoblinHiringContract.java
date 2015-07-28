package com.alvarpq.GOTF.coreGame.cards.vorgasminingcorporation;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import com.alvarpq.GOTF.coreGame.Element;
import com.alvarpq.GOTF.coreGame.Player;
import com.alvarpq.GOTF.coreGame.Side;
import com.alvarpq.GOTF.coreGame.cards.Card;
import com.alvarpq.GOTF.coreGame.cards.SpellCard;
import com.alvarpq.GOTF.coreGame.cards.UnitCard;
import com.alvarpq.GOTF.coreGame.event.TurnEndedEvent;
import com.alvarpq.GOTF.coreGame.event.TurnEndedListener;
import com.alvarpq.GOTF.requirement.Requirement;
public class GoblinHiringContract extends SpellCard implements TurnEndedListener
{
	public List<Card> hiredGoblins;
	public GoblinHiringContract(Player owner)
	{
		super(110110, "Goblin Hiring Contract", 1, new Element[]{Element.EARTH}, "Goblins with Earth in their cost you play this turn cost 1 resource and 1 Earth less.", owner);
		setRequirements(new Requirement[]{});
		hiredGoblins = new LinkedList<Card>();
	}
	@Override
	public boolean play(Side mySide, Side opponentsSide)
	{
		if(isReady())
		{
			for(Card card:mySide.getDeck().getHand())
			{
				try
				{
					if(card.getElementCost().contains(Element.EARTH)&&card instanceof UnitCard&&Arrays.asList(((UnitCard)card).createUnit(-1, -1).getSubtypes()).contains("Goblin"))
					{
						card.setResourceCost(card.getResourceCost()-1);
						card.getElementCost().remove(Element.EARTH);
					}
				}
				catch(InstantiationException e){e.printStackTrace();}
				catch(IllegalAccessException e){e.printStackTrace();}
				catch(IllegalArgumentException e){e.printStackTrace();}
				catch(InvocationTargetException e){e.printStackTrace();}
				catch(SecurityException e){e.printStackTrace();}
			}
			mySide.listenOnce(this);
			reset();
			return true;
		}
		return false;
	}
	@Override
	public void onTurnEnded(TurnEndedEvent event)
	{
		for(int i=0;i<hiredGoblins.size();i++)
		{
			hiredGoblins.get(i).setResourceCost(hiredGoblins.get(i).getResourceCost()+1);
			hiredGoblins.get(i).getElementCost().add(Element.EARTH);
		}
		hiredGoblins.clear();
	}
}
