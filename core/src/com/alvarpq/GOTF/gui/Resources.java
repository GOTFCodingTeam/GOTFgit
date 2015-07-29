package com.alvarpq.GOTF.gui;
import com.alvarpq.GOTF.coreGame.Element;
import com.alvarpq.GOTF.coreGame.Side;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
//actor to draw a card
public class Resources extends Actor
{
	//holds the image assets
	AssetManager manager;
	//the side with resources
	private Side side;
	//where to draw
	private float x, y, width, height;
	//the font to draw numbers with
	private BitmapFont font;
	public Resources(AssetManager manager, Side side, float x, float y, float width, float height)
	{
		this.manager = manager;
		this.side = side;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		font = new BitmapFont();
		font.setColor(Color.BLACK);
	}
	//draws the hand (currently only name and resource cost)
	@Override
	public void draw(Batch batch, float parentAlpha)
	{
		/*resources.draw(batch);
		GlyphLayout temp = new GlyphLayout(font, side.getResources()+"");
		font.draw(batch, temp, resources.getX()+25-temp.width/2, resources.getY()+resources.getHeight()-25+temp.height/2);
		temp.setText(font, side.getMaximumResources()+"");
		font.draw(batch, temp, resources.getX()+75-temp.width/2, resources.getY()+resources.getHeight()-50+temp.height/2);
		temp.setText(font, side.getElement(Element.AIR)+"");
		font.draw(batch, temp, resources.getX()+25-temp.width/2, resources.getY()+resources.getHeight()-75+temp.height/2);
		temp.setText(font, side.getMaximumElement(Element.AIR)+"");
		font.draw(batch, temp, resources.getX()+75-temp.width/2, resources.getY()+resources.getHeight()-100+temp.height/2);
		temp.setText(font, side.getElement(Element.EARTH)+"");
		font.draw(batch, temp, resources.getX()+25-temp.width/2, resources.getY()+resources.getHeight()-125+temp.height/2);
		temp.setText(font, side.getMaximumElement(Element.EARTH)+"");
		font.draw(batch, temp, resources.getX()+75-temp.width/2, resources.getY()+resources.getHeight()-150+temp.height/2);
		temp.setText(font, side.getElement(Element.FIRE)+"");
		font.draw(batch, temp, resources.getX()+25-temp.width/2, resources.getY()+resources.getHeight()-175+temp.height/2);
		temp.setText(font, side.getMaximumElement(Element.FIRE)+"");
		font.draw(batch, temp, resources.getX()+75-temp.width/2, resources.getY()+resources.getHeight()-200+temp.height/2);
		temp.setText(font, side.getElement(Element.WATER)+"");
		font.draw(batch, temp, resources.getX()+25-temp.width/2, resources.getY()+resources.getHeight()-225+temp.height/2);
		temp.setText(font, side.getMaximumElement(Element.WATER)+"");
		font.draw(batch, temp, resources.getX()+75-temp.width/2, resources.getY()+resources.getHeight()-250+temp.height/2);*/
		Sprite temp = new Sprite(manager.get("water.png", Texture.class));
		temp.setBounds(x, y, width/2, height/5);
		temp.draw(batch);
		temp = new Sprite(manager.get("fire.png", Texture.class));
		temp.setBounds(x, y+height/5, width/2, height/5);
		temp.draw(batch);
		temp = new Sprite(manager.get("earth.png", Texture.class));
		temp.setBounds(x, y+height*2/5, width/2, height/5);
		temp.draw(batch);
		temp = new Sprite(manager.get("air.png", Texture.class));
		temp.setBounds(x, y+height*3/5, width/2, height/5);
		temp.draw(batch);
		temp = new Sprite(manager.get("resource.png", Texture.class));
		temp.setBounds(x, y+height*4/5, width/2, height/5);
		temp.draw(batch);
		GlyphLayout temp2 = new GlyphLayout(font, side.getElement(Element.WATER)+" / "+side.getMaximumElement(Element.WATER));
		font.draw(batch, temp2, x+width*3/4-temp2.width/2, y+height*1/10+temp2.height/2);
		temp2.setText(font, side.getElement(Element.FIRE)+" / "+side.getMaximumElement(Element.FIRE));
		font.draw(batch, temp2, x+width*3/4-temp2.width/2, y+height*3/10+temp2.height/2);
		temp2.setText(font, side.getElement(Element.EARTH)+" / "+side.getMaximumElement(Element.EARTH));
		font.draw(batch, temp2, x+width*3/4-temp2.width/2, y+height*5/10+temp2.height/2);
		temp2.setText(font, side.getElement(Element.AIR)+" / "+side.getMaximumElement(Element.AIR));
		font.draw(batch, temp2, x+width*3/4-temp2.width/2, y+height*7/10+temp2.height/2);
		temp2.setText(font, side.getResources()+" / "+side.getMaximumResources());
		font.draw(batch, temp2, x+width*3/4-temp2.width/2, y+height*9/10+temp2.height/2);
	}
}