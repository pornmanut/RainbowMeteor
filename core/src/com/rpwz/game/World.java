package com.rpwz.game;



public class World {
	
	private Meteor meteor;
	
	public World(RainbowMeteor base) {
 		meteor = new Meteor(100,100);
	}
	
	public Meteor getMeteor() {
		return meteor;
	}
	
	public void update(float delta) {
		
	}
	
	
}