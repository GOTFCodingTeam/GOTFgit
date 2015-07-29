package com.alvarpq.GOTF.coreGame.cards.cloudmageguild;
import com.alvarpq.GOTF.coreGame.Element;
import com.alvarpq.GOTF.coreGame.Player;
import com.alvarpq.GOTF.coreGame.cards.UnitCard;
import com.alvarpq.GOTF.coreGame.cards.UnitFactory;
import com.alvarpq.GOTF.coreGame.units.cloudmageguild.Destroyer;
public class DestroyerCard extends UnitCard
{
	public DestroyerCard(Player owner)
	{
		super(110211, "Destroyer", 4, new Element[]{Element.AIR, Element.AIR, Element.AIR}, "", owner, new UnitFactory(Destroyer.class));
	}
}

