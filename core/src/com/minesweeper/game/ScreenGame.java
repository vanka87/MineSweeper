package com.minesweeper.game;

import com.badlogic.gdx.Screen;

public class ScreenGame implements Screen {
    private MineSweeperGame game = MineSweeperGame.getInstance();

    @Override
    public void show() {
        game.gameStage.addActor(game.menu.tableGame.table);
        game.gameStage.addActor(game.menu.tableGameOver.table);
    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void resize(int width, int height) {

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
