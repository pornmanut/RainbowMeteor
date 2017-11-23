package com.rpwz.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class WorldRenderer {
	
	
	private Texture meteorImg;
	private World world;
	private SpriteBatch batch;
	private BitmapFont font;
	private RainbowMeteor base;

	
	public WorldRenderer(RainbowMeteor base,World world) {
		this.world = world;
		meteorImg = new Texture("redMeteor.png");
		this.batch = base.batch;
		this.font = new BitmapFont();
		this.base = base;
		
	}
	public void drawTotalMeteor() {
		for(int i=0;i<world.getMaxOfMeteor();i++) {
			if(world.getMeteor(i) == null)break;
			Meteor m = world.getMeteor(i);
			batch.draw(meteorImg,m.getPosX()-m.getXOffset(),
					base.HEIGHT-m.getPosY()-m.getYOffset());
			
			font.draw(batch,"x: "+m.getPosX()+"\ny: "+m.getPosY(),
					m.getPosX()+5+m.getXOffset(),
					base.HEIGHT-m.getPosY());
		}
	}
	
	public void render(float delta) {
		batch.begin();
		font.draw(batch,"Total Meteor: "+world.getMeteorIndex(),300,base.HEIGHT-500);
		font.draw(batch,"mouseX: "+world.getMouseX(),100,base.HEIGHT-500);
		font.draw(batch,"mouseY: "+world.getMouseY(),100,base.HEIGHT-520);
		drawTotalMeteor();
		batch.end();
		
	}
}
