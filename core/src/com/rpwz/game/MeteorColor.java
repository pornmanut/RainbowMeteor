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
	private static String CreateRGB() {
		return RGB[0]+""+RGB[1]+""+RGB[2];
	}
	private static int GetIntergerFromBoolean(boolean bool) {
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
	private static final Map<Color,Texture> FragmentTexture;
	static {
		FragmentTexture = new HashMap<Color,Texture>();
		
		FragmentTexture.put(Color.RED,new Texture("images/redFragment.png"));
		FragmentTexture.put(Color.BLUE,new Texture("images/blueFragment.png"));
		FragmentTexture.put(Color.GREEN,new Texture("images/greenFragment.png"));
		FragmentTexture.put(Color.CYAN,new Texture("images/cyanFragment.png"));
		FragmentTexture.put(Color.MAGENTA,new Texture("images/magentaFragment.png"));
		FragmentTexture.put(Color.YELLOW,new Texture("images/yellowFragment.png"));
		FragmentTexture.put(Color.WHITE,new Texture("images/whiteFragment.png"));
	}
	
	private static final Map<Color,Texture> MeteorTexture;
	static {
		MeteorTexture = new HashMap<Color,Texture>();
		
		MeteorTexture.put(Color.BLACK,new Texture("images/blackMeteor.png"));
		MeteorTexture.put(Color.RED,new Texture("images/redMeteor.png"));
		MeteorTexture.put(Color.BLUE,new Texture("images/blueMeteor.png"));
		MeteorTexture.put(Color.GREEN,new Texture("images/greenMeteor.png"));
		MeteorTexture.put(Color.CYAN,new Texture("images/cyanMeteor.png"));
		MeteorTexture.put(Color.YELLOW,new Texture("images/yellowMeteor.png"));
		MeteorTexture.put(Color.MAGENTA,new Texture("images/magentaMeteor.png"));
		MeteorTexture.put(Color.WHITE,new Texture("images/whiteMeteor.png"));
	}
	public static Color charToColor(char c) {
		switch(c) {
		case'R': 	return Color.RED;
		case'G':	return Color.GREEN;
		case'B':	return Color.BLUE;
		case'M':	return Color.MAGENTA;
		case'C':	return Color.CYAN;
		case'Y':	return Color.YELLOW;
		case'W':	return Color.WHITE;
		default:	return Color.BLACK;
		}
	}
	public static Color GetColorRGB() {
		return ColorRGB.get(CreateRGB());
	}
	
	public static Texture GetMeteorTexture(Color key) {
		return MeteorTexture.get(key);
	}
	public static Texture GetFragmentTexture(Color key) {
		return FragmentTexture.get(key);
	}
	
	public static void ResetColor() {
		for(int i=0;i<3;i++)RGB[i] = 0;
	}
	
	public static void setRGB(boolean red,boolean green,boolean blue) {
		RGB[0] = GetIntergerFromBoolean(red);
		RGB[1] = GetIntergerFromBoolean(green);
		RGB[2] = GetIntergerFromBoolean(blue);
	}
	
	
}
