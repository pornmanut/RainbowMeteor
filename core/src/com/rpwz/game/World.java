package com.rpwz.game;

import com.rpwz.game.MeteorColor.Color;
public class World {
	
	private static final int MAX_OF_METEOR = 20;
	private RainbowMeteor base;
	private Meteor[] meteorSet =  new Meteor[MAX_OF_METEOR];
	private WorldInput input;
	private int meteorIndex = 0;
	private Color currentColor = MeteorColor.getColorRGB();
	private int time=0;
	private int score = 0;
	
	public World(RainbowMeteor base,WorldInput input) {

 		this.base = base;
 		this.input = input;
 		addMeteor(new Meteor(100,200));
 		addMeteor(new Meteor(300,200,Color.BLUE));
 		addMeteor(new Meteor(500,200,Color.GREEN));
 		addMeteor(new Meteor(700,200,Color.CYAN));
 		addMeteor(new Meteor(400,200,Color.MAGENTA));
 		addMeteor(new Meteor(600,200,Color.WHITE));
 		addMeteor(new Meteor(200,200,Color.YELLOW));

	}
	
	
	public void addMeteor(Meteor meteor) {
		if(meteorIndex == MAX_OF_METEOR-1) return;
		meteorSet[meteorIndex] = meteor;
		meteorIndex++;
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
	public int getTime() {
		return time;
	}
	public int getMeteorIndex() {
		return meteorIndex;
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
				m.falling();
			}
			if(m.isOutOfEdge(base.HEIGHT)) {
				m.setPosition(m.getPosX(),100);
			}
		}
	}
	
	public void update(float delta) {
		updateColor(delta);
		updateTime(delta);
		updateMeteor(delta);
	}
	
	
}