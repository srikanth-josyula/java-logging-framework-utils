package com.sample;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4j2FormatterClient {

	//This retrieves a logger that uses formatting parameters similar to Java's Formatter class
	//It allows you to use format strings like %s, %d, %t, etc., in your log messages.
	private static final Logger logger = LogManager.getFormatterLogger(Log4j2FormatterClient.class);
	
	public static void main(String[] args) {
		
		try {
			
			//Formatter loggers give fine-grained control over the output format,
			//but have the drawback that the correct type must be specified (
			//for example, passing anything other than a decimal integer for a %d format parameter gives an exception).
			
			String userName = "Test";
			Date userBirthday = new Date();
			logger.debug("Logging in user " + userName + " with birthday " + userBirthday);
			logger.debug("Logging in user %s with birthday %s", userName, userBirthday);
			logger.debug("Logging in user %1$s with birthday %2$tm %2$te,%2$tY", userName, userBirthday);
			logger.debug("Integer.MAX_VALUE = %,d", Integer.MAX_VALUE);
			logger.debug("Long.MAX_VALUE = %,d", Long.MAX_VALUE);
			
			
			throw new Exception();
		} catch (Exception e) {
			logger.error("Designates error events that might still allow the application to continue running.");
		}
	}
}
