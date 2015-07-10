package com.alvarpq.GOTF.coreGame.units;
import com.alvarpq.GOTF.coreGame.board.BoardHalf;
import com.alvarpq.GOTF.entity.AnimatedSprite;
public class UselessContraption extends Unit
{
	public UselessContraption(int row, int column)
	{
		super("Useless Contraption", 0, 1, 4, 0, row, column);
		setMoveType(MoveType.IMMOVABLE);
		setAttackType(AttackType.NO_ATTACK);
	}
	@Override
	public void applyPresence(BoardHalf myHalf, BoardHalf opponentsHalf){}
	@Override
	public AnimatedSprite getSprite()
	{
		return null;
	}
	@Override
	public void update()
	{
	}
}
