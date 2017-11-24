package com.rpwz.game;

public class Mouse {
	private int mouseX = 0;
	private int mouseY = 0;
	private boolean mouseLeftPressed = false;

	
	public Mouse() {
		
	}
	
	public void setLeftPressed(boolean leftPressed) {
		mouseLeftPressed = leftPressed;
	}
	public boolean getLeftPressed() {
		return mouseLeftPressed;
	}
	
	public void setPos(int x,int y) {
		mouseX = x;
		mouseY = y;
	}
	
	public int getX() {
		return mouseX;
	}
	public int getY() {
		return mouseY;
	}
}
