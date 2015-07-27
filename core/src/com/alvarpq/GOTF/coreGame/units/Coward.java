package com.alvarpq.GOTF.coreGame.units;
import com.alvarpq.GOTF.coreGame.effect.Permanent;
import com.alvarpq.GOTF.coreGame.event.UnitHasAttackedEvent;
import com.alvarpq.GOTF.coreGame.event.UnitHasAttackedListener;
public class Coward extends Permanent implements UnitHasAttackedListener
{
	public Coward(Unit owner)
	{
		super("Coward", 0, 0, 0, 0, false, owner);
	}
	@Override
	public void onUnitHasAttacked(UnitHasAttackedEvent event)
	{
		if(event.getAttackUnit()==getOwner())
		{
			event.getMySide().getHalf().removeUnit(getOwner());
			if(getOwner().getCard()!=null)
			{
				event.getMySide().getDeck().getDiscardPile().remove(getOwner().getCard());
				event.getMySide().getDeck().getHand().add(getOwner().getCard());
			}
		}
	}
}