package com.hp.examples;

import java.util.Date;

import com.hp.util.LogUtils;
import com.hp.util.SleepUtils;

public class Test {

	private static LogUtils logger = new LogUtils("Test");

	public static void main(String[] args) {
		logger.debug("fun", "fun(100)");
		fun(100);
	
		logger.debug("fun", "fun()");
		fun();
		
		logger.debug("fun", "fun(1,2,3,4,5)");
		fun(1, 2, 3, 4);

		System.out.println(System.getProperty("user.dir"));
		Date d = new Date();
		String fileName = d.toString() + ".html";
		System.out.println(fileName);
		fileName = d.toString().replace(":", "_").replace(" ", "_") + ".html";
		SleepUtils.sleep(2);
		System.out.println(fileName);
	}

	private static void fun(int... a) {
		System.out.println("Number of arguments: " + a.length);
		logger.trace("Number of arguments: " + a.length);
		for (int i : a)
			System.out.print(i + " ");
		System.out.println();
	}

}
