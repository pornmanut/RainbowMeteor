package com.rpwz.game;

import com.rpwz.game.MeteorColor.Color;
public class SpawnMeteorInfo {
	private int row;
	private int col;
	private Color color;
	private float timeStart;
	private float time;
	private boolean spawn;
	private boolean alreadySpawn = false;
	
	public SpawnMeteorInfo(int row,int col,Color color,float timeStart) {
		setup(row,col, color, timeStart);
	}
	public void setup(int row,int col,Color color,float timeStart) {
		this.row = row;
		this.col = col;
		this.color = color;
		this.timeStart = timeStart;
		this.time = timeStart;
		this.spawn = false;
	}
	
	public void update(float delta) {
		if(alreadySpawn) {
			spawn = false;
			return;
		}
		if(time <= 0) {
			alreadySpawn = true;
			spawn = true;
			return;
		}
		time -= delta;
	}
	
	public boolean getAlreadySpawn() {
		return alreadySpawn;
	}
	public void reset() {
		this.time = timeStart;
		this.alreadySpawn = false;
	}
	public int getRow() {
		return row;
	}
	public int getCol() {
		return col;
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

	public float getTimeStart() {
		return this.timeStart;
	}

}
