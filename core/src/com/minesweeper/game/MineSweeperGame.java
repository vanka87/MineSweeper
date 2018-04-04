package com.minesweeper.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class MineSweeperGame extends Game {
    protected static MineSweeperGame instance = null;

    public static float DEVICE_WIDTH;
    public static float DEVICE_HEIGHT;

    public Stage gameStage;
    public SpriteBatch batch;

    public MenuManager menu;
    public ProcessGame gameProcess;

    public static MineSweeperGame getInstance() {
        if (instance == null) {
            instance = new MineSweeperGame();
        }
        return instance;
    }

    @Override
    public void create() {
        DEVICE_WIDTH = Gdx.graphics.getWidth();
        DEVICE_HEIGHT = Gdx.graphics.getHeight();

        gameStage = new Stage();
        batch = new SpriteBatch();

        menu = new MenuManager();

        gameProcess = new ProcessGame();
        menu.createTables();

        Gdx.input.setInputProcessor(gameStage);
        ((Game) Gdx.app.getApplicationListener()).setScreen(new ScreenGame());
    }

    @Override
    public void render() {
        super.render();
        Gdx.gl20.glClearColor(255f / 255f, 221f / 255f, 153f / 255f, 1);
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        gameStage.draw();
        batch.end();
    }

    @Override
    public void dispose() {
    }
}
