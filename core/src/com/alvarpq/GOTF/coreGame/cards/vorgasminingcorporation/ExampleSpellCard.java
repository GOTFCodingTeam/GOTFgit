package com.alvarpq.GOTF.coreGame.cards.vorgasminingcorporation;
import java.util.Arrays;
import com.alvarpq.GOTF.coreGame.Resource;
import com.alvarpq.GOTF.coreGame.Side;
import com.alvarpq.GOTF.coreGame.cards.SpellCard;
import com.alvarpq.GOTF.requirement.Requirement;
import com.alvarpq.GOTF.requirement.RequirementType;
import com.alvarpq.GOTF.requirement.UnitRequirement;
public class ExampleSpellCard extends SpellCard
{
	private UnitRequirement target;
	public ExampleSpellCard()
	{
		super(110101, "Example Spell", 4, Arrays.asList(new Resource[]{Resource.AIR, Resource.EARTH, Resource.FIRE, Resource.WATER}));
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
