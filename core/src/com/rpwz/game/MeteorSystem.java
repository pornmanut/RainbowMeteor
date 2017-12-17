package com.rpwz.game;


import com.rpwz.game.MeteorColor.Color;
public class MeteorSystem {
	

	private final int ROW_OF_METEOR = 5;
	private final int COL_OF_METEOR = 10;
	private final int MAX_OF_METEOR = ROW_OF_METEOR*COL_OF_METEOR;
	
	
	private final int MAX_FRAGMENT = 10;
	private final int START_Y_FRAGMENT = -32;
	private final int START_X_FRAGMENT = 50;
	private final int MARGIN_X_FRAGMENT = 60;
	private final int START_Y = -32;
	private final int MARGIN_Y = 0;
	
	private final int MARGIN_EDGE = 50;
	
	private Meteor[] meteorSet = new Meteor[MAX_OF_METEOR];
	private MeteorFragment[] fragmentSet = new MeteorFragment[MAX_FRAGMENT];
	
	public MeteorSystem() {
		initSetOfMeteor();
		initFragment();
	
	}
	public void initFragment() {
		for(int i=0;i<MAX_FRAGMENT;i++) {
			fragmentSet[i] = new MeteorFragment(START_X_FRAGMENT+(MARGIN_X_FRAGMENT*i),START_Y_FRAGMENT);
		}
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

	public boolean setFragment(Meteor m) {
		if(m == null)return false;
		
		MeteorFragment f = null;
		for(int i=0;i<MAX_FRAGMENT;i++) {
			if(fragmentSet[i].isMove() == false){
				f = fragmentSet[i];
				break;
			}
		}
		if(f != null) {
			f.setPosition(m.getPosX(), m.getPosY());
			f.setColor(m.getColor());
			f.setMove(true);
			f.resetDeltaY();
			f.randomDeltaX();
			return true;
			
		}return false;
	}
	public int getIndex(int row,int col) {
		return (row*COL_OF_METEOR)+col;
	}
	
	public boolean setMeteor(int col,Color color) {
		if(col < 0 || col > COL_OF_METEOR-1)return false;
		Meteor m = null;
		
		for(int row=0;row<ROW_OF_METEOR-1;row++) {
			
			if(meteorSet[getIndex(row, col)].isMove() == false) {
				m = meteorSet[getIndex(row, col)];
				break;
			}
		}
		if(m != null) {
			m.setColor(color);
			m.setMove(true);
			return true;
		}return false ;
	}
	public int getRowOfMeteor() {
		return ROW_OF_METEOR;
	}
	public int getColOfMeteor() {
		return COL_OF_METEOR;
	}
	public int getMaxOfMeteor() {
		return MAX_OF_METEOR;
	}
	public int getMaxFragment() {
		return MAX_FRAGMENT;
	}
	public MeteorFragment getFragment(int index) {
		return fragmentSet[index];
	}
	public Meteor getMeteor(int row,int col) {
		int index = (row*COL_OF_METEOR)+col;
		return meteorSet[index];
	}
	public Meteor getMeteor(int index) {
		return meteorSet[index];
	}
	public Meteor[] getMeteorSet() {
		return meteorSet;
	}
	
	
	
}
