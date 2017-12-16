package com.rpwz.game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class MeteorFile {
	public static List<String> readListOfString(String filename) 
	{
		List<String> records = new ArrayList<String>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			String line = null ;
			while((line = reader.readLine()) != null){
				records.add(line);
			}
			reader.close();
			return records;
		}
		catch(Exception e){
			System.err.format("Exception occurred trying to read '%s'.", filename);
			e.printStackTrace();
			return null;
		}
	}

}
