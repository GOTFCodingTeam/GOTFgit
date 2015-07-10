package com.alvarpq.GOTF.coreGame.units;
import com.alvarpq.GOTF.coreGame.board.BoardHalf;
import com.alvarpq.GOTF.coreGame.effect.Presence;
import com.alvarpq.GOTF.entity.AnimatedSprite;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
public class RoyalInfantryman extends Unit
{
	public RoyalInfantryman(int row, int column)
	{
		super("Royal Infantryman", 1, 2, 2, 1, row, column);
	}
	@Override
	public void applyPresence(BoardHalf myHalf, BoardHalf opponentsHalf)
	{
		for(int i=0;i<myHalf.numberOfColumns();i++)
		{
			if(i!=getColumn()&&myHalf.getUnitAt(getRow(), i)!=null)
			{
				myHalf.getUnitAt(getRow(), i).applyEffect(Presence.HEALTH_1);
			}
		}
		
	}
	/*public Sprite getSprite(){
		Sprite f1= new Sprite(new Texture(Gdx.files.internal("animFrame1.png")));
		Sprite f2= new Sprite(new Texture(Gdx.files.internal("animFrame2.png")));
		f1.setSize(30,50);
		Sprite[] anim={f1,f2};
		return anim[frame];
	}*/
	@Override
	public void update() {
		double rand=Math.random();
		if(rand>.98){
			frame=1-frame;
		}
		
	}
	@Override
	public AnimatedSprite getSprite()
	{
		// TODO Auto-generated method stub
		return null;
	}
}