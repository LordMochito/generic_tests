package com.codetests.algorithms.minlegthwithentirenumbers;

import java.util.HashSet;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		System.out.println(new Solution().solution(new Integer[]{7,3,7,3,1,3,4,1}));
		System.out.println(new Solution().solution(new Integer[]{7}));
		System.out.println(new Solution().solution(new Integer[]{7,7,8}));
	}

	public int solution(Integer[] A) {
		if (A.length == 0)
			return 0;
		int shorter = A.length;
		for (int j = 0; j < A.length; j++) {
			Set<Integer> locations = getLocations(A);
			for (int i = j; i < A.length; i++) {
				int trip = A[i];
				locations.remove(trip);
				if (locations.size() == 0){
					if (i < shorter)
						shorter = i;
					break;
				}
			}
		}
		return shorter;
    }
	
	private Set<Integer> getLocations(final Integer[] A) {
		Set<Integer> locations = new HashSet<>(); 
		for (int i = 0; i < A.length; i++) {
			Integer location = A[i];
			locations.add(location);
		}
		return locations;
	}
}
