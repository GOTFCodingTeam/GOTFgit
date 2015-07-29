package com.alvarpq.GOTF.coreGame.cards.cloudmageguild;
import com.alvarpq.GOTF.coreGame.Element;
import com.alvarpq.GOTF.coreGame.Player;
import com.alvarpq.GOTF.coreGame.cards.UnitCard;
import com.alvarpq.GOTF.coreGame.cards.UnitFactory;
import com.alvarpq.GOTF.coreGame.units.cloudmageguild.ZeppelinMaster;
public class ZeppelinMasterCard extends UnitCard
{
	public ZeppelinMasterCard(Player owner)
	{
		super(110208, "Zeppelin Master", 3, new Element[]{Element.AIR, Element.AIR, Element.AIR}, "", owner, new UnitFactory(ZeppelinMaster.class));
	}
}

