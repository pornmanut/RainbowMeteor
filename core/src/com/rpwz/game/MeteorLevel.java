package com.rpwz.game;

import java.util.ArrayList;
import java.util.List;


public class MeteorLevel {
	
	private final float INTERVAL_TIME = 1f;
	private MeteorSystem ms;
	private List<String> levelInfo = new ArrayList<String>();

	
	private float time ;
	private int index = 0;
	
	public float getIntervalTime() {
		return INTERVAL_TIME;
	}

	public MeteorLevel(MeteorSystem ms) {
		this.ms = ms;
		this.time = 0; 
		this.index = 0;
		
		levelInfo = MeteorFile.readListOfString("level/test.txt");
	}
	
	public MeteorLevel(MeteorSystem ms,String level) {
		this.ms = ms;
		this.time = 0; 
		this.index = 0;
		levelInfo = MeteorFile.readListOfString(level);
	}

	public void spawnAt(int row) {
		char c ;
		System.out.println(levelInfo.get(row));
		for(int col=0;col<levelInfo.get(row).length();col++) {
			c = levelInfo.get(row).charAt(col);
			if(c != '-'){
				ms.setMeteor(row, col,MeteorColor.charToColor(c));
			}continue;
		}

	}
	public void resetTime() {
		time = 0;
	}
	private void updateSpawn() {
		if(index <= levelInfo.size()-1  &&  time >= INTERVAL_TIME) {
			spawnAt(index);
			index++;
			resetTime();
			if(index == levelInfo.size()-1)System.out.println("FUCK");
		}
		
	}
	public void update(float delta) {
		updateSpawn();
		time += delta;
	}
}
