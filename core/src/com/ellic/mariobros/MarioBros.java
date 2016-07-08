package com.ellic.mariobros;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.ellic.mariobros.Screens.PlayScreen;

public class MarioBros extends ApplicationAdapter {
	public SpriteBatch batch; //made public so that all screens have access to it
	Texture img;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		//setScreen(new PlayScreen(this)); //allows game to set screens in the future
		img = new Texture("badlogic.jpg");
	}

	@Override
	public void render () {
		//super.render(); //delegates render method to active screen
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		//game.batch.setProjectionMatrix(gamecam.combined);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();
	}
}
