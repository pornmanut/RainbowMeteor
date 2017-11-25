package com.rpwz.game;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class RainbowMeteor extends Game {
	
	public SpriteBatch batch;
	public BitmapFont font;
	
	private static final int HEIGHT = 600;
	private static final int WIDTH = 800;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		font = new BitmapFont();
		setScreen(new GameScreen(this));
	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
		font.dispose();
		batch.dispose();
	}

	public static int getHeight() {
		return HEIGHT;
	}

	public static int getWidth() {
		return WIDTH;
	}
}
