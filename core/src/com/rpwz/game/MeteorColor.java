package com.rpwz.game;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.graphics.Texture;

public class MeteorColor {
	
	private static int[] RGB = {0,0,0};
	
	public static enum Color{
		BLACK,
		RED,
		GREEN,
		BLUE,
		YELLOW,
		MAGENTA,
		CYAN,
		WHITE;
	}
	private static String makeRGB() {
		return RGB[0]+""+RGB[1]+""+RGB[2];
	}
	private static int getIntergerFromBoolean(boolean bool) {
		return bool ? 1:0;
	}
	
	private static final Map<String,Color> ColorRGB;
	static {
		ColorRGB = new HashMap<String,Color>();
		
		ColorRGB.put("000",Color.BLACK);
		ColorRGB.put("100",Color.RED);
		ColorRGB.put("010",Color.GREEN);
		ColorRGB.put("001",Color.BLUE);
		ColorRGB.put("110",Color.YELLOW);
		ColorRGB.put("011",Color.CYAN);
		ColorRGB.put("101",Color.MAGENTA);
		ColorRGB.put("111",Color.WHITE);
		
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
	public static Color getColorRGB() {
		return ColorRGB.get(makeRGB());
	}
	
	public static Texture getMeteorTexture(Color key) {
		return MeteorTexture.get(key);
	}
	
	public static void clearColor() {
		for(int i=0;i<3;i++)RGB[i] = 0;
	}
	public static void setR(boolean bool) {
		RGB[0] = getIntergerFromBoolean(bool);
	}
	public static void setG(boolean bool) {
		RGB[1] = getIntergerFromBoolean(bool);
	}
	public static void setB(boolean bool) {
		RGB[2] = getIntergerFromBoolean(bool);
	}
	
}
