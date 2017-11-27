package com.rpwz.game;

import com.rpwz.game.MeteorColor.Color;
public class MeteorLevel {
	private SpawnMeteorInfo[] level = {new SpawnMeteorInfo(0,3, Color.WHITE,2)};
	private MeteorSystem ms;
	
	public MeteorLevel(MeteorSystem ms) {
		this.ms = ms;
	}
	public MeteorLevel(MeteorSystem ms,SpawnMeteorInfo[] level) {
		this.ms = ms;
		this.level = level;
	}
	public void update(float delta) {
		for(int i=0;i<level.length;i++) {
			SpawnMeteorInfo mi = level[i];
			if(mi.isSpawn())ms.setMeteor(mi.getRow(),mi.getCol(),mi.getColor(),true);
			mi.update(delta);
		}
	}
}
