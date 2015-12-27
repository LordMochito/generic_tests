package com.codetests.algorithms.sanitise.numbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			List<Integer> resultList = null;
			String nextLine = null;
			StringTokenizer st = null;
			int nextInteger = 0;
			do {
				resultList = new ArrayList<Integer>();
				nextLine = sc.nextLine();
				st = new StringTokenizer(nextLine, " ");
				while (st.hasMoreElements()) {
						nextInteger = Integer.parseInt(st.nextToken());
					if (!resultList.contains(nextInteger)) 
						resultList.add(nextInteger);
				}
				Collections.sort(resultList);
				System.out.println(resultList.toString().replace("[", "").replace("]", "").replaceAll(",", ""));
			} while (sc.hasNextLine());
			sc.close();

		} catch (NumberFormatException e) {
			System.err.println("Bad integers sequence");
			System.exit(0);
		}
	}
}
