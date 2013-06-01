/**
 * 
 */
package com.jeetemplates.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Logger class.
 * 
 * @author jeetemplates
 */
public final class LoggerUtils {

	/**
	 * Logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(LoggerUtils.class);

	/**
	 * Log debug.
	 * 
	 * @param message
	 *            : message to display
	 */
	public static void logDebug(String message) {
		logger.debug(message);
	}

	/**
	 * Log info.
	 * 
	 * @param message
	 *            : message to display
	 */
	public static void logInfo(String message) {
		logger.info(message);
	}

	/**
	 * Log debug start of a method.
	 * 
	 * @param method
	 *            : method name
	 */
	public static void logStartMethod(String method) {
		logDebug("START method : " + method);
	}

	/**
	 * Log debug end of a method.
	 * 
	 * @param method
	 *            : method name
	 */
	public static void logEndMethod(String method) {
		logDebug("END method : " + method);
	}

}
