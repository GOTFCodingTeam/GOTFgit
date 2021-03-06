package com.alvarpq.GOTF.coreGame.cards.cloudmageguild;
import com.alvarpq.GOTF.coreGame.Element;
import com.alvarpq.GOTF.coreGame.Player;
import com.alvarpq.GOTF.coreGame.cards.UnitCard;
import com.alvarpq.GOTF.coreGame.cards.UnitFactory;
import com.alvarpq.GOTF.coreGame.units.cloudmageguild.BrokenZeppelin;
public class BrokenZeppelinCard extends UnitCard
{
	public BrokenZeppelinCard(Player owner)
	{
		super(110207, "Broken Zeppelin", 2, new Element[]{Element.AIR}, "", owner, new UnitFactory(BrokenZeppelin.class));
	}
}

