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
	//holds the card sprite
	private Sprite cardSprite;
	//holds the font for drawing stats
	private BitmapFont font;
	//constructs a hand
	public GraphicalCard(AssetManager manager, Card card, Sprite cardSprite)
	{
		this.manager = manager;
		this.card = card;
		this.cardSprite = cardSprite;
		font = new BitmapFont();
		font.setColor(Color.BLACK);		
	}
	//draws the card
	@Override
	public void draw(Batch batch, float parentAlpha)
	{
		if(card!=null)
		{
			cardSprite.draw(batch);
			GlyphLayout temp2 = new GlyphLayout(font, card.getName()+"");
			font.draw(batch, temp2, cardSprite.getX()+cardSprite.getWidth()/2-temp2.width/2, cardSprite.getY()+cardSprite.getHeight()-cardSprite.getHeight()/15+temp2.height/2);
			float currentX = cardSprite.getX()+cardSprite.getWidth()/8;
			for(int i=0;i<card.getResourceCost();i++)
			{
				Sprite temp = new Sprite(manager.get("resource.png", Texture.class));
				temp.setBounds(currentX, cardSprite.getY()+cardSprite.getHeight()*17/20, cardSprite.getWidth()/13.33f, cardSprite.getHeight()/20);
				temp.draw(batch);
				currentX+=cardSprite.getWidth()/13.33f;
			}
			for(int i=0;i<card.getElementCost(Element.AIR);i++)
			{
				Sprite temp = new Sprite(manager.get("air.png", Texture.class));
				temp.setBounds(currentX, cardSprite.getY()+cardSprite.getHeight()*17/20, cardSprite.getWidth()/13.33f, cardSprite.getHeight()/20);
				temp.draw(batch);
				currentX+=cardSprite.getWidth()/13.33f;
			}
			for(int i=0;i<card.getElementCost(Element.EARTH);i++)
			{
				Sprite temp = new Sprite(manager.get("earth.png", Texture.class));
				temp.setBounds(currentX, cardSprite.getY()+cardSprite.getHeight()*17/20, cardSprite.getWidth()/13.33f, cardSprite.getHeight()/20);
				temp.draw(batch);
				currentX+=cardSprite.getWidth()/13.33f;
			}
			for(int i=0;i<card.getElementCost(Element.FIRE);i++)
			{
				Sprite temp = new Sprite(manager.get("fire.png", Texture.class));
				temp.setBounds(currentX, cardSprite.getY()+cardSprite.getHeight()*17/20, cardSprite.getWidth()/13.33f, cardSprite.getHeight()/20);
				temp.draw(batch);
				currentX+=cardSprite.getWidth()/13.33f;
			}
			for(int i=0;i<card.getElementCost(Element.WATER);i++)
			{
				Sprite temp = new Sprite(manager.get("water.png", Texture.class));
				temp.setBounds(currentX, cardSprite.getY()+cardSprite.getHeight()*17/20, cardSprite.getWidth()/13.33f, cardSprite.getHeight()/20);
				temp.draw(batch);
				currentX+=cardSprite.getWidth()/13.33f;
			}
			font.draw(batch, card.getDescription()+"", cardSprite.getX()+cardSprite.getWidth()/10, cardSprite.getY()+cardSprite.getHeight()-cardSprite.getHeight()/5, cardSprite.getWidth()*8/10, 1, true);
			if(card instanceof UnitCard)
			{
				try
				{
					Unit unit = ((UnitCard)card).createUnit(-1, -1);
					temp2.setText(font, unit.getAttack()+"");
					font.draw(batch, temp2, cardSprite.getX()+cardSprite.getWidth()/4-temp2.width/2, cardSprite.getY()+cardSprite.getHeight()/10+temp2.height/2);
					temp2.setText(font, unit.getBaseCountdown()+"");
					font.draw(batch, temp2, cardSprite.getX()+cardSprite.getWidth()/2-temp2.width/2, cardSprite.getY()+cardSprite.getHeight()/10+temp2.height/2);
					temp2.setText(font, unit.getMaximumHealth()+"");
					font.draw(batch, temp2, cardSprite.getX()+cardSprite.getWidth()*3/4-temp2.width/2, cardSprite.getY()+cardSprite.getHeight()/10+temp2.height/2);
				}
				catch(InstantiationException e){e.printStackTrace();}
				catch(IllegalAccessException e){e.printStackTrace();}
				catch(IllegalArgumentException e){e.printStackTrace();}
				catch(InvocationTargetException e){e.printStackTrace();}
				catch(SecurityException e){e.printStackTrace();}
			}
		};
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