package com.alvarpq.GOTF.coreGame.cards.cloudmageguild;
import com.alvarpq.GOTF.coreGame.Element;
import com.alvarpq.GOTF.coreGame.Player;
import com.alvarpq.GOTF.coreGame.cards.UnitCard;
import com.alvarpq.GOTF.coreGame.cards.UnitFactory;
import com.alvarpq.GOTF.coreGame.units.cloudmageguild.ArchMage;
public class ArchMageCard extends UnitCard
{
	public ArchMageCard(Player owner)
	{
		super(110209, "Arch Mage", 5, new Element[]{Element.AIR, Element.AIR}, "", owner, new UnitFactory(ArchMage.class));
	}
}

