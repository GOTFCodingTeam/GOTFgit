package com.alvarpq.GOTF.coreGame.units.vorgasminingcorporation;
import com.alvarpq.GOTF.coreGame.units.Coward;
import com.alvarpq.GOTF.coreGame.units.Haste;
import com.alvarpq.GOTF.coreGame.units.Unit;
public class VorgasClone extends Unit
{
	public VorgasClone(int row, int column)
	{
		super("Vorgas' Clone", null, 1, 2, 1, 1, true, new String[]{"Goblin"}, row, column);
		applyEffect(new Haste(this));
		applyEffect(new Coward(this));
	}
}
