package com.alvarpq.GOTF.coreGame.units.cloudmageguild;
import com.alvarpq.GOTF.coreGame.units.Unit;
public class SmallPlane extends Unit
{
	public SmallPlane(int row, int column)
	{
		super("SmallPlane", null, 1, 2, 2, 1, true, new String[]{"Plane"}, row, column);
	}
}
