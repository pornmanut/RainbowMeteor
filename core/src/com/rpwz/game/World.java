package com.rpwz.game;


public class World {
	
	private static final int MAX_OF_METEOR = 20;
	private RainbowMeteor base;
	private Meteor[] meteorSet =  new Meteor[MAX_OF_METEOR];
	private Mouse mouse = new Mouse();
	private int meteorIndex = 0;
	private int time=0;

	
	private int score = 0;
	
	public World(RainbowMeteor base) {

 		this.base = base;
 		
 		addMeteor(new Meteor(100,200));
 		addMeteor(new Meteor(300,200,Meteor.Color.BLUE));
 		addMeteor(new Meteor(500,200,Meteor.Color.GREEN));
 		addMeteor(new Meteor(700,200,Meteor.Color.CYAN));
 		addMeteor(new Meteor(400,200,Meteor.Color.MAGENTA));
 		addMeteor(new Meteor(600,200,Meteor.Color.WHITE));
 		addMeteor(new Meteor(200,200,Meteor.Color.YELLOW));

	}
	
	
	public void addMeteor(Meteor meteor) {
		if(meteorIndex == MAX_OF_METEOR-1) return;
		meteorSet[meteorIndex] = meteor;
		meteorIndex++;
	}
	
	public Mouse getMouse() {
		return mouse;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public void addScore(int add) {
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
	public void updateTime(float delta) {
		time += delta;
	}
	public void updateMeteor(float delta) {
		for(int i=0;i<MAX_OF_METEOR;i++) {
			if(meteorSet[i] == null)break;
			Meteor m = meteorSet[i];
			m.update(delta);
			if(m.isCollide(mouse.getX(), mouse.getY()) && mouse.getLeftPressed()) {
				m.falling();
			}
			if(m.isOutOfEdge(base.HEIGHT)) {
				m.setPosition(m.getPosX(),100);
			}
		}
	}
	
	public void update(float delta) {
		updateTime(delta);
		updateMeteor(delta);
	}
	
	
}