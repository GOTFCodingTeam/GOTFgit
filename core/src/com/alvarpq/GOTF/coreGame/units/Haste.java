package com.alvarpq.GOTF.coreGame.units;
import com.alvarpq.GOTF.coreGame.effect.Permanent;
import com.alvarpq.GOTF.coreGame.event.UnitCameIntoPlayEvent;
import com.alvarpq.GOTF.coreGame.event.UnitCameIntoPlayListener;
public class Haste extends Permanent implements UnitCameIntoPlayListener
{
	public Haste(Unit owner)
	{
		super("Haste", 0, 0, 0, 0, false, owner);
	}
	@Override
	public void onUnitCameIntoPlay(UnitCameIntoPlayEvent event)
	{
		if(event.getPlayedUnit()==getOwner())
		{
			event.getMySide().getHalf().changeCountdown(getOwner(), -getOwner().getBaseCountdown());
		}
	}
}
