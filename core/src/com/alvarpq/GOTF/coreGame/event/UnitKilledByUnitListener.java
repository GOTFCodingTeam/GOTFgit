package com.alvarpq.GOTF.coreGame.event;
/**
 * This interface should be implemented by all units which has to know when units are killed by units.
 */
public interface UnitKilledByUnitListener
{
	/**
	 * The function called when a unit is killed by a unit.
	 * @param event the event with information about what happened
	 */
	public void onUnitKilledByUnit(UnitKilledByUnitEvent event);
}
