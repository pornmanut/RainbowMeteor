package com.rpwz.game;

public class Meteor {
	
	
	private int x = 0;
	private int y = 0;
	
	private int movementSpeed = 3;
	
	public Meteor() {

	}
	public Meteor(int x,int y) {
		setPosition(x,y);
	}
	
	public void setPosition(int x,int y) {
		this.x = x;
		this.y = y;
	}
	
	public void falling() {
		this.y -= movementSpeed;
	}
	
	public void update(float delta) {
		falling();
	}
	
	public int getMovementSpeed() {
		return movementSpeed;
	}
	public int getPosX() {
		return this.x;
	}
	public int getPosY() {
		return this.y;
	}
}
