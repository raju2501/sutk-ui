package com.hp.util;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class LogUtils {

	public LogUtils(Object owner) {
		this.owner = owner;
	}

	public void initialize(String configFile) {
		if (logInitialized == false) {
			try {
				DOMConfigurator.configure(configFile);
			} catch (Exception e) {
				handleError("Error in loading configuration", configFile, e);
			}
			logInitialized = true;
		}
	}

	public LogUtils() {
		this("<Null>");
	}

	public void debug(Object... varargs) {
		logger.debug(StringUtils.toString(owner) + DELIM + toString(varargs));
	}

	public void trace(Object... varargs) {
		logger.trace(StringUtils.toString(owner) + DELIM + toString(varargs));
	}

	public void detail(Object... varargs) {
		logger.info(StringUtils.toString(owner) + DELIM + toString(varargs));
	}

	public void warning(Object... varargs) {
		logger.warn(StringUtils.toString(owner) + DELIM + toString(varargs));
	}

	public void error(Object... varargs) {
		logger.error(StringUtils.toString(owner) + DELIM + toString(varargs));

	}

	public void handleError(String msg, Object... varargs) {
		Exception rootCause = null;
		if (varargs.length != 0) {
			if (varargs[0] instanceof Exception) {
				rootCause = (Exception) varargs[0];
			}
		}
		String text = "Error: " + msg + DELIM + toString(varargs);
		error(text);

		if (rootCause != null) {
			error(msg, rootCause.getStackTrace());
		}
	}

	private static final String DELIM = "|";

	private static String toString(Object... varargs) {
		String s = "", delim = "";
		for (Object obj : varargs) {
			s += delim + StringUtils.toString(obj);
			delim = DELIM;
		}
		return s;
	}

	public String toString() {
		return StringUtils.mapString(this);

	}

	private Logger logger = Logger.getLogger(this.getClass());
	private static boolean logInitialized = false;
	private Object owner;
}
