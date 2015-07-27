package com.alvarpq.GOTF.coreGame.units.vorgasminingcorporation;
import com.alvarpq.GOTF.coreGame.units.Coward;
import com.alvarpq.GOTF.coreGame.units.Unit;
public class VorgasEliteUnit extends Unit
{
	public VorgasEliteUnit(int row, int column)
	{
		super("Vorgas' Elite Unit", null, 3, 1, 1, 1, true, new String[]{"Goblin"}, row, column);
		applyEffect(new Coward(this));
	}
}
