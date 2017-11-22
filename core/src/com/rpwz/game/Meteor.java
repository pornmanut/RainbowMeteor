package com.rpwz.game;

public class Meteor {
	
	private static int NumberOfMeteor = 0;
	
	private int x = 0;
	private int y = 0;
	
	public Meteor() {
		addNumberOfMeteor();
	}
	public Meteor(int x,int y) {
		setPosition(x,y);
		addNumberOfMeteor();
	}
	
	public void addNumberOfMeteor() {
		NumberOfMeteor++;
	}
	public void setPosition(int x,int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getPosX() {
		return this.x;
	}
	public int getPosY() {
		return this.y;
	}
	
	public int getNumberOfMeteor() {
		return NumberOfMeteor;
	}
}
