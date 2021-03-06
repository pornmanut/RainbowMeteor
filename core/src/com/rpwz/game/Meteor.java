package com.rpwz.game;


import java.util.Random;
import com.rpwz.game.MeteorColor.Color;
public class Meteor {
	
	
	private int hp = 2;
	private int startHp = hp;
	private int x = 0;
	private int y = 0;
	private int startX = x;
	private int stattY = y;
	private int	xOffset = 16;
	private int yOffset = 16;
	private int movementHoriznotal = 1;
	private int movementSpeed = 2;
	private Color color = Color.RED;
	private boolean move = false;


	

	public Meteor(int x,int y) {
		setPosition(x,y);
		setStartPosition(x, y);
		setRandomHoriznotal();
	}
	public Meteor(int x,int y,Color color) {
		setPosition(x, y);
		setStartPosition(x, y);
		this.color = color;
		setRandomHoriznotal();
	}
	public void setSignHoriznotal() {
		movementHoriznotal *= -1;
	}
	public void setRandomHoriznotal() {
		movementHoriznotal = randomHoriznotal();
	}
	public int randomHoriznotal() {
		Random rand = new Random();
		return rand.nextInt(3)-1;
	}
	
	public boolean isColor(Color color) {
		return (this.color == color);
	}
	public boolean isCollideToAnother(Meteor other) {
		if(	other.x+xOffset >= this.x-xOffset && 
			other.x-xOffset <= this.x+xOffset &&
			other.y+yOffset >= this.y-yOffset &&
			other.y-yOffset <= this.y+yOffset)
			{
				return true;
			}
		return false;
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
				setSignHoriznotal();
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
	public void reset() {
		returnToStartPosition();
		resetToStartHP();
		setMove(false);
		
	}
	public void returnToStartPosition() {
		this.x = startX;
		this.y = stattY;
	}
	
	public void resetToStartHP() {
		this.hp = startHp;
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
	public int getStartHP() {
		return startHp;
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
	public void decreaseHP(int damage) {
		if(this.hp > 0) this.hp -= damage;
	}
	public boolean getAlive() {
		if(this.hp <= 0) {
			return false;
		}return true;
	}
	public int getHP() {
		return hp;
	}
	public void setHP(int hp) {
		this.hp = hp;
	}
	public boolean isMove() {
		return move;
	}
	public void setMove(boolean bool) {
		this.move = bool;
	}
}
