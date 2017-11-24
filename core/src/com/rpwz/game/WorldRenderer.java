package com.rpwz.game;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class WorldRenderer {
	
	private World world;
	private SpriteBatch batch;
	private RainbowMeteor base;
	private BitmapFont font;

	
	public WorldRenderer(RainbowMeteor base,World world) {
		this.world = world;
		this.batch = base.batch;
		this.font = base.font;
		this.base = base;
		
	}
	public int getPosY(int y) {
		return base.HEIGHT-y;
	}
	public void drawTotalMeteor() {
		for(int i=0;i<world.getMaxOfMeteor();i++) {
			if(world.getMeteor(i) == null)break;
			Meteor m = world.getMeteor(i);
			batch.draw(MeteorColor.getMeteorTexture(m.getColor()),
					m.getPosX()-m.getXOffset(),
					getPosY(m.getPosY())-m.getYOffset());
			
			font.draw(batch,"x: "+m.getPosX()+"\ny: "+m.getPosY()+"\nc: "+m.getColor(),
					m.getPosX()+5+m.getXOffset(),
					getPosY(m.getPosY()));
		}
	}
	
	public void render(float delta) {
		batch.begin();
		font.draw(batch,"Total Meteor: "+world.getMeteorIndex(),300,getPosY(500));
		font.draw(batch,"mouseX: "+world.getMouse().getX(),100,getPosY(500));
		font.draw(batch,"mouseY: "+world.getMouse().getY(),100,getPosY(520));
		font.draw(batch,"Time: "+world.getTime(),200,getPosY(500));
		drawTotalMeteor();
		batch.end();
		
	}
}
