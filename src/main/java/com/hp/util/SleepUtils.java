package com.hp.util;

public class SleepUtils {
	private static LogUtils logger = new LogUtils();

	private SleepUtils() {
	}

	public static void sleep(int secs) {
		try {
			Thread.sleep(secs * 1000);
		} catch (InterruptedException e) {
			logger.handleError("Error while performing sleep operation", e);
		}
	}

}
