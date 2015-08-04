package com.alvarpq.GOTF.gui;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class MenuStage extends Stage {

	public MenuStage()
	{
		//sets the size of the stage to fill the whole window
		super(new FitViewport(540, 829));//so are these the minimum screen dimensions or something?
		//addActor(new Actor())
	}
}
