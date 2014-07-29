package com.codetest.tests.episodenames;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.junit.Test;

public class DuplicatesDiff {
	Map<String, String> source = new HashMap<String, String>();
	Map<String, String> updated = new HashMap<String, String>();

	//@Test
	public void shouldGet23MissingRows() throws IOException {
		source = loadFile("src/test/resources/update-prod.sql");
		updated = loadFile("src/test/resources/batch_ingest1.csv");
		detectMissingRows();
	}
	
	//@Test
	public void shouldGet23MissingRows2() throws IOException {
		updated= loadFile("src/test/resources/update-prod.sql");
		source  = loadFile("src/test/resources/batch_ingest1.csv");
		detectMissingRows();
	}
	
	@Test
	public void shouldgGetDuplicated() throws IOException {
		source  = loadFile("src/test/resources/new_list.txt");
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
	
	private Map<String, String> loadFile(String fileName) throws IOException {
		Map<String, String> returnMap = new HashMap<String, String>();
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		String line;
		int i = 0;
		while ((line = br.readLine()) != null) {
			String[] values = line.split(",");
			String before = returnMap.put(values[0] + "," + values[1],
					values[2]);
			if (before != null) {
				System.out.println(++i + " - Duplicated in " + fileName + " !!!!! : " + values[0] + "," + values[1] + ","  + before);
			}
		}
		br.close();
		return returnMap;
	}
}
