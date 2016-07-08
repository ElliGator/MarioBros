package com.ellic.mariobros.Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.ellic.mariobros.MarioBros;

/**
 * Created by Elli on 6/29/2016.
 */
public class PlayScreen implements Screen {
    private MarioBros game;
    Texture texture;
    //camera that follows game and actually shows what viewport is going to display
    private OrthographicCamera gamecam;
    private Viewport gamePort;

    public PlayScreen(MarioBros game) {
        this.game = game;
        texture = new Texture("badlogic.jpg");
        gamecam = new OrthographicCamera();
        gamePort = new FitViewport(800, 480, gamecam);
        /* stretch viewport streaches the graphics and can alter the way graphics look because
         * aspect ratio is not kept
         *
         * screen viewport keeps aspect ratio but in bigger devices may reveal more of the game
         * world and give these players an unfair advantage
         */
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        //clears the screen
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        //where camera is in the game and show only what we want camera to show
        game.batch.setProjectionMatrix(gamecam.combined);
        game.batch.begin();
        game.batch.draw(texture, 0, 0);
        game.batch.end();
    }

    @Override
    public void resize(int width, int height) {
        gamePort.update(width, height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
