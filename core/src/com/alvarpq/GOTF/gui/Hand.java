package com.alvarpq.GOTF.gui;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import com.alvarpq.GOTF.coreGame.Element;
import com.alvarpq.GOTF.coreGame.cards.Card;
import com.alvarpq.GOTF.coreGame.cards.UnitCard;
import com.alvarpq.GOTF.coreGame.units.Unit;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
//actor to draw a hand
public class Hand extends Actor
{
	//holds the image assets
	AssetManager manager;
	//holds the cards in the hand
	private List<Card> hand;
	//the currently highlighted/selected card's index
	private int highlightedIndex;
	//where to draw
	private float x, y, cardWidth, cardHeight;
	//holds the font for drawing stats
	private BitmapFont font;
	//constructs a hand
	public Hand(AssetManager manager, List<Card> hand, float x, float y, float cardWidth, float cardHeight)
	{
		this.manager = manager;
		this.hand = hand;
		highlightedIndex = -1;
		this.x = x;
		this.y = y;
		this.cardWidth = cardWidth;
		this.cardHeight = cardHeight;
		font = new BitmapFont();
		font.setColor(Color.BLACK);		
	}
	//draws the hand
	@Override
	public void draw(Batch batch, float parentAlpha)
	{
		for(int i=0;i<hand.size();i++)
		{
			Sprite temp = new Sprite(manager.get("card.png", Texture.class));
			if(i==highlightedIndex)
			{
				temp.setBounds(x+(i%5)*cardWidth, y+cardHeight*11/10*(i/5)+cardHeight/10, cardWidth, cardHeight);
			}
			else
			{
				temp.setBounds(x+(i%5)*cardWidth, y+cardHeight*11/10*(i/5), cardWidth, cardHeight);
			}
			temp.draw(batch);
			GlyphLayout temp2 = new GlyphLayout(font, hand.get(i).getName()+"");
			font.draw(batch, temp2, temp.getX()+temp.getWidth()/2-temp2.width/2, temp.getY()+temp.getHeight()-temp.getHeight()/15+temp2.height/2);
			temp2.setText(font, hand.get(i).getResourceCost()+"");
			font.draw(batch, temp2, temp.getX()+temp.getWidth()/2-temp2.width/2, temp.getY()+temp.getHeight()-temp.getHeight()/6.67f+temp2.height/2);
			temp2.setText(font, hand.get(i).getElementCost(Element.AIR)+"");
			font.draw(batch, temp2, temp.getX()+temp.getWidth()/10*3-temp2.width/2, temp.getY()+temp.getHeight()-temp.getHeight()/6.67f+temp2.height/2);
			temp2.setText(font, hand.get(i).getElementCost(Element.EARTH)+"");
			font.draw(batch, temp2, temp.getX()+temp.getWidth()/10*4-temp2.width/2, temp.getY()+temp.getHeight()-temp.getHeight()/6.67f+temp2.height/2);
			temp2.setText(font, hand.get(i).getElementCost(Element.FIRE)+"");
			font.draw(batch, temp2, temp.getX()+temp.getWidth()/10*6-temp2.width/2, temp.getY()+temp.getHeight()-temp.getHeight()/6.67f+temp2.height/2);
			temp2.setText(font, hand.get(i).getElementCost(Element.WATER)+"");
			font.draw(batch, temp2, temp.getX()+temp.getWidth()/10*7-temp2.width/2, temp.getY()+temp.getHeight()-temp.getHeight()/6.67f+temp2.height/2);
			font.draw(batch, hand.get(i).getDescription()+"", temp.getX()+temp.getWidth()/10, temp.getY()+temp.getHeight()-temp.getHeight()/5, temp.getWidth()*8/10, 1, true);
			if(hand.get(i) instanceof UnitCard)
			{
				try
				{
					Unit unit = ((UnitCard)hand.get(i)).createUnit(-1, -1);
					temp2.setText(font, unit.getAttack()+"");
					font.draw(batch, temp2, temp.getX()+temp.getWidth()/4-temp2.width/2, temp.getY()+temp.getHeight()/10+temp2.height/2);
					temp2.setText(font, unit.getBaseCountdown()+"");
					font.draw(batch, temp2, temp.getX()+temp.getWidth()/2-temp2.width/2, temp.getY()+temp.getHeight()/10+temp2.height/2);
					temp2.setText(font, unit.getMaximumHealth()+"");
					font.draw(batch, temp2, temp.getX()+temp.getWidth()*3/4-temp2.width/2, temp.getY()+temp.getHeight()/10+temp2.height/2);
				}
				catch(InstantiationException e){e.printStackTrace();}
				catch(IllegalAccessException e){e.printStackTrace();}
				catch(IllegalArgumentException e){e.printStackTrace();}
				catch(InvocationTargetException e){e.printStackTrace();}
				catch(SecurityException e){e.printStackTrace();}
			}
		}
	}
	//is a click in these coordinates on a card
	public Card cardClicked(int x, int y)
	{
		if(x>this.x&&x<this.x+cardWidth*5&&y>this.y&&y<this.y+cardHeight*11/10*(hand.size()/5))
		{
			return hand.get((int)((y-this.y)/(cardHeight*11/10))*5+(int)((x-this.x)/cardWidth));
		}
		else if(x>this.x&&x<this.x+cardWidth*(hand.size()%5)&y>this.y+cardHeight*11/10*(hand.size()/5)&&y<this.y+cardHeight*11/10*(hand.size()/5+1))
		{
			return hand.get((int)((y-this.y)/(cardHeight*11/10))*5+(int)((x-this.x)/cardWidth));
		}
		return null;
	}
	//highlights specified index
	public void highlightIndex(int index)
	{
		highlightedIndex = index;
	}
	//highlights specified card
	public void highlight(Card card)
	{
		highlightedIndex = hand.indexOf(card);
	}
}