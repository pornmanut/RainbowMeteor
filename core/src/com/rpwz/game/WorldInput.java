package com.rpwz.game;

public class WorldInput {
	private int mouseX = 0;
	private int mouseY = 0;
	private boolean keyQ;
	private boolean keyW;
	private boolean keyE;
	private boolean keySpaceBar;
	private boolean alreadyClicked = false;
	private boolean mouseLeftPressed = false;
	
	public WorldInput() {
		
	}
	
	public void setLeftPressed(boolean leftPressed) {
		mouseLeftPressed = leftPressed;
	}
	public boolean isLeftPressed() {
		return mouseLeftPressed;
	}
	public boolean isClicked() {
		if(!mouseLeftPressed) alreadyClicked = false;
		
		if((!alreadyClicked) && mouseLeftPressed) {
			alreadyClicked = true;
			return true;
		}
		return false;
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
	
	public boolean isKeyQ() {
		return keyQ;
	}

	public void setKeyQ(boolean keyQ) {
		this.keyQ = keyQ;
	}

	public boolean isKeyW() {
		return keyW;
	}

	public void setKeyW(boolean keyW) {
		this.keyW = keyW;
	}

	public boolean isKeySpaceBar() {
		return keySpaceBar;
	}

	public void setKeySpaceBar(boolean keySpaceBar) {
		this.keySpaceBar = keySpaceBar;
	}

	public boolean isKeyE() {
		return keyE;
	}

	public void setKeyE(boolean keyE) {
		this.keyE = keyE;
	}
}
