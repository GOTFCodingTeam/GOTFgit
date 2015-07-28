package com.alvarpq.GOTF.coreGame.event;
import com.alvarpq.GOTF.coreGame.Side;
import com.alvarpq.GOTF.coreGame.units.Unit;
/**
 * For handling when units have attacked.
 */
public class UnitHasAttackedEvent extends Event
{
	/**
	 * The attacker.
	 */
	private Unit attacker;
	/**
	 * Instantiates a new UnitHasAttackedEvent.
	 * @param damagedUnit the unit that has been damaged
	 * @param mySide the side of the event receiver
	 * @param opponentsSide the opponents side of the event receiver
	 */
	public UnitHasAttackedEvent(Unit attacker, Side mySide, Side opponentsSide)
	{
		super(mySide, opponentsSide);
		this.attacker = attacker;
	}
	/**
	 * Returns the attacker.
	 * @return the attacker
	 */
	public Unit getAttacker()
	{
		return attacker;
	}
}