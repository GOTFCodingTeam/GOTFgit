package com.alvarpq.GOTF.coreGame.cards.cloudmageguild;
import com.alvarpq.GOTF.coreGame.Element;
import com.alvarpq.GOTF.coreGame.Player;
import com.alvarpq.GOTF.coreGame.cards.UnitCard;
import com.alvarpq.GOTF.coreGame.cards.UnitFactory;
import com.alvarpq.GOTF.coreGame.units.cloudmageguild.ForgottenHero;
public class ForgottenHeroCard extends UnitCard
{
	public ForgottenHeroCard(Player owner)
	{
		super(110202, "Forgotten Hero", 3, new Element[]{Element.AIR, Element.FIRE}, "", owner, new UnitFactory(ForgottenHero.class));
	}
}

