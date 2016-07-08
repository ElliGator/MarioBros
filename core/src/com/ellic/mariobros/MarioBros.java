package com.ellic.mariobros;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.ellic.mariobros.Screens.PlayScreen;

public class MarioBros extends Game {
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
