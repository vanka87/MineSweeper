package com.minesweeper.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Timer;

public class TableGameOver {
    private MineSweeperGame game = MineSweeperGame.getInstance();

    public Table table;
    private Label text;

    public TableGameOver() {
        table = new Table(game.menu.menuSkin);
        table.setBounds(0, 0, MineSweeperGame.DEVICE_WIDTH, MineSweeperGame.DEVICE_HEIGHT);

        text = new Label("EXPLOSION! GAME OVER!", game.menu.textStyle);
        text.setAlignment(Align.center);

        table.add(text);
        table.row().spaceTop(game.menu.textStyle.font.getLineHeight());

        table.setY(MineSweeperGame.DEVICE_HEIGHT);
    }

    public void showGameOverTable() {
        Gdx.input.setInputProcessor(null);

        Timer timer = new Timer();
        timer.scheduleTask(new Timer.Task() {
            @Override
            public void run() {
                table.setY(0);
                game.menu.tableGame.hideTableGame();
            }
        }, 5f);
    }
}
