package com.rpwz.game;

import com.rpwz.game.MeteorColor.Color;
public class World {
	
	private static final int MARGIN_EDGE = 80;
	private static final int MAX_OF_METEOR = 30;
	private RainbowMeteor base;
	private Meteor[] meteorSet =  new Meteor[MAX_OF_METEOR];
	private WorldInput input;
	private int meteorIndex = 0;
	private Color currentColor = MeteorColor.getColorRGB();
	private float time=0;
	private int score = 0;
	private int hp=10;
	
	
	public World(RainbowMeteor base,WorldInput input) {

 		this.base = base;
 		this.input = input;
 		//createSetOfMeteor(0,7);
 		createSetOfMeteor(50,7);
 		//createSetOfMeteor(100,7);
 		

	}
	public void createSetOfMeteor(int startY,int value) {
		int size = (base.getWidth()-MARGIN_EDGE)/value;
		for(int i=0;i<value;i++) {
			Meteor m = new Meteor(MARGIN_EDGE+size*i,startY,Color.RED);
			addMeteor(m);
		}
	}
	
	public void addMeteor(Meteor meteor) {
		if(meteorIndex == MAX_OF_METEOR-1) return;
		meteorSet[meteorIndex] = meteor;
		meteorIndex++;
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
	public int getMeteorIndex() {
		return meteorIndex;
	}
	public void	fallMeteor(int index) {
		meteorSet[index].setRuning(true);
	}
	
	public int getMaxOfMeteor() {
		return MAX_OF_METEOR;
	}
	public Meteor getMeteor(int index){
		return meteorSet[index];
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
		for(int i=0;i<MAX_OF_METEOR;i++) {
			if(meteorSet[i] == null)break;
			Meteor m = meteorSet[i];
			m.update(delta);
			if(m.isCollide(input.getX(), input.getY()) && input.isLeftPressed() && m.isColor(currentColor)) {
				m.returnToStartPosition();
				fallMeteor(i);
			}
			if(m.isOutOfEdge(base.getHeight())) {
				m.returnToStartPosition();
				m.setRuning(false);
				removeHP(1);
			}
		}
	}
	
	public void update(float delta) {
		updateColor(delta);
		updateTime(delta);
		updateMeteor(delta);
	}
	public static int getMarginEdge() {
		return MARGIN_EDGE;
	}
	
	
}