package com.rpwz.game;



import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class WorldRenderer {
	
	private World world;
	private SpriteBatch batch;
	private BitmapFont font;
	private WorldInput input;

	
	public WorldRenderer(RainbowMeteor base,World world,WorldInput input) {
		this.world = world;
		this.batch = base.batch;
		this.font = base.font;
		this.input = input;
		
	}
	public int getPosY(int y) {
		return RainbowMeteor.getHeight()-y;
	}
	public void drawTotalMeteor(SpriteBatch batch) {
		for(int i=0;i<world.getMeteorSystem().getMaxOfMeteor();i++) {
			Meteor m = world.getMeteorSystem().getMeteor(i);
			batch.draw(MeteorColor.GetMeteorTexture(m.getColor()),
					m.getPosX()-m.getXOffset(),
					getPosY(m.getPosY())-m.getYOffset());
			

		}
	}
	
	public void showDebug(SpriteBatch batch) {
		font.draw(batch,"mouseX: "+input.getX(),100,getPosY(500));
		font.draw(batch,"mouseY: "+input.getY(),100,getPosY(520));
		font.draw(batch,"Color: "+world.getCurrentColor(),200,getPosY(520));
		font.draw(batch,"Q: "+input.isKeyQ(),400,getPosY(500));
		font.draw(batch,"W: "+input.isKeyW(),400,getPosY(520));
		font.draw(batch,"E: "+input.isKeyE(),400,getPosY(540));
		font.draw(batch,"Score: "+world.getScore(),500,getPosY(500));
		font.draw(batch,"HP: "+world.getHP(),500,getPosY(520));
		font.draw(batch,"Time: "+String.format("%.2f",world.getTime()),500,getPosY(540));
		
		for(int i=0;i<world.getMeteorSystem().getMaxOfMeteor();i++) {
			Meteor m = world.getMeteorSystem().getMeteor(i);
			font.draw(batch,"index: "+i+"\nx: "+m.getPosX()+"\ny: "+m.getPosY()+"\nc: "+m.getColor()+"\nm:"+m.getHP(),
					m.getPosX()+5+m.getXOffset(),
					getPosY(m.getPosY()));
		}
	}
	public void render(float delta) {
		batch.begin();
		drawTotalMeteor(batch);
		showDebug(batch);
		batch.end();
		
	}
}
