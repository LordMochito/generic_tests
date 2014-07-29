package com.codetest.tests.episodenames;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.junit.Test;

public class CatalogueDuplicatesDiff {
	Map<String, String> source = new HashMap<String, String>();
	Map<String, String> updated = new HashMap<String, String>();

	//@Test
	public void shouldGet23MissingRows() throws IOException {
		updated = loadFile("src/test/resources/folders_list.txt", "/");
		source = loadFile("src/test/resources/catalogue.txt", ",");
		detectMissingRows();
	}
	
	@Test
	public void shouldGet23MissingRows2() throws IOException {
		source = loadFile("src/test/resources/folders_list.txt", "/");
		updated= loadFile("src/test/resources/catalogue.txt", ",");
		detectMissingRows();
	}
	
	private void detectMissingRows() {
		Iterator<String> iterator = updated.keySet().iterator();
		while (iterator.hasNext()) {
			source.remove(iterator.next());
		}
		iterator = source.keySet().iterator();
		int i = 0;
		while (iterator.hasNext()) {
			String next = iterator.next(); 
			System.out.println(next + ", " + source.get(next));
		}
	}
	
	private Map<String, String> loadFile(String fileName, String character) throws IOException {
		Map<String, String> returnMap = new HashMap<String, String>();
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		String line;
		int i = 0;
		while ((line = br.readLine()) != null) {
			String[] values = line.split(character);
			if (values.length > 2){
				String identifiers = "";
				if (values.length > 3){
					for (int j = 3; j < values.length; j++) {
						identifiers += "," + values[j];
					}
				}
				String key = values[0] + "," + values[1] + "," + values[2];
				key = key.replaceAll(" ", "_");
				key = key.toUpperCase();
				returnMap.put(key , identifiers);
			}
		}
		br.close();
		return returnMap;
	}
}
