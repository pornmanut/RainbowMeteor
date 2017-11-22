package com.rpwz.game;


public class World {
	
	private static final int MAX_OF_METEOR = 10;
	
	private Meteor[] meteorSet =  new Meteor[MAX_OF_METEOR];
	private int meteorIndex = 0;
	
	public World(RainbowMeteor base) {
 		addMeteor(new Meteor(100,100));
 		addMeteor(new Meteor(200,200));
 		addMeteor(new Meteor(300,100));
 		addMeteor(new Meteor(500,100));
 		addMeteor(new Meteor(300,600));
 		addMeteor(new Meteor(300,400));
	}
	
	public void addMeteor(Meteor meteor) {
		if(meteorIndex == MAX_OF_METEOR-1) return;
		meteorSet[meteorIndex] = meteor;
		meteorIndex++;
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

	public void update(float delta) {
		for(int i=0;i<MAX_OF_METEOR;i++) {
			if(meteorSet[i] == null)break;
			meteorSet[i].update(delta);
		}
	}
	
	
}