package com.rpwz.game;

import com.rpwz.game.MeteorColor.Color;
public class SpawnMeteorInfo {
	private int index;
	private Color color;
	private float timeStart;
	private float time;
	private boolean spawn;
	
	public SpawnMeteorInfo(int index,Color color,int timeStart) {
		setUp(index, color, timeStart);
	}
	public void setUp(int index,Color color,int timeStart) {
		this.index = index;
		this.color = color;
		this.timeStart = timeStart;
		this.time = timeStart;
		this.spawn = false;
	}
	
	public void update(float delta) {
		if(time <= 0) {
			spawn = true;
			return;
		}
		time -= delta;
	}
	
	public int getIndex() {
		return index;
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
