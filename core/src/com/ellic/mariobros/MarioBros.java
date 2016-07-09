package com.ellic.mariobros;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.ellic.mariobros.Screens.PlayScreen;

public class MarioBros extends Game {
	//virtual width and height of our game
	public static final int V_WIDTH = 400;
	public static final int V_HEIGHT = 208;
	//made public so that all screens have access to it, only one should exist so as to not be
	//memory intensive
	public SpriteBatch batch;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		setScreen(new PlayScreen(this)); //allows game to set screens in the future

	}

	@Override
	public void render () {
		super.render(); //delegates render method to active screen
	}
}
