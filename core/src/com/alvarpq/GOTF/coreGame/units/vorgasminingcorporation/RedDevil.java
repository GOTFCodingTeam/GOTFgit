package com.alvarpq.GOTF.coreGame.units.vorgasminingcorporation;
import com.alvarpq.GOTF.coreGame.units.Unit;
public class RedDevil extends Unit
{
	public RedDevil(int row, int column)
	{
		super("Red Devil", 1, 1, 1, 1, true, new String[]{"Goblin"}, row, column);
	}

	@Override
	public void update()
	{
	}
}