package com.alvarpq.GOTF.coreGame.units;
import com.alvarpq.GOTF.coreGame.Side;
import com.alvarpq.GOTF.coreGame.board.BoardHalf;
/**
 * This interface defines the different move types a unit can have.
 */
public interface MoveType
{
	public boolean move(Unit unit, int row, int column, Side mySide, Side opponentsSide, Unit[][] mySideUnits);
	/**
	 * The normal move type. Used as default in all units.
	 */
	class Normal implements MoveType
	{
		@Override
		public boolean move(Unit unit, int row, int column, Side mySide, Side opponentsSide, Unit[][] mySideUnits)
		{
			if(unit.getMove()>0&&mySide.getHalf().getUnitAt(row, column)==null&&BoardHalf.isAdjacent(unit.getRow(), unit.getColumn(), row, column))
			{
				unit.changeMove(-1);
				mySideUnits[row][column] = unit;
				mySideUnits[unit.getRow()][unit.getColumn()] = null;
				unit.setRow(row);
				unit.setColumn(column);
				return true;
			}
			return false;
		}
		@Override
		public String toString()
		{
			return "Normal";
		}
	}
	/**
	 * A move type which makes a unit only being able to move to non-adjacent tiles.
	 */
	class NonAdjacent implements MoveType
	{
		@Override
		public boolean move(Unit unit, int row, int column, Side mySide, Side opponentsSide, Unit[][] mySideUnits)
		{
			if(unit.getMove()>0&&mySide.getHalf().getUnitAt(row, column)==null&&!BoardHalf.isAdjacent(unit.getRow(), unit.getColumn(), row, column))
			{
				unit.changeMove(-1);
				mySideUnits[row][column] = unit;
				mySideUnits[unit.getRow()][unit.getColumn()] = null;
				unit.setRow(row);
				unit.setColumn(column);
				return true;
			}
			return false;
		}
		@Override
		public String toString()
		{
			return "Normal";
		}
	}
	/**
	 * A move type which makes a unit unable to move.
	 */
	class Immovable implements MoveType
	{
		@Override
		public boolean move(Unit unit, int row, int column, Side mySide, Side opponentsSide, Unit[][] mySideUnits)
		{
			return false;
		}
		@Override
		public String toString()
		{
			return "Immovable";
		}
	}
}