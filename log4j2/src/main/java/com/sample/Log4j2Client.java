package com.sample;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4j2Client {

	private static final Logger logger = LogManager.getLogger(Log4j2Client.class);

	public static void main(String[] args) {
		boolean isDebugEnabled = logger.isDebugEnabled();

		try {
			
			// Logging Levels Available
			if (isDebugEnabled) {
				logger.trace("Designates finer-grained informational events than the DEBUG.");
				logger.debug(
						"Designates fine-grained informational events that are most useful to debug an application.");
			}

			logger.info("Designates informational messages that highlight the progress of the application at coarse-grained level.");
			logger.warn("Designates potentially harmful situations.");

			throw new Exception();
		} catch (Exception e) {
			logger.error("Designates error events that might still allow the application to continue running.");
			logger.fatal("Designates very severe error events that will presumably lead the application to abort.");
		}
	}
}
