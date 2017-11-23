package com.rpwz.game;


public class World {
	
	private static final int MAX_OF_METEOR = 10;
	private RainbowMeteor base;
	private Meteor[] meteorSet =  new Meteor[MAX_OF_METEOR];
	private int meteorIndex = 0;
	private int time=0;
	private int mouseX = 0;
	private int mouseY = 0;
	
	public World(RainbowMeteor base) {

 		this.base = base;
 		
 		addMeteor(new Meteor(100,100));
 		addMeteor(new Meteor(300,200));
 		addMeteor(new Meteor(500,300));

	}
	
	public void setMousePos(int x,int y) {
		mouseX = x;
		mouseY = y;
	}
	
	public int getMouseX() {
		return mouseX;
	}
	public int getMouseY() {
		return mouseY;
	}
	public void addMeteor(Meteor meteor) {
		if(meteorIndex == MAX_OF_METEOR-1) return;
		meteorSet[meteorIndex] = meteor;
		meteorIndex++;
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
			if(m.isCollide(mouseX, mouseY)) {
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