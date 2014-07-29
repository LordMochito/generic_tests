package com.codetest.tests.episodenames;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;

public class CompareAs {
	Map<String, String> source = new TreeMap<String, String>();
	Map<String, String> updated = new TreeMap<String, String>();

	@Test
	public void shouldGet23MissingRows() throws IOException {
		source = loadFile("src/test/resources/ISRC_excel.txt");
		updated = loadFile("src/test/resources/vevo.txt");
		detectMissingRows();
	}
	
	//@Test
	public void shouldGet23MissingRows2() throws IOException {
		updated = loadFile("src/test/resources/ISRC_excel.txt");
		source  = loadFile("src/test/resources/vevo.txt");
		detectMissingRows();
	}
	

	private void detectMissingRows() {
		Iterator<String> iterator = updated.keySet().iterator();
		while (iterator.hasNext()) {
			source.remove(iterator.next());
		}
		iterator = source.keySet().iterator();
		while (iterator.hasNext()) {
			String next = iterator.next(); 
			System.out.println(next);
		}
	}
	
	private Map<String, String> loadFile(String fileName) throws IOException {
		Map<String, String> returnMap = new TreeMap<String, String>();
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		String line;
		int i = 0;
		while ((line = br.readLine()) != null) {
			String before = returnMap.put(line, line);
			if (before != null) {
				System.out.println(++i + " - Duplicated in " + fileName + " !!!!! : " + line + ","  + before);
			}
		}
		br.close();
		return returnMap;
	}
}
