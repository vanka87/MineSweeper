package com.minesweeper.game;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

import java.util.ArrayList;

public class TableGame {
    private MineSweeperGame game = MineSweeperGame.getInstance();

    private ArrayList<TextButton> textButtons = new ArrayList<TextButton>();
    public Table table;

    public TableGame() {
        table = new Table(game.menu.menuSkin);
        table.setBounds(0, 0, MineSweeperGame.DEVICE_WIDTH, MineSweeperGame.DEVICE_HEIGHT);

        for (int i = 0; i < ProcessGame.NUM_CELLS; i++) {
            textButtons.add(new TextButton(game.gameProcess.getGrid()[i], game.menu.textButtonStyle));
            textButtons.get(i).setName(String.valueOf(i));
            textButtons.get(i).getLabel().setColor(1, 1, 1, 0);

            textButtons.get(i).addListener(new ButtonClickListener() {

                @Override
                public void clicked(InputEvent event, float x, float y) {
                    super.clicked(event, x, y);
                    if (event.getListenerActor() instanceof TextButton) {
                        TextButton curBtn = (TextButton) event.getListenerActor();
                        int curBtnIndex = Integer.parseInt(curBtn.getName());

                        int cX = curBtnIndex / ProcessGame.NUM_CELLS_Y;
                        int cY = curBtnIndex % ProcessGame.NUM_CELLS_Y;

                        game.gameProcess.openCell(cX, cY);

                        for (int i = 0; i < ProcessGame.NUM_CELLS; i++) {
                            if (game.gameProcess.getVisible()[i] == true) {
                                textButtons.get(i).getLabel().setColor(1, 1, 1, 1);
                            }
                        }


                    }
                }
            });
        }

        for (int i = 0; i < ProcessGame.NUM_CELLS_X; i++) {
            for (int j = 0; j < ProcessGame.NUM_CELLS_Y; j++) {
                table.add(textButtons.get(ProcessGame.NUM_CELLS_X * i + j))
                        .size(game.menu.textButtonStyle.up.getMinWidth() * 0.75f,
                                game.menu.textButtonStyle.up.getMinHeight() * 0.75f);
            }
            table.row();
        }
        table.setY(0);
    }

    public void hideTableGame() {
        table.setY(MineSweeperGame.DEVICE_HEIGHT);
    }
}