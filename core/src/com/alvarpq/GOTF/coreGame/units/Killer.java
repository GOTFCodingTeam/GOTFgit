package com.alvarpq.GOTF.coreGame.units;
import com.alvarpq.GOTF.coreGame.effect.Permanent;
import com.alvarpq.GOTF.coreGame.event.UnitDamagedByUnitEvent;
import com.alvarpq.GOTF.coreGame.event.UnitDamagedByUnitListener;
public class Killer extends Permanent implements UnitDamagedByUnitListener
{
	public Killer(Unit owner)
	{
		super("Killer", 0, 0, 0, 0, false, owner);
	}
	@Override
	public void onUnitDamagedByUnit(UnitDamagedByUnitEvent event)
	{
		if(event.getDamager()==getOwner())
		{
			event.getOpponentsSide().getHalf().destroyUnit(event.getDamagedUnit());
		}
	}
}
