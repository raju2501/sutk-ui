/**
 * 
 */
package com.hp.util;

/**
 * @author gojjimi
 *
 */
public class StringUtils {

	public static String toString(Object o) {
		if (o == null) {
			return "<null>";
		}

		try {
			return o.toString();
		} catch (Exception ex) {
		}

		return "<ObjectWithoutStringForm>";
	}

/*	public static String mapString(LogUtils logUtils) {
		// TODO Auto-generated method stub
		return null;
	}*/
	public static String mapString(Object o, Object... varArgs) {
		return o.getClass().getSimpleName() + "{ " + toString(varArgs) + " }";
	}
	
}
