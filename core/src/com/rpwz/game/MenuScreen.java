package com.rpwz.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;

public class MenuScreen extends ScreenAdapter{
	private RainbowMeteor base;
	private MenuRenderer menuRenderer;
	
	public MenuScreen(RainbowMeteor base) {
		this.base = base;
		this.menuRenderer = new MenuRenderer(base);
	}
	private void clear() {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	}
	private void update(float delta) {
		if(Gdx.input.isKeyPressed(Input.Keys.TAB)) {
			base.setScreen(base.game);
		}
	}
	
	@Override
	public void render(float delta) {
		this.update(delta);
		this.clear();
		menuRenderer.render(delta);
	}
}
