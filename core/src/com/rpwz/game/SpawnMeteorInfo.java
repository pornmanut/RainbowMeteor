package com.rpwz.game;

import com.rpwz.game.MeteorColor.Color;
public class SpawnMeteorInfo {
	private int row;
	private int col;
	private Color color;
	private float[] setOfTimeStart;
	private int index =0;
	private float time;
	private boolean spawn;
	private boolean alreadySpawn = false;
	
	public SpawnMeteorInfo(int row,int col,Color color,float[] setOfTimeStart) {
		setup(row, col, color);
		this.setOfTimeStart = setOfTimeStart;
		this.time = setOfTimeStart[0];
	}
	public void setup(int row,int col,Color color) {
		this.row = row;
		this.col = col;
		this.color = color;
		this.spawn = false;
	}

	public void update(float delta) {
		if(time <= 0 && !alreadySpawn) {
			spawn = true;
	
			alreadySpawn = true;
			return;
		}
		time -= delta;
	}
	
	public boolean getAlreadySpawn() {
		return alreadySpawn;
	}
	public void setAlreadySpawn(boolean bool){
		alreadySpawn = bool;
	}
	public int getRow() {
		return row;
	}
	public int getCol() {
		return col;
	}
	
	public void setSpawn(boolean bool) {
		this.spawn = bool;
	}
	public boolean isSpawn() {
		return spawn;
	}
	
	public Color getColor() {
		return this.color;
	}
	
	public float getTime() {
		return this.time;
	}

	

}
