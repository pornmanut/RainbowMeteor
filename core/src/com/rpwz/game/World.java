package com.rpwz.game;

import com.rpwz.game.MeteorColor.Color;
public class World {
	
	private static final int MAX_DELAY_LEVEL_TIME = 4;
	
	private WorldInput input;
	private Color currentColor = MeteorColor.GetColorRGB();
	private float time=0;
	private int score = 0;
	private int hp=10;
	private float delayLevelTime = 0;

	private MeteorSystem ms;
	private MeteorLevel ml ;
	private boolean end = false;
	private boolean run = true;
	
	public World(WorldInput input) {

 		this.input = input;
 		this.ms = new MeteorSystem();
 		this.ml = new MeteorLevel(ms,1);
 
	}
	
	public MeteorSystem getMeteorSystem() {
		return this.ms;
	}
	
	public boolean isRun() {
		return run;
	}
	public int getHP() {
		return hp;
	}
	public void setHP(int hp) {
		if(hp < 0) {
			this.hp =0;
			return;
		}
		this.hp = hp;
	}
	public void removeHP(int hp) {
		if(this.hp-hp < 0) {
			this.hp = 0;
			return;
		}
		this.hp -= hp;
	}
	public Color getCurrentColor() {
		return currentColor;
	}
	public void setCurrentColor(Color color) {
		currentColor = color;
	}
	public void setScore(int score) {
		if(score <= 0) {
			this.score = 0;
			return;
		}
		this.score = score;
	}
	
	public void addScore(int add) {
		if(this.score+add <= 0) {
			this.score = 0;
			return;
		}
		this.score += add;
	}
	public int getScore() {
		return score;
	}
	public float getTime() {
		return time;
	}
	public MeteorLevel getMeteorLevel() {
		return ml;
	}



	public void updateColor(float delta) {
		boolean red = input.isKeyQ();
		boolean green = input.isKeyW();
		boolean blue = input.isKeyE();
		
		MeteorColor.setRGB(red,green,blue);
		
		currentColor = MeteorColor.GetColorRGB();
	}
	
	public void updateTime(float delta) {
		time += delta;
	}
	public void updateLevel(float delta) {
		if(ml.isFinishLevel()) {
			if(delayLevelTime <  MAX_DELAY_LEVEL_TIME) {
				delayLevelTime += delta;
				System.out.println("delta");
				return ;
			}
			
			if(!ml.isLastLevel() ) {
				ml.changeLevelTo(ml.getLevel()+1);
				System.out.println("a");
				delayLevelTime = 0;
			}else {
				System.out.println("s");
				end = true;
			}
				
			
		}
		ml.update(delta);
	}
	public void updateFragment(float delta) {
		for(int i=0;i<ms.getMaxFragment();i++) {
			MeteorFragment f = ms.getFragment(i);
			f.update(delta);
			
			if(f.isMove()) {
				if(f.isFallOutside(RainbowMeteor.getHeight())) {
					f.returnToStartPosition();
					f.setMove(false);
				}
			}
		}
	}
	public void updateHp(float delta) {
		if(hp <= 0 || end) {
			this.run = false;
			return;
		}
		this.run = true;
	}
	public void updateMeteor(float delta) {
		for(int i=0;i<ms.getMaxOfMeteor();i++) {
			
			Meteor m = ms.getMeteor(i);
			
			m.update(delta);
			
			if(m.isMove()) {
				
				if(m.isCollide(input.getX(), input.getY()) && input.isClicked() && m.isColor(currentColor)) {
					m.decreaseHP(1);
					ms.setFragment(m);
					if(!m.getAlive()) {
						m.reset();
						addScore(10);
					}
				}
				
				if(m.isOutOfEdge(RainbowMeteor.getHeight())) {
					m.reset();
					removeHP(1);
				}
				
				for(int j=0;j < ms.getMaxOfMeteor();j++) {
					if(i == j) continue; //self
					
					Meteor other = ms.getMeteor(j);
					if(!other.isMove())continue; //skip not move
					
					
					if(m.isCollideToAnother(other)) {
						int temp = m.getHorizontal();
						m.setHorizontal(other.getHorizontal());
						other.setHorizontal(temp);
					}
				}
			}
		}
	}
	
	public void update(float delta) {
		updateColor(delta);
		updateTime(delta);
		updateMeteor(delta);
		updateFragment(delta);
		updateLevel(delta);
		updateHp(delta);
	}


	
	
}