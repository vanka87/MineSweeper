package com.minesweeper.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class MenuManager {
    public TextureAtlas menuAtlas;
    public Skin menuSkin;
    public BitmapFont font;
    public Label.LabelStyle textStyle;
    public TextButton.TextButtonStyle textButtonStyle;

    public TableGame tableGame;
    public TableGameOver tableGameOver;

    public MenuManager() {
        font = new BitmapFont(Gdx.files.internal("graphics/hdpi/fonts/font_black.fnt"));
        menuAtlas = new TextureAtlas(Gdx.files.internal("graphics/hdpi/menu_pack/menu.pack"));
        menuSkin = new Skin(menuAtlas);

        textStyle = new Label.LabelStyle();
        textStyle.font = font;

        textButtonStyle = new TextButton.TextButtonStyle();

        textButtonStyle.up = menuSkin.getDrawable("square_button_up");
        textButtonStyle.down = menuSkin.getDrawable("square_button_down");
        textButtonStyle.pressedOffsetX = 1;
        textButtonStyle.pressedOffsetY = -1;
        textButtonStyle.font = font;
    }

    public void createTables() {
        tableGame = new TableGame();
        tableGameOver = new TableGameOver();
    }
}
