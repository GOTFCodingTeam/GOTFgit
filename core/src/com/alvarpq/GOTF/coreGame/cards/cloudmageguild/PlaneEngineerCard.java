package com.alvarpq.GOTF.coreGame.cards.cloudmageguild;
import com.alvarpq.GOTF.coreGame.Element;
import com.alvarpq.GOTF.coreGame.Player;
import com.alvarpq.GOTF.coreGame.cards.UnitCard;
import com.alvarpq.GOTF.coreGame.cards.UnitFactory;
import com.alvarpq.GOTF.coreGame.units.cloudmageguild.PlaneEngineer;
public class PlaneEngineerCard extends UnitCard
{
	public PlaneEngineerCard(Player owner)
	{
		super(110203, "Plane Engineer", 2, new Element[]{Element.AIR, Element.AIR}, "", owner, new UnitFactory(PlaneEngineer.class));
	}
}

