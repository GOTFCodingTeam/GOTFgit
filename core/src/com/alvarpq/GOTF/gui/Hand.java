package com.alvarpq.GOTF.gui;
import java.util.List;
import com.alvarpq.GOTF.coreGame.Element;
import com.alvarpq.GOTF.coreGame.cards.Card;
import com.alvarpq.GOTF.coreGame.cards.UnitCard;
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
	}
	//draws the hand
	@Override
	public void draw(Batch batch, float parentAlpha)
	{
		//the fonts
		BitmapFont font = manager.get("font.fnt", BitmapFont.class);
		font.setColor(Color.BLACK);
		BitmapFont fontSmall = manager.get("fontsmall.fnt", BitmapFont.class);
		fontSmall.setColor(Color.BLACK);
		for(int i = 0;i < hand.size(); i++)//iterates through hand.
		{
			//the variables are: temp = the sprite, temp2 = the resource sprite, temp3 = the glyphlayout for drawing centered text, don't blame me for names, blame libgdx
			if(!(hand.get(i) instanceof UnitCard))
			{
				Sprite temp;
				//determining which texture to use and draws it
				if(hand.get(i).getElementCost(Element.AIR)>0&&hand.get(i).getElementCost(Element.EARTH)==0&&
				hand.get(i).getElementCost(Element.FIRE)==0&&hand.get(i).getElementCost(Element.WATER)==0)
				{
					temp = new Sprite(manager.get("aircard.png", Texture.class));
				}
				else if(hand.get(i).getElementCost(Element.AIR)==0&&hand.get(i).getElementCost(Element.EARTH)>0&&
				hand.get(i).getElementCost(Element.FIRE)==0&&hand.get(i).getElementCost(Element.WATER)==0)
				{
					temp = new Sprite(manager.get("earthcard.png", Texture.class));
				}
				else if(hand.get(i).getElementCost(Element.AIR)==0&&hand.get(i).getElementCost(Element.EARTH)==0&&
				hand.get(i).getElementCost(Element.FIRE)>0&&hand.get(i).getElementCost(Element.WATER)==0)
				{
					temp = new Sprite(manager.get("firecard.png", Texture.class));
				}
				else if(hand.get(i).getElementCost(Element.AIR)==0&&hand.get(i).getElementCost(Element.EARTH)==0&&
				hand.get(i).getElementCost(Element.FIRE)==0&&hand.get(i).getElementCost(Element.WATER)>0)
				{
					temp = new Sprite(manager.get("watercard.png", Texture.class));
				}
				else
				{
					temp = new Sprite(manager.get("neutralcard.png", Texture.class));
				}
				if(i==highlightedIndex)
				{
					temp.setBounds(x+(i%5)*cardWidth, y+cardHeight*11/10*(i/5)+cardHeight/10, cardWidth, cardHeight);
				}
				else
				{
					temp.setBounds(x+(i%5)*cardWidth, y+cardHeight*11/10*(i/5), cardWidth, cardHeight);
				}
				temp.draw(batch);
				//draws the name
				GlyphLayout temp3 = new GlyphLayout(font, hand.get(i).getName()+"");
				font.draw(batch, temp3, temp.getX()+temp.getWidth()/2-temp3.width/2, temp.getY()+temp.getHeight()-font.getCapHeight());
				//draws the cost of the card
				float currentY = temp.getY()+temp.getHeight()-font.getCapHeight()*4;
				for(int j=0;j<hand.get(i).getResourceCost();j++)
				{
					Sprite temp2 = new Sprite(manager.get("resource.png", Texture.class));
					temp2.setBounds(temp.getX()+font.getCapHeight()*0.5f, currentY, font.getCapHeight(), font.getCapHeight());
					temp2.draw(batch);
					currentY-=font.getCapHeight();
				}
				currentY = temp.getY()+temp.getHeight()-font.getCapHeight()*4;
				for(int j=0;j<hand.get(i).getElementCost(Element.AIR);j++)
				{
					Sprite temp2 = new Sprite(manager.get("air.png", Texture.class));
					temp2.setBounds(temp.getX()+temp.getWidth()-font.getCapHeight()*1.5f, currentY, font.getCapHeight(), font.getCapHeight());
					temp2.draw(batch);
					currentY-=font.getCapHeight();
				}
				for(int j=0;j<hand.get(i).getElementCost(Element.EARTH);j++)
				{
					Sprite temp2 = new Sprite(manager.get("earth.png", Texture.class));
					temp2.setBounds(temp.getX()+temp.getWidth()-font.getCapHeight()*1.5f, currentY, font.getCapHeight(), font.getCapHeight());
					temp2.draw(batch);
					currentY-=font.getCapHeight();
				}
				for(int j=0;j<hand.get(i).getElementCost(Element.FIRE);j++)
				{
					Sprite temp2 = new Sprite(manager.get("fire.png", Texture.class));
					temp2.setBounds(temp.getX()+temp.getWidth()-font.getCapHeight()*1.5f, currentY, font.getCapHeight(), font.getCapHeight());
					temp2.draw(batch);
					currentY-=font.getCapHeight();
				}
				for(int j=0;j<hand.get(i).getElementCost(Element.WATER);j++)
				{
					Sprite temp2 = new Sprite(manager.get("water.png", Texture.class));
					temp2.setBounds(temp.getX()+temp.getWidth()-font.getCapHeight()*1.5f, currentY, font.getCapHeight(), font.getCapHeight());
					temp2.draw(batch);
					currentY-=font.getCapHeight();
				}
				//draws the description
				fontSmall.draw(batch, hand.get(i).getDescription()+"", temp.getX()+font.getCapHeight()*2, temp.getY()+temp.getHeight()-font.getCapHeight()*3, temp.getWidth()-font.getCapHeight()*4, 1, true);
			}
			else
			{
				Sprite temp;
				//determining which texture to use and draws it
				if(hand.get(i).getElementCost(Element.AIR)>0&&hand.get(i).getElementCost(Element.EARTH)==0&&
				hand.get(i).getElementCost(Element.FIRE)==0&&hand.get(i).getElementCost(Element.WATER)==0)
				{
					temp = new Sprite(manager.get("airunit.png", Texture.class));
				}
				else if(hand.get(i).getElementCost(Element.AIR)==0&&hand.get(i).getElementCost(Element.EARTH)>0&&
				hand.get(i).getElementCost(Element.FIRE)==0&&hand.get(i).getElementCost(Element.WATER)==0)
				{
					temp = new Sprite(manager.get("earthunit.png", Texture.class));
				}
				else if(hand.get(i).getElementCost(Element.AIR)==0&&hand.get(i).getElementCost(Element.EARTH)==0&&
				hand.get(i).getElementCost(Element.FIRE)>0&&hand.get(i).getElementCost(Element.WATER)==0)
				{
					temp = new Sprite(manager.get("fireunit.png", Texture.class));
				}
				else if(hand.get(i).getElementCost(Element.AIR)==0&&hand.get(i).getElementCost(Element.EARTH)==0&&
				hand.get(i).getElementCost(Element.FIRE)==0&&hand.get(i).getElementCost(Element.WATER)>0)
				{
					temp = new Sprite(manager.get("waterunit.png", Texture.class));
				}
				else
				{
					temp = new Sprite(manager.get("neutralunit.png", Texture.class));
				}
				if(i==highlightedIndex)
				{
					temp.setBounds(x+(i%5)*cardWidth, y+cardHeight*11/10*(i/5)+cardHeight/10, cardWidth, cardHeight);
				}
				else
				{
					temp.setBounds(x+(i%5)*cardWidth, y+cardHeight*11/10*(i/5), cardWidth, cardHeight);
				}
				temp.draw(batch);
				//draws the name
				GlyphLayout temp3 = new GlyphLayout(font, hand.get(i).getName()+"");
				font.draw(batch, temp3, temp.getX()+temp.getWidth()/2-temp3.width/2, temp.getY()+temp.getHeight()-font.getCapHeight());
				//draws the cost of the card
				float currentY = temp.getY()+temp.getHeight()-font.getCapHeight()*4;
				for(int j=0;j<hand.get(i).getResourceCost();j++)
				{
					Sprite temp2 = new Sprite(manager.get("resource.png", Texture.class));
					temp2.setBounds(temp.getX()+font.getCapHeight()*0.5f, currentY, font.getCapHeight(), font.getCapHeight());
					temp2.draw(batch);
					currentY-=font.getCapHeight();
				}
				currentY = temp.getY()+temp.getHeight()-font.getCapHeight()*4;
				for(int j=0;j<hand.get(i).getElementCost(Element.AIR);j++)
				{
					Sprite temp2 = new Sprite(manager.get("air.png", Texture.class));
					temp2.setBounds(temp.getX()+temp.getWidth()-font.getCapHeight()*1.5f, currentY, font.getCapHeight(), font.getCapHeight());
					temp2.draw(batch);
					currentY-=font.getCapHeight();
				}
				for(int j=0;j<hand.get(i).getElementCost(Element.EARTH);j++)
				{
					Sprite temp2 = new Sprite(manager.get("earth.png", Texture.class));
					temp2.setBounds(temp.getX()+temp.getWidth()-font.getCapHeight()*1.5f, currentY, font.getCapHeight(), font.getCapHeight());
					temp2.draw(batch);
					currentY-=font.getCapHeight();
				}
				for(int j=0;j<hand.get(i).getElementCost(Element.FIRE);j++)
				{
					Sprite temp2 = new Sprite(manager.get("fire.png", Texture.class));
					temp2.setBounds(temp.getX()+temp.getWidth()-font.getCapHeight()*1.5f, currentY, font.getCapHeight(), font.getCapHeight());
					temp2.draw(batch);
					currentY-=font.getCapHeight();
				}
				for(int j=0;j<hand.get(i).getElementCost(Element.WATER);j++)
				{
					Sprite temp2 = new Sprite(manager.get("water.png", Texture.class));
					temp2.setBounds(temp.getX()+temp.getWidth()-font.getCapHeight()*1.5f, currentY, font.getCapHeight(), font.getCapHeight());
					temp2.draw(batch);
					currentY-=font.getCapHeight();
				}
				//draws the description
				fontSmall.draw(batch, hand.get(i).getDescription()+"", temp.getX()+font.getCapHeight()*2, temp.getY()+temp.getHeight()-font.getCapHeight()*3, temp.getWidth()-font.getCapHeight()*4, 1, true);
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