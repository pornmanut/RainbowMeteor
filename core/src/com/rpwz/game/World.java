package com.rpwz.game;

import com.rpwz.game.MeteorColor.Color;
public class World {
	


	private WorldInput input;
	private Color currentColor = MeteorColor.getColorRGB();
	private float time=0;
	private int score = 0;
	private int hp=10;
	private MeteorSystem ms;
	private MeteorLevel level ;
	private SpawnMeteorInfo[] miLevel01 = {new SpawnMeteorInfo(2, 1,Color.GREEN,2),new SpawnMeteorInfo(0, 7,Color.GREEN,4),
			 								new SpawnMeteorInfo(1, 1,Color.BLUE,6),new SpawnMeteorInfo(1, 5, Color.RED,8),
			 								new SpawnMeteorInfo(0, 5,Color.RED,10),new SpawnMeteorInfo(2,3,Color.BLUE,7),
			 								new SpawnMeteorInfo(0,6,Color.BLUE,10), new SpawnMeteorInfo(0, 4,Color.RED,11),
			 								new SpawnMeteorInfo(1, 3,Color.RED,12), new SpawnMeteorInfo(2, 5,Color.GREEN,11),
			 								new SpawnMeteorInfo(2,7,Color.BLUE,11), new SpawnMeteorInfo(2,0,Color.GREEN,15),
			 								new SpawnMeteorInfo(0,3,Color.BLUE,17), new SpawnMeteorInfo(0,0, Color.RED,17),
			 								new SpawnMeteorInfo(2, 1, Color.BLUE,19), new SpawnMeteorInfo(2,0,Color.GREEN,20)};
	

	
	public World(WorldInput input) {

 		this.input = input;
 		this.init();
 
	}
	public void init() {
		this.ms = new MeteorSystem();
		this.level = new MeteorLevel(ms,miLevel01);
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
				m.setMove(false);
				addScore(10);
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
		level.update(delta);
	}


	
	
}