package com.alvarpq.GOTF.coreGame.cards.unused;
import com.alvarpq.GOTF.coreGame.Element;
import com.alvarpq.GOTF.coreGame.Player;
import com.alvarpq.GOTF.coreGame.Side;
import com.alvarpq.GOTF.coreGame.cards.SpellCard;
import com.alvarpq.GOTF.requirement.Requirement;
import com.alvarpq.GOTF.requirement.RequirementType;
import com.alvarpq.GOTF.requirement.UnitRequirement;
public class ExampleSpellCard extends SpellCard
{
	private UnitRequirement target;
	public ExampleSpellCard(Player owner)
	{
		super(100102, "Example Spell", 4, new Element[]{Element.AIR, Element.EARTH, Element.FIRE, Element.WATER}, "", owner);
		target = new UnitRequirement(RequirementType.UNIT);
		setRequirements(new Requirement[]{target});
	}
	@Override
	public boolean play(Side mySide, Side opponentsSide)
	{
		if(isReady())
		{
			opponentsSide.getHalf().damage(target.getUnit(), 5, null);
			reset();
			return true;
		}
		return false;
	}
}
