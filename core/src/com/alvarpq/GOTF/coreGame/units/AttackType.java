package com.alvarpq.GOTF.coreGame.units;
import com.alvarpq.GOTF.coreGame.Side;
import com.alvarpq.GOTF.coreGame.event.UnitDamagedByUnitEvent;
import com.alvarpq.GOTF.coreGame.event.UnitDamagedEvent;
import com.alvarpq.GOTF.coreGame.event.UnitKilledByUnitEvent;
public interface AttackType
{
	public static final Normal NORMAL = new Normal();
	public static final Relentless RELENTLESS = new Relentless();
	public static final NoAttack NO_ATTACK = new NoAttack();
	public void attack(Unit unit, Side mySide, Side opponentsSide);
	class Normal implements AttackType
	{
		@Override
		public void attack(Unit unit, Side mySide, Side opponentsSide)
		{
			boolean unitHit = false;
			for(int i=0;i<opponentsSide.getHalf().numberOfColumns();i++)
			{
				if(opponentsSide.getHalf().getUnitAt(unit.getRow(), i)!=null)
				{
					opponentsSide.getHalf().getUnitAt(unit.getRow(), i).damage(unit.getAttack());
					mySide.getHalf().dispatchEvent(new UnitDamagedByUnitEvent(opponentsSide.getHalf().getUnitAt(unit.getRow(), i), unit, unit.getAttack(), mySide, opponentsSide));
					mySide.getHalf().dispatchEvent(new UnitDamagedEvent(opponentsSide.getHalf().getUnitAt(unit.getRow(), i), unit.getAttack(), mySide, opponentsSide));
					if(opponentsSide.getHalf().getUnitAt(unit.getRow(), i).getHealth()<=0)
					{
						mySide.getHalf().dispatchEvent(new UnitKilledByUnitEvent(opponentsSide.getHalf().getUnitAt(unit.getRow(), i), unit, mySide, opponentsSide));
					}
					unitHit = true;
					break;
				}
			}
			if(!unitHit)
			{
				opponentsSide.getHalf().setIdol(unit.getRow(), opponentsSide.getHalf().getIdolAt(unit.getRow())-unit.getAttack());
				if(opponentsSide.getHalf().getIdolAt(unit.getRow())<0)
				{
					opponentsSide.getHalf().setIdol(unit.getRow(), 0);
				}
			}
		}
		@Override
		public String toString()
		{
			return "Normal";
		}
	}
	class Relentless implements AttackType
	{
		@Override
		public void attack(Unit unit, Side mySide, Side opponentsSide)
		{
			int attackLeft = unit.getAttack();
			for(int i=0;i<opponentsSide.getHalf().numberOfColumns();i++)
			{
				if(opponentsSide.getHalf().getUnitAt(unit.getRow(), i)!=null)
				{
					opponentsSide.getHalf().getUnitAt(unit.getRow(), i).damage(attackLeft);
					mySide.getHalf().dispatchEvent(new UnitDamagedByUnitEvent(opponentsSide.getHalf().getUnitAt(unit.getRow(), i), unit, attackLeft, mySide, opponentsSide));
					mySide.getHalf().dispatchEvent(new UnitDamagedEvent(opponentsSide.getHalf().getUnitAt(unit.getRow(), i), attackLeft, mySide, opponentsSide));
					attackLeft = 0;
					if(opponentsSide.getHalf().getUnitAt(unit.getRow(), i).getHealth()<0)
					{
						attackLeft-=opponentsSide.getHalf().getUnitAt(unit.getRow(), i).getHealth();
						mySide.getHalf().dispatchEvent(new UnitKilledByUnitEvent(opponentsSide.getHalf().getUnitAt(unit.getRow(), i), unit, mySide, opponentsSide));
					}
					else if(opponentsSide.getHalf().getUnitAt(unit.getRow(), i).getHealth()==0)
					{
						mySide.getHalf().dispatchEvent(new UnitKilledByUnitEvent(opponentsSide.getHalf().getUnitAt(unit.getRow(), i), unit, mySide, opponentsSide));
						break;
					}
					else
					{
						break;
					}
				}
			}
			if(attackLeft>0)
			{
				opponentsSide.getHalf().setIdol(unit.getRow(), opponentsSide.getHalf().getIdolAt(unit.getRow())-attackLeft);
				if(opponentsSide.getHalf().getIdolAt(unit.getRow())<0)
				{
					opponentsSide.getHalf().setIdol(unit.getRow(), 0);
				}
			}
		}
		@Override
		public String toString()
		{
			return "Relentless";
		}
	}
	class NoAttack implements AttackType
	{
		@Override
		public void attack(Unit unit, Side mySide, Side opponentsSide)
		{
		}
		@Override
		public String toString()
		{
			return "Does not attack";
		}
	}
}