package com.rpwz.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;

public class GameScreen extends ScreenAdapter{
	
		private World world;
		private WorldRenderer worldRenderer;

		public GameScreen(RainbowMeteor base) {
			world = new World(base);
			worldRenderer = new WorldRenderer(base,world);
		}
		private void updateMouse(World world) {
			world.setMousePos(Gdx.input.getX(),Gdx.input.getY());
			world.setMouseLeftPressed(Gdx.input.isButtonPressed(Input.Buttons.LEFT));
		}
		
		private void clear() {
			Gdx.gl.glClearColor(0, 0, 0, 1);
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);		
		}
		
		private void update(float delta) {
			updateMouse(this.world);
			this.world.update(delta);
		}
		
		@Override
		public void render(float delta) {
			this.update(delta);
			this.clear();
			worldRenderer.render(delta);
		}
}
