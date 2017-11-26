package com.rpwz.game;


import com.rpwz.game.MeteorColor.Color;
public class MeteorSystem {
	
	private final int ROW_OF_METEOR = 3;
	private final int COL_OF_METEOR = 8;
	private final int MAX_OF_METEOR = ROW_OF_METEOR*COL_OF_METEOR;
	
	private final int START_Y = 100;
	private final int MARGIN_Y = 50;
	
	private final int MARGIN_EDGE = 80;
	
	private Meteor[] meteorSet = new Meteor[MAX_OF_METEOR];
	
	public MeteorSystem() {
		initSetOfMeteor();
	}
	
	public void initSetOfMeteor() {
		int index = 0;
		int size = (RainbowMeteor.getWidth()-MARGIN_EDGE)/COL_OF_METEOR;
		for(int j=0;j<ROW_OF_METEOR;j++) {
			for(int i=0;i<COL_OF_METEOR;i++) {
				meteorSet[index] = new Meteor(MARGIN_EDGE+size*i,START_Y+MARGIN_Y*j);
				index++;
			}
		}
	}
	
	public void setMeteorColor(int index,Color color) {
		if(index > MAX_OF_METEOR-1)return;
		meteorSet[index].setColor(color);
	}
	public void setMeteorMove(int index,boolean bool) {
		if(index > MAX_OF_METEOR-1)return;
		meteorSet[index].setMove(bool);
	}
	public void setMeteor(int row,int col,Color color,boolean bool) {
		if(row > ROW_OF_METEOR-1 || col > COL_OF_METEOR-1)return;
		int index = (row*COL_OF_METEOR)+col;
		setMeteorColor(index, color);
		setMeteorMove(index, bool);
	}
	
	public int getMaxOfMeteor() {
		return MAX_OF_METEOR;
	}
	public Meteor getMeteor(int index) {
		return meteorSet[index];
	}
	public Meteor[] getMeteorSet() {
		return meteorSet;
	}
	
	
	
}
