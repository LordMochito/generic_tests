package com.codetests.algorithms.time;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ElapseTimer {

	public static void main(String[] args) {
		long time = System.currentTimeMillis();
		try {
		    Thread.sleep(15000);
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		long completedIn = System.currentTimeMillis() - time;
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		String formatted = sdf.format(new Date(completedIn));
		System.out.println("It spent " + formatted);
	}
}
