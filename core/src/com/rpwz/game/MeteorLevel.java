package com.rpwz.game;

import java.util.ArrayList;
import java.util.List;

import com.rpwz.game.MeteorColor.Color;

public class MeteorLevel {
	private MeteorSystem ms;
	private int level;
	private List<String> levelInfo = new ArrayList<String>();
	private float[] levelClock = {1f,3f,5f,6f,8f};
	
	private float time ;
	private int index = 0;
	

	
	public MeteorLevel(MeteorSystem ms) {
		this.ms = ms;
		this.level = 0;
		levelInfo = MeteorFile.readListOfString("level/test.txt");
		setLevelInfo(levelInfo);
		reset();
	}
	public void reset() {
		this.time = 0; this.index = 0;
	}
	public void setLevelInfo(List<String> list) {
		
		for(String str:list) {
			System.out.println(str);
		}
	}
	public void spawnAt(int row) {
		char c ;
		System.out.println(levelInfo.get(row));
		for(int col=0;col<levelInfo.get(row).length();col++) {
			c = levelInfo.get(row).charAt(col);
			switch(c) {
			case'R': 	ms.setMeteor(row, col,Color.RED);
						break;
			case'G':	ms.setMeteor(row, col,Color.GREEN);
						break;
			case'B':	ms.setMeteor(row, col, Color.BLUE);
						break;
			case'M':	ms.setMeteor(row, col, Color.MAGENTA);
						break;
			case'C':	ms.setMeteor(row, col, Color.CYAN);
						break;
			case'Y':	ms.setMeteor(row, col, Color.YELLOW);
						break;
			case'W':	ms.setMeteor(row, col, Color.WHITE);
						break;
			}
		}

	}
	private void updateSpawn() {
		if(index <= levelClock.length-1  &&  time >= levelClock[index]) {
			spawnAt(index);
			index++;
		}
		
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getLevel() {
		return level;
	}
	public void update(float delta) {
		updateSpawn();
		time += delta;
	}
}
