package com.rpwz.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MenuRenderer {

	private SpriteBatch batch;
	private BitmapFont font;
	private Texture background = new Texture("menu/background.png");
	
	public MenuRenderer(RainbowMeteor base) {
		this.batch = base.batch;
		this.font = base.font;
	}
	
	public void drawBackground(SpriteBatch batch) {
		batch.draw(background,0,0);
	}
	public void render(float delta) {
		batch.begin();
		drawBackground(batch);
		batch.end();
	}
}
