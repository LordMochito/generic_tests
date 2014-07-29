package com.codetest.tests.episodenames;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.junit.Test;

public class Missing23Rows {
	Map<String, String> source = new HashMap<String, String>();
	Map<String, String> updated = new HashMap<String, String>();
	int[] notFound = new int[] { 13, 16, 17, 33, 36, 42, 43, 45, 53, 69, 73,
			109, 145, 146, 163, 247, 271, 301, 302, 344, 501, 533, 540, 549,
			593, 617, 657, 755, 835, 917, 921, 969, 1023, 1060, 1221, 1360,
			1378, 1507, 1541, 1665, 1671, 1686, 1739, 1796, 1887, 1888, 1914,
			1924, 1958, 2076, 2168, 2282, 2356, 2370, 2372, 2437, 2494, 2505,
			2529, 2574, 2668, 2675, 2680, 2682, 2684, 2707, 3111, 3112, 3130,
			3153, 3178, 3225, 3226, 3283, 3343, 3446, 3505, 3628, 3790, 3836,
			3956, 4040, 4329, 4408, 4619, 4725, 4768, 5100, 5101, 5201, 5217,
			5871, 5973, 6542, 6549, 6554, 6556, 6558 };

	@Test
	public void shouldGet23MissingRows() throws IOException {
		source = loadFile("src/test/resources/source.csv");
		updated = loadFile("src/test/resources/updated.sql");
		detectMissingRows();
	}

	private void detectMissingRows() {
		Iterator<String> iterator = updated.keySet().iterator();
		int notFoundPos = 0;
		int i = 0;
		while (iterator.hasNext()) {
			if ((i++) == notFound[notFoundPos]) {
				notFoundPos ++;
			} else {
				removeFromSource(iterator.next());
			}
		}
		iterator = source.keySet().iterator();
		i = 0;
		while (iterator.hasNext()) {
			System.out.println(++i + " - Not proccessed !!!!! : " + iterator.next());
		}
	}

	private void removeFromSource(String key) {
		source.remove(key);
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
				System.out.println(++i + " - Duplicated !!!!! : " + values[0] + "," + values[1] + ","  + before);
			}
		}
		br.close();
		return returnMap;
	}
}
