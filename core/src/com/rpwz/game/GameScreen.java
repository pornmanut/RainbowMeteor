package com.rpwz.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;

public class GameScreen extends ScreenAdapter{
	
		private World world;
		private WorldRenderer worldRenderer;
		private WorldInput input;
		

		public GameScreen(RainbowMeteor base) {
			input = new WorldInput();
			world = new World(input);
			worldRenderer = new WorldRenderer(base,world,input);
		}
		private void updateKeys(World world) {
			input.setKeyQ(Gdx.input.isKeyPressed(Input.Keys.Q));
			input.setKeyW(Gdx.input.isKeyPressed(Input.Keys.W));
			input.setKeyE(Gdx.input.isKeyPressed(Input.Keys.E));
			input.setKeySpaceBar(Gdx.input.isKeyPressed(Input.Keys.SPACE));
		}
		private void updateMouse(World world) {
			input.setPos(Gdx.input.getX(),Gdx.input.getY());
			input.setLeftPressed(Gdx.input.isButtonPressed(Input.Buttons.LEFT));
		}
		private boolean isUpdate() {
			return world.isRun();
		}
		private void clear() {
			Gdx.gl.glClearColor(0, 0, 0, 1);
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);		
		}
		
		private void update(float delta) {
			if(isUpdate()) {
				updateMouse(world);
				updateKeys(world);
				world.update(delta);
			}	
		}
			
		
		@Override
		public void render(float delta) {
			this.update(delta);
			this.clear();
			worldRenderer.render(delta);
		}
}
