package com.rpwz.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.rpwz.game.RainbowMeteor;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = RainbowMeteor.WIDTH;
		config.height = RainbowMeteor.HEIGHT;
		new LwjglApplication(new RainbowMeteor(), config);
	}
}
