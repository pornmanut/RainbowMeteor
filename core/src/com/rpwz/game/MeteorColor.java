package com.rpwz.game;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.graphics.Texture;

public class MeteorColor {
	public static enum Color{
		RED,
		GREEN,
		BLUE,
		YELLOW,
		MAGENTA,
		CYAN,
		WHITE;
	}
	
	private static final Map<Color,Texture> MeteorTexture;
	static {
		MeteorTexture = new HashMap<Color,Texture>();
		
		MeteorTexture.put(Color.RED,new Texture("redMeteor.png"));
		MeteorTexture.put(Color.BLUE,new Texture("blueMeteor.png"));
		MeteorTexture.put(Color.GREEN,new Texture("greenMeteor.png"));
		MeteorTexture.put(Color.CYAN,new Texture("cyanMeteor.png"));
		MeteorTexture.put(Color.YELLOW,new Texture("yellowMeteor.png"));
		MeteorTexture.put(Color.MAGENTA,new Texture("magentaMeteor.png"));
		MeteorTexture.put(Color.WHITE,new Texture("whiteMeteor.png"));
	}
	
	public static Texture getMeteorTexture(Color key) {
		return MeteorTexture.get(key);
	}
	
}
