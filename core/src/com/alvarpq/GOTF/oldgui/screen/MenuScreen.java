package com.alvarpq.GOTF.oldgui.screen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
public class MenuScreen extends Screen{

	@Override
	public void create() {
		// TODO Auto-generated method stub
	}

	@Override
	public void render(SpriteBatch batch) {
		// TODO Auto-generated method stub

		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);  

		batch.begin();
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}


	public void dispose(SpriteBatch batch) {
		// TODO Auto-generated method stub
	}

	public void update() {
		// TODO Auto-generated method stub
	/*	if(Gdx.input.isButtonPressed(Input.Buttons.LEFT) ){
			if(Gdx.input.getX()>200 && Gdx.graphics.getHeight()-Gdx.input.getY()>0){
				ScreenManager.setScreen(new GameScreen());
			}
		}
		*/
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
	}
	

}
