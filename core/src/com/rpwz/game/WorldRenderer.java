package com.rpwz.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class WorldRenderer {
	
	
	private Texture meteorImg;
	private World world;
	private SpriteBatch batch;

	
	public WorldRenderer(RainbowMeteor base,World world) {
		this.world = world;
		meteorImg = new Texture("1.png");
		this.batch = base.batch;
		
	}
	
	public void render(float delta) {
		batch.begin();
		batch.draw(meteorImg,world.getMeteor().getPosX(),world.getMeteor().getPosY());
		batch.end();
		
	}
}
