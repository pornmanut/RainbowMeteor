package com.rpwz.game;

import com.rpwz.game.MeteorColor.Color;
public class World {
	


	private WorldInput input;
	private Color currentColor = MeteorColor.getColorRGB();
	private float time=0;
	private int score = 0;
	private int hp=10;
	private MeteorSystem ms;
	
	public World(WorldInput input) {

 		this.input = input;
 		this.init();
 
	}
	public void init() {
		this.ms = new MeteorSystem();
		this.ms.setMeteor(0,7,Color.BLUE, true);
	}
	
	public MeteorSystem getMeteorSystem() {
		return this.ms;
	}
	

	public int getHP() {
		return hp;
	}
	public void setHP(int hp) {
		if(hp < 0) {
			this.hp =0;
			return;
		}
		this.hp = hp;
	}
	public void removeHP(int hp) {
		if(this.hp-hp < 0) {
			this.hp = 0;
			return;
		}
		this.hp -= hp;
	}
	public Color getCurrentColor() {
		return currentColor;
	}
	public void setCurrentColor(Color color) {
		currentColor = color;
	}
	public void setScore(int score) {
		if(score <= 0) {
			this.score = 0;
			return;
		}
		this.score = score;
	}
	
	public void addScore(int add) {
		if(this.score+add <= 0) {
			this.score = 0;
			return;
		}
		this.score += add;
	}
	public int getScore() {
		return score;
	}
	public float getTime() {
		return time;
	}



	public void updateColor(float delta) {
		if(input.isKeyQ()) MeteorColor.setR(true);
		if(input.isKeyW()) MeteorColor.setG(true);
		if(input.isKeyE()) MeteorColor.setB(true);
		if(input.isKeySpaceBar()) MeteorColor.clearColor();
		
		currentColor = MeteorColor.getColorRGB();
	}
	public void updateTime(float delta) {
		time += delta;
	}
	public void updateMeteor(float delta) {
		for(int i=0;i<ms.getMaxOfMeteor();i++) {
			Meteor m = ms.getMeteor(i);
			m.update(delta);
			if(m.isCollide(input.getX(), input.getY()) && input.isLeftPressed() && m.isColor(currentColor)) {
				m.returnToStartPosition();
			}
			if(m.isOutOfEdge(RainbowMeteor.getHeight())) {
				m.returnToStartPosition();
				m.setMove(false);
				removeHP(1);
			}
		}
	}
	
	public void update(float delta) {
		updateColor(delta);
		updateTime(delta);
		updateMeteor(delta);
	}


	
	
}