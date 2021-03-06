package com.alvarpq.GOTF.coreGame.cards.unused;
import com.alvarpq.GOTF.coreGame.Element;
import com.alvarpq.GOTF.coreGame.Player;
import com.alvarpq.GOTF.coreGame.cards.UnitCard;
import com.alvarpq.GOTF.coreGame.cards.UnitFactory;
import com.alvarpq.GOTF.coreGame.units.unused.ProtectorOfWhales;
public class ProtectorOfWhalesCard extends UnitCard
{
	public ProtectorOfWhalesCard(Player owner)
	{
		super(100106, "Protector of Whales", 1, new Element[]{Element.AIR}, "", owner, new UnitFactory(ProtectorOfWhales.class));
	}
}
