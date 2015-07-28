package com.alvarpq.GOTF.coreGame.cards.cloudmageguild;
import com.alvarpq.GOTF.coreGame.Element;
import com.alvarpq.GOTF.coreGame.Player;
import com.alvarpq.GOTF.coreGame.cards.UnitCard;
import com.alvarpq.GOTF.coreGame.cards.UnitFactory;
import com.alvarpq.GOTF.coreGame.units.cloudmageguild.SmallPlane;
public class SmallPlaneCard extends UnitCard
{
	public SmallPlaneCard(Player owner)
	{
		super(110204, "Small Plane", 1, new Element[]{Element.AIR}, "", owner, new UnitFactory(SmallPlane.class));
	}
}

