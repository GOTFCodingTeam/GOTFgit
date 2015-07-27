package com.alvarpq.GOTF.coreGame.units.vorgasminingcorporation;
import com.alvarpq.GOTF.coreGame.units.Killer;
import com.alvarpq.GOTF.coreGame.units.Unit;
public class VorgasAssasin extends Unit
{
	public VorgasAssasin(int row, int column)
	{
		super("Vorgas' Assasin", null, 1, 2, 3, 1, true, new String[]{"Goblin"}, row, column);
		applyEffect(new Killer(this));
	}
}
