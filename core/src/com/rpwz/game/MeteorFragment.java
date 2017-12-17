package com.rpwz.game;

import java.util.Random;

import com.rpwz.game.MeteorColor.Color;

public class MeteorFragment {
	
	private int x=0;
	private int y=0;
	
	private int startX = x;
	private int startY = y;
	
	private int	xOffset = 8;
	private int yOffset = 8;
	
	private float deltaY = -1;
	private float startDeltaY = deltaY;
	private float gravity = 3f;
	private boolean move = false;
	private int deltaX = 0;
	private Color color = Color.RED;
	
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public void resetDeltaY() {
		deltaY = startDeltaY;
	}
	public void setOffset(int x,int y) {
		this.xOffset = x;
		this.yOffset = y;
	}
	public int getXOffset() {
		return xOffset;
	}
	public int getYOffset() {
		return yOffset;
	}
	
	public boolean isMove() {
		return move;
	}
	public void setMove(boolean move) {
		this.move = move;
	}
	public int getPosX() {
		return x;
	}
	public int getPosY() {
		return y;
	}
	public void setPosition(int x,int y) {
		this.x = x ;
		this.y = y;
	}
	
	public void returnToStartPosition() {
		this.x = startX;
		this.y = startY;
	}
	public void setStartPosition(int x,int y) {
		this.startX = x;
		this.startY = y;
	}
	public void randomDeltaX() {
		Random rand = new Random();
		while(deltaX == 0) {
			deltaX = rand.nextInt(3)-1;
		}
	}
	public void movement(float delta) {
		y += (int)deltaY;
		x += (int)deltaX;
	}
	public void updateGravity(float delta) {
		if((int)deltaY != 0) {
			deltaY += delta*gravity;
			return;
		}
		deltaY += 2*delta*gravity;
	}
	
	public boolean isFallOutside(int height) {
		if(this.y > height+yOffset/2)return true;
		return false;
	}
	
	public MeteorFragment(int x,int y) {
		setPosition(x, y);
		setStartPosition(x, y);
	}
	
	public void update(float delta) {
		if(this.move) {
			movement(deltaY);
			updateGravity(delta);
		}
	}
}
