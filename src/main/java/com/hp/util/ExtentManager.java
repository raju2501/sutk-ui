package com.hp.util;

import java.io.File;
import java.util.Date;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {
	private static ExtentReports extent;
	public static String reportPath = null;

	public static ExtentReports getInstance() {

		if (extent == null) {

			Date d = new Date();

			String fileName = d.toString().replace(":", "_").replace(" ", "_") + ".html";

			reportPath = Constants.Reports + fileName;

			extent = new ExtentReports(reportPath, true, DisplayOrder.OLDEST_FIRST);

			extent.loadConfig(new File(Constants.currentDir + "//Reports.xml"));

		}
		return extent;
	}
}
