package com.ellic.mariobros.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.ellic.mariobros.MarioBros;
import com.ellic.mariobros.Scenes.Hud;

/**
 * Created by Elli on 6/29/2016.
 */
public class PlayScreen implements Screen {
    private MarioBros game;
    private Hud hud;
    //camera that follows game and actually shows what viewport is going to display
    private OrthographicCamera gamecam;
    private Viewport gamePort;

    private TmxMapLoader maploader;
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;

    public PlayScreen(MarioBros game) {
        this.game = game;
        gamecam = new OrthographicCamera();
        gamePort = new FitViewport(MarioBros.V_WIDTH, MarioBros.V_HEIGHT, gamecam);
        /* stretch viewport stretches the graphics and can alter the way graphics look because
         * aspect ratio is not kept
         *
         * screen viewport keeps aspect ratio but in bigger devices may reveal more of the game
         * world and give these players an unfair advantage
         */

        hud = new Hud(game.batch);

        maploader = new TmxMapLoader();
        map = maploader.load("level1.tmx");
        renderer = new OrthogonalTiledMapRenderer(map);
        gamecam.position.set(gamePort.getWorldWidth() / 2, gamePort.getWorldHeight() / 2, 0);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        update(delta);

        //clears the screen
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        renderer.render();

        //what is shown via camera
        game.batch.setProjectionMatrix(hud.stage.getCamera().combined);
        hud.stage.draw();
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

    public void handleInput(float dt) {
        //screen is touched
        if(Gdx.input.isTouched()){
            gamecam.position.x += 100 * dt;
        }
    }

    public void update(float dt) {
        handleInput(dt);
        gamecam.update();
        renderer.setView(gamecam);
    }
}
