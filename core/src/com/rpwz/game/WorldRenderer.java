package com.rpwz.game;



import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.rpwz.game.MeteorColor.Color;



public class WorldRenderer {

	private World world;
	private SpriteBatch batch;
	private BitmapFont font;
	private WorldInput input;
	private Texture background = new Texture("images/background.png");
	private Texture frontBackground = new Texture("images/frontBackground.png");
	
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
			batch.draw(MeteorColor.GetMeteorTexture(m.getColor()),m.getPosX()-m.getXOffset(),getPosY(m.getPosY())-m.getYOffset());
		}
	}
	public void drawFragment(SpriteBatch batch) {
		for(int i=0;i<world.getMeteorSystem().getMaxFragment();i++) {
			MeteorFragment f = world.getMeteorSystem().getFragment(i);
			batch.draw(MeteorColor.GetFragmentTexture(f.getColor()),f.getPosX()-f.getXOffset(),getPosY(f.getPosY())-f.getYOffset());
		}
	}
	
	public void drawBackground(SpriteBatch batch) {
		batch.draw(background,0,0);
		
	}
	public void drawFrontBackground(SpriteBatch batch) {
		batch.draw(frontBackground,0,0);
	}
	public void drawCurrentColor(SpriteBatch batch) {
		Color color = world.getCurrentColor();
		batch.draw(MeteorColor.GetMeteorTexture(color),RainbowMeteor.getWidth()/2,getPosY(550));
		font.draw(batch,"Color: "+color,(RainbowMeteor.getWidth()/2)-25,getPosY(560));
	}
	public void showDebug(SpriteBatch batch) {
		font.draw(batch,"mouseX: "+input.getX(),100,getPosY(500));
		font.draw(batch,"mouseY: "+input.getY(),100,getPosY(520));
		font.draw(batch,"Color: "+world.getCurrentColor(),200,getPosY(520));
		font.draw(batch,"Q: "+input.isKeyQ(),400,getPosY(500));
		font.draw(batch,"W: "+input.isKeyW(),400,getPosY(520));
		font.draw(batch,"E: "+input.isKeyE(),400,getPosY(540));
		font.draw(batch,"Level: "+world.getMeteorLevel().getLevel(),400,getPosY(560));
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
	public void drawStatus(SpriteBatch batch) {
		font.draw(batch,"HP: "+world.getHP(),50, getPosY(550));
		font.draw(batch,"Score: "+world.getScore(),50,getPosY(50));
		font.draw(batch,"Level: "+world.getMeteorLevel().getLevel(),RainbowMeteor.getWidth()-100,getPosY(550));
		font.draw(batch,"Time: "+String.format("%.2f",world.getTime()),RainbowMeteor.getWidth()-100,getPosY(50));
	}
	public void render(float delta) {
		batch.begin();
		drawBackground(batch);
		drawTotalMeteor(batch);
		drawFragment(batch);
		drawCurrentColor(batch);
		//drawFrontBackground(batch);
		//showDebug(batch);
		drawStatus(batch);
		batch.end();
		
	}
}
