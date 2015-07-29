package com.alvarpq.GOTF.coreGame.cards.cloudmageguild;
import com.alvarpq.GOTF.coreGame.Element;
import com.alvarpq.GOTF.coreGame.Player;
import com.alvarpq.GOTF.coreGame.cards.UnitCard;
import com.alvarpq.GOTF.coreGame.cards.UnitFactory;
import com.alvarpq.GOTF.coreGame.units.cloudmageguild.BigZeppelin;
public class BigZeppelinCard extends UnitCard
{
	public BigZeppelinCard(Player owner)
	{
		super(110206, "BigZeppelin", 3, new Element[]{Element.AIR, Element.AIR}, "", owner, new UnitFactory(BigZeppelin.class));
	}
}

 