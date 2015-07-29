package com.alvarpq.GOTF.coreGame.units.cloudmageguild;
import com.alvarpq.GOTF.coreGame.units.Unit;
public class Destroyer extends Unit
{
	public Destroyer(int row, int column)
	{
		super("Destroyer", null, 7, 2, 6, 1, true, new String[]{"Zeppelin"}, row, column);
	}
}
