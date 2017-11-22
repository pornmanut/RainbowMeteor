package com.rpwz.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class WorldRenderer {
	
	
	private Texture meteorImg;
	private World world;
	private SpriteBatch batch;
	private BitmapFont font;

	
	public WorldRenderer(RainbowMeteor base,World world) {
		this.world = world;
		meteorImg = new Texture("1.png");
		this.batch = base.batch;
		this.font = new BitmapFont();
		
	}
	public void drawTotalMeteor() {
		for(int i=0;i<world.getMaxOfMeteor();i++) {
			if(world.getMeteor(i) == null)return;
			batch.draw(meteorImg,world.getMeteor(i).getPosX(),world.getMeteor(i).getPosY());
		}
	}
	
	public void render(float delta) {
		batch.begin();
		font.draw(batch,"Total Meteor: "+world.getMeteorIndex(),300,300);
		drawTotalMeteor();
		batch.end();
		
	}
}
