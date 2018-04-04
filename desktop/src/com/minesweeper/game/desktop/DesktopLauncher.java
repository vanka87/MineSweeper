package com.minesweeper.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.minesweeper.game.MineSweeperGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.width = 500;
		config.height = 500;

		new LwjglApplication(MineSweeperGame.getInstance(), config);
	}
}
