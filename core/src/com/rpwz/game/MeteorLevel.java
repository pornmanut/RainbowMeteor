package com.rpwz.game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class MeteorLevel {
	
	private static final int MAX_LEVEL = 2;
	private static final Map<String,List<String>> LevelInformation;
	static {
		LevelInformation = new HashMap<String,List<String>>();
		LevelInformation.put("0", MeteorFile.readListOfString("level/test.txt"));
		LevelInformation.put("1", MeteorFile.readListOfString("level/001.txt"));
		LevelInformation.put("2", MeteorFile.readListOfString("level/002.txt"));
		
	}
	public static List<String> getLevelInfomation(int key){
		return LevelInformation.get(Integer.toString(key));
	}
	private final float INTERVAL_TIME = 1f;
	private MeteorSystem ms;
	private List<String> levelInfo = new ArrayList<String>();
	private int level;
	
	private float time ;
	private int index = 0;
	
	public float getIntervalTime() {
		return INTERVAL_TIME;
	}

	public MeteorLevel(MeteorSystem ms) {
		this.ms = ms;
		changeLevelTo(0);
	}
	
	public MeteorLevel(MeteorSystem ms,int level) {
		this.ms = ms;
		changeLevelTo(level);
	}
	public void changeLevelTo(int level) {
		if(!(level < 0 || level > MAX_LEVEL)) {
			this.time = 0; 
			this.index = 0;
			this.level = level;
			levelInfo = getLevelInfomation(level);
		}
	}
	public void spawnAt(int row) {
		char c ;
		for(int col=0;col<levelInfo.get(row).length();col++) {
			c = levelInfo.get(row).charAt(col);
			if(c != '-' && c != ' '){
				ms.setMeteor(col,MeteorColor.charToColor(c));
			}continue;
		}

	}
	public void resetTime() {
		time = 0;
	}
	public void resetIndex() {
		index = 0;
	}
	private void updateSpawn() {
		if(index < levelInfo.size()  &&  time >= INTERVAL_TIME) {
			spawnAt(index);
			resetTime();
			index++;
		}		
	}
	public boolean isFinishLevel() {
		return (index == levelInfo.size()); 
	}
	public void update(float delta) {
		updateSpawn();
		time += delta;
	}
	public boolean isLastLevel() {
		return (level == MAX_LEVEL);
	}
	public int getLevel() {
		return level;
	}
}
