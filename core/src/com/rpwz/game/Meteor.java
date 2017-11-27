package com.rpwz.game;



import com.rpwz.game.MeteorColor.Color;
public class Meteor {
	
	
	
	private int x = 0;
	private int y = 0;
	private int startX = x;
	private int stattY = y;
	private int	xOffset = 24;
	private int yOffset = 24;
	private int movementHoriznotal = 1;
	private int movementSpeed = 3;
	private Color color = Color.RED;
	private boolean move = false;

	
	public Meteor() {

	}
	public Meteor(int x,int y) {
		setPosition(x,y);
		setStartPosition(x, y);
	}
	public Meteor(int x,int y,Color color) {
		setPosition(x, y);
		setStartPosition(x, y);
		this.color = color;
	}
	public boolean isColor(Color color) {
		return (this.color == color);
	}
	
	public boolean isCollide(int mouseX,int mouseY) {
		if(	mouseX >= this.x-xOffset && 
			mouseX <= this.x+xOffset &&
			mouseY >= this.y-yOffset &&
			mouseY <= this.y+yOffset)
		{
			return true;
		}
		return false;
	}
	
	public void horizontal() {
		this.x += movementHoriznotal;
	}
	public void setHorizontal(int movement) {
		this.movementHoriznotal = movement;
	}
	public int getHorizontal() {
		return this.movementHoriznotal;
	}
	
	public void falling() {
		this.y += movementSpeed;
	}
	public boolean isOutOfSide() {
		if(this.x-yOffset < 0 || this.x+xOffset > RainbowMeteor.getWidth()){
			return true;
		}
		return false;
	}
	public boolean isOutOfEdge(int height) {
		if(this.y > height+yOffset/2)return true;
		return false;
	}
	
	public void update(float delta) {
		if(this.move) {
			falling();
			if(isOutOfSide()) {
				setHorizontal(getHorizontal()*-1);
			}
			horizontal();
		}
	
	}
	public void setPosition(int x,int y) {
		this.x = x;
		this.y = y;
	}
	
	public void setStartPosition(int x,int y) {
		this.startX = x;
		this.stattY = y;
	}
	public void returnToStartPosition() {
		this.x = startX;
		this.y = stattY;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	public Color getColor() {
		return color;
	}
	public int getMovementSpeed() {
		return movementSpeed;
	}
	public int getXOffset() {
		return xOffset;
	}
	public int getYOffset() {
		return yOffset;
	}
	public int getPosX() {
		return this.x;
	}
	public int getPosY() {
		return this.y;
	}
	public int getStartX() {
		return startX;
	}
	public void setStartX(int startX) {
		this.startX = startX;
	}
	public int getStattY() {
		return stattY;
	}
	public void setStattY(int stattY) {
		this.stattY = stattY;
	}
	public boolean isMove() {
		return move;
	}
	public void setMove(boolean bool) {
		this.move = bool;
	}
}
