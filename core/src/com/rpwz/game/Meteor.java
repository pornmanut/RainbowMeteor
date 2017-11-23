package com.rpwz.game;


public class Meteor {
	
	
	private int x = 0;
	private int y = 0;
	private int	xOffset = 24;
	private int yOffset = 24;
	private int movementSpeed = 3;
	
	public Meteor() {

	}
	public Meteor(int x,int y) {
		setPosition(x,y);
	}
	
	public boolean isCollide(int mouseX,int mouseY) {
		if(	mouseX >= this.x-xOffset && 
			mouseX <= this.x+xOffset &&
			mouseY >= this.y-yOffset &&
			mouseY <= this.y+yOffset)
		{
			return true;
		}
		return false;
	}
	

	public void setPosition(int x,int y) {
		this.x = x;
		this.y = y;
	}
	
	public void falling() {
		this.y += movementSpeed;
	}
	public boolean isOutOfEdge(int height) {
		if(this.y > height+yOffset/2)return true;
		return false;
	}
	
	public void update(float delta) {
		//falling();
	}
	
	public int getMovementSpeed() {
		return movementSpeed;
	}
	public int getXOffset() {
		return xOffset;
	}
	public int getYOffset() {
		return yOffset;
	}
	public int getPosX() {
		return this.x;
	}
	public int getPosY() {
		return this.y;
	}
}
