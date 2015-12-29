package com.codetests.algorithms.audiobook;

import java.util.HashMap;
import java.util.Map;

public class Splitter {

	String[] paths = new String[] { "73247XXXRANDREWS_OPLACE", "106750XXXRANDREWS_OPLACE", "34815XXXEBERRETT_OPLACE",
			"43088XXXEBERRETT_OPLACE", "65613XXXRANDREWS_OPLACE", "81301XXXRANDREWS_OPLACE", "102609XXXRANDREWS_OPLACE",
			"65661XXXRANDREWS_OPLACE", "22914XXXRANDREWS_OPLACE", "89712XXXRANDREWS_OPLACE", "47152XXXEBERRETT_OPLACE",
			"102069XXXJFLURY_OPLACE" };

	public static void main(String[] args) {
		new Splitter().spliIt();
	}

	private void spliIt() {
		for (String path : paths) {
			final Map<String, Object> map = new HashMap<String, Object>();
			String[] dataPath = path.split("XXX");
			map.put("audiobook_id", dataPath[0]);
			map.put("account_id", dataPath[1]);
			System.out.println(map);
		}
	}
}
