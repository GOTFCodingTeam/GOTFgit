package com.alvarpq.GOTF.coreGame.cards.cloudmageguild;
import com.alvarpq.GOTF.coreGame.Element;
import com.alvarpq.GOTF.coreGame.Player;
import com.alvarpq.GOTF.coreGame.cards.UnitCard;
import com.alvarpq.GOTF.coreGame.cards.UnitFactory;
import com.alvarpq.GOTF.coreGame.units.cloudmageguild.AncientZeppelin;
public class AncientZeppelinCard extends UnitCard
{
	public AncientZeppelinCard(Player owner)
	{
		super(110205, "Ancient Zeppelin", 3, new Element[]{Element.AIR, Element.AIR}, "", owner, new UnitFactory(AncientZeppelin.class));
	}
}

