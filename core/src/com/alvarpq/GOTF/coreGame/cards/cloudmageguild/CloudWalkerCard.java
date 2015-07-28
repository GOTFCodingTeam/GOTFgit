package com.alvarpq.GOTF.coreGame.cards.cloudmageguild;
import com.alvarpq.GOTF.coreGame.Element;
import com.alvarpq.GOTF.coreGame.Player;
import com.alvarpq.GOTF.coreGame.cards.UnitCard;
import com.alvarpq.GOTF.coreGame.cards.UnitFactory;
import com.alvarpq.GOTF.coreGame.units.cloudmageguild.CloudWalker;
public class CloudWalkerCard extends UnitCard
{
	public CloudWalker(Player owner)
	{
		super(110201, "Cloud Walker", 1, new Element[]{Element.AIR}, "", owner, new UnitFactory(CloudWalker.class));
	}
}

