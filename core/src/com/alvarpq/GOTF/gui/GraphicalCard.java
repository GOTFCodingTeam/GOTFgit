package com.alvarpq.GOTF.gui;
import java.lang.reflect.InvocationTargetException;
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

//actor to draw a card
public class GraphicalCard extends Actor
{
	//holds the images
	private AssetManager manager;
	//holds the card
	private Card card;
	//where to draw
	private float x, y, cardWidth, cardHeight;
	//constructs a hand
	public GraphicalCard(AssetManager manager, Card card, float x, float y, float cardWidth, float cardHeight)
	{
		this.manager = manager;
		this.card = card;
		this.x = x;
		this.y = y;
		this.cardWidth = cardWidth;
		this.cardHeight = cardHeight;
	}
	//draws the card
	@Override
	public void draw(Batch batch, float parentAlpha)
	{
		//the fonts
		BitmapFont font = manager.get("font.fnt", BitmapFont.class);
		font.setColor(Color.BLACK);
		BitmapFont fontSmall = manager.get("fontsmall.fnt", BitmapFont.class);
		fontSmall.setColor(Color.BLACK);
		if(card!=null)
		{
			//the variables are: temp = the sprite, temp2 = the resource sprite, temp3 = the glyphlayout for drawing centered text, don't blame me for names, blame libgdx
			if(!(card instanceof UnitCard))
			{
				Sprite temp;
				//determining which texture to use and draws it MEANING CARD BACKGROUND. 
				if(card.getElementCost(Element.AIR)>0&&card.getElementCost(Element.EARTH)==0&&
				card.getElementCost(Element.FIRE)==0&&card.getElementCost(Element.WATER)==0)
				{
					temp = new Sprite(manager.get("aircard.png", Texture.class));
				}
				else if(card.getElementCost(Element.AIR)==0&&card.getElementCost(Element.EARTH)>0&&
				card.getElementCost(Element.FIRE)==0&&card.getElementCost(Element.WATER)==0)
				{
					temp = new Sprite(manager.get("earthcard.png", Texture.class));
				}
				else if(card.getElementCost(Element.AIR)==0&&card.getElementCost(Element.EARTH)==0&&
				card.getElementCost(Element.FIRE)>0&&card.getElementCost(Element.WATER)==0)
				{
					temp = new Sprite(manager.get("firecard.png", Texture.class));
				}
				else if(card.getElementCost(Element.AIR)==0&&card.getElementCost(Element.EARTH)==0&&
				card.getElementCost(Element.FIRE)==0&&card.getElementCost(Element.WATER)>0)
				{
					temp = new Sprite(manager.get("watercard.png", Texture.class));
				}
				else
				{
					temp = new Sprite(manager.get("neutralcard.png", Texture.class));
				}
				temp.setBounds(x, y, cardWidth, cardHeight);
				temp.draw(batch);
				//draws the name
				GlyphLayout temp3 = new GlyphLayout(font, card.getName() + "");
				font.draw(batch, temp3, temp.getX()+temp.getWidth()/2-temp3.width/2, temp.getY()+temp.getHeight()-font.getCapHeight());
			
				//draws the cost of the card, on the card itself.
				float currentY = temp.getY()+temp.getHeight()-font.getCapHeight()*4;
				for(int j=0;j<card.getResourceCost();j++)
				{
					Sprite temp2 = new Sprite(manager.get("resource.png", Texture.class));
					temp2.setBounds(temp.getX()+font.getCapHeight()*0.5f, currentY, font.getCapHeight(), font.getCapHeight());
					temp2.draw(batch);
					currentY-=font.getCapHeight();
				}
				currentY = temp.getY()+temp.getHeight()-font.getCapHeight()*4;
				for(int j=0;j<card.getElementCost(Element.AIR);j++)
				{
					Sprite temp2 = new Sprite(manager.get("air.png", Texture.class));
					temp2.setBounds(temp.getX()+temp.getWidth()-font.getCapHeight()*1.5f, currentY, font.getCapHeight(), font.getCapHeight());
					temp2.draw(batch);
					currentY-=font.getCapHeight();
				}
				for(int j=0;j<card.getElementCost(Element.EARTH);j++)
				{
					Sprite temp2 = new Sprite(manager.get("earth.png", Texture.class));
					temp2.setBounds(temp.getX()+temp.getWidth()-font.getCapHeight()*1.5f, currentY, font.getCapHeight(), font.getCapHeight());
					temp2.draw(batch);
					currentY-=font.getCapHeight();
				}
				for(int j=0;j<card.getElementCost(Element.FIRE);j++)
				{
					Sprite temp2 = new Sprite(manager.get("fire.png", Texture.class));
					temp2.setBounds(temp.getX()+temp.getWidth()-font.getCapHeight()*1.5f, currentY, font.getCapHeight(), font.getCapHeight());
					temp2.draw(batch);
					currentY-=font.getCapHeight();
				}
				for(int j=0;j<card.getElementCost(Element.WATER);j++)
				{
					Sprite temp2 = new Sprite(manager.get("water.png", Texture.class));
					temp2.setBounds(temp.getX()+temp.getWidth()-font.getCapHeight()*1.5f, currentY, font.getCapHeight(), font.getCapHeight());
					temp2.draw(batch);
					currentY-=font.getCapHeight();
				}
				//draws the description
				fontSmall.draw(batch, card.getDescription()+"", temp.getX()+font.getCapHeight()*2, temp.getY()+temp.getHeight()-font.getCapHeight()*3, temp.getWidth()-font.getCapHeight()*4, 1, true);
			}
			else
			{
				Sprite temp;
				//determining which texture to use and draws it
				if(card.getElementCost(Element.AIR)>0&&card.getElementCost(Element.EARTH)==0&&
				card.getElementCost(Element.FIRE)==0&&card.getElementCost(Element.WATER)==0)
				{
					temp = new Sprite(manager.get("airunit.png", Texture.class));
				}
				else if(card.getElementCost(Element.AIR)==0&&card.getElementCost(Element.EARTH)>0&&
				card.getElementCost(Element.FIRE)==0&&card.getElementCost(Element.WATER)==0)
				{
					temp = new Sprite(manager.get("earthunit.png", Texture.class));
				}
				else if(card.getElementCost(Element.AIR)==0&&card.getElementCost(Element.EARTH)==0&&
				card.getElementCost(Element.FIRE)>0&&card.getElementCost(Element.WATER)==0)
				{
					temp = new Sprite(manager.get("fireunit.png", Texture.class));
				}
				else if(card.getElementCost(Element.AIR)==0&&card.getElementCost(Element.EARTH)==0&&
				card.getElementCost(Element.FIRE)==0&&card.getElementCost(Element.WATER)>0)
				{
					temp = new Sprite(manager.get("waterunit.png", Texture.class));
				}
				else
				{
					temp = new Sprite(manager.get("neutralunit.png", Texture.class));
				}
				temp.setBounds(x, y, cardWidth, cardHeight);
				temp.draw(batch);
				//draws the name
				GlyphLayout temp3 = new GlyphLayout(font, card.getName()+"");
				font.draw(batch, temp3, temp.getX()+temp.getWidth()/2-temp3.width/2, temp.getY()+temp.getHeight()-font.getCapHeight());
				//draws the cost of the card
				float currentY = temp.getY()+temp.getHeight()-font.getCapHeight()*4;
				for(int j=0;j<card.getResourceCost();j++)
				{
					Sprite temp2 = new Sprite(manager.get("resource.png", Texture.class));
					temp2.setBounds(temp.getX()+font.getCapHeight()*0.5f, currentY, font.getCapHeight(), font.getCapHeight());
					temp2.draw(batch);
					currentY-=font.getCapHeight();
				}
				currentY = temp.getY()+temp.getHeight()-font.getCapHeight()*4;
				for(int j=0;j<card.getElementCost(Element.AIR);j++)
				{
					Sprite temp2 = new Sprite(manager.get("air.png", Texture.class));
					temp2.setBounds(temp.getX()+temp.getWidth()-font.getCapHeight()*1.5f, currentY, font.getCapHeight(), font.getCapHeight());
					temp2.draw(batch);
					currentY-=font.getCapHeight();
				}
				for(int j=0;j<card.getElementCost(Element.EARTH);j++)
				{
					Sprite temp2 = new Sprite(manager.get("earth.png", Texture.class));
					temp2.setBounds(temp.getX()+temp.getWidth()-font.getCapHeight()*1.5f, currentY, font.getCapHeight(), font.getCapHeight());
					temp2.draw(batch);
					currentY-=font.getCapHeight();
				}
				for(int j=0;j<card.getElementCost(Element.FIRE);j++)
				{
					Sprite temp2 = new Sprite(manager.get("fire.png", Texture.class));
					temp2.setBounds(temp.getX()+temp.getWidth()-font.getCapHeight()*1.5f, currentY, font.getCapHeight(), font.getCapHeight());
					temp2.draw(batch);
					currentY-=font.getCapHeight();
				}
				for(int j=0;j<card.getElementCost(Element.WATER);j++)
				{
					Sprite temp2 = new Sprite(manager.get("water.png", Texture.class));
					temp2.setBounds(temp.getX()+temp.getWidth()-font.getCapHeight()*1.5f, currentY, font.getCapHeight(), font.getCapHeight());
					temp2.draw(batch);
					currentY-=font.getCapHeight();
				}
				//draws the description
				fontSmall.draw(batch, card.getDescription()+"", temp.getX()+font.getCapHeight()*2, temp.getY()+temp.getHeight()-font.getCapHeight()*3, temp.getWidth()-font.getCapHeight()*4, 1, true);
			}
		}
	}
	//gets the card
	public Card getCard()
	{
		return card;
	}
	//sets the card
	public void setCard(Card card)
	{
		this.card = card;
	}
}