package com.alvarpq.GOTF.coreGame.cards.cloudmageguild;
import com.alvarpq.GOTF.coreGame.Element;
import com.alvarpq.GOTF.coreGame.Player;
import com.alvarpq.GOTF.coreGame.cards.UnitCard;
import com.alvarpq.GOTF.coreGame.cards.UnitFactory;
import com.alvarpq.GOTF.coreGame.units.cloudmageguild.PowerAbsorber;
public class PowerAbsorberCard extends UnitCard
{
	public PowerAbsorberCard(Player owner)
	{
		super(110204, "Power Absorber", 5, new Element[]{Element.AIR, Element.FIRE}, "", owner, new UnitFactory(PowerAbsorber.class));
	}
}

