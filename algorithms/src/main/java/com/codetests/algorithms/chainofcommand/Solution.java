package com.codetests.algorithms.chainofcommand;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) {
		/*
		 * 4
			0
			3
			4
			1 2
			
			3
		 */
	}

	static boolean canApprovePurchases(int N, int approver, int requester, String[] directReports) {
		Map<Integer, Map> hierarchy = new HashMap<Integer, Map>();
		int directBoss = 0;
		/*for (String hierarchyLevel : directReports) {
			StringTokenizer st = new StringTokenizer(hierarchyLevel, " ");
			hierarchy.put(directBoss, new HashMap<Integer, Map>());
			while (st.hasMoreElements()) {
				Integer employeeNumber = Integer.parseInt(st.nextToken());
				if (employeeNumber == requester){
					canApprovePurchases(N, approver, requester, hierarchy);
				}else{
					hierarchy.get(directBoss).put(employeeNumber, new HashMap<Integer, Map>());
				}
			}
		}*/
		return false;
    }
}
