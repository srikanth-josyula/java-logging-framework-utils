package com.sample;

import java.util.Date;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

public class Log4j2AdvancedClient {

	private static final Marker TEST_MARKER = MarkerManager.getMarker("TEST");
	private static final Marker TEST_CHILD_MARKER = MarkerManager.getMarker("TEST_CHILD").setParents(TEST_MARKER);
	    
	private static final Logger logger = LogManager.getLogger(Log4j2AdvancedClient.class);
	private static String[] messages = new String[] {
	        "Hello, World",
	        "Goodbye Cruel World",
	        "You had me at hello"
	    };

	public static void main(String[] args) {
		boolean isDebugEnabled = logger.isDebugEnabled();
		
		try {

			if (isDebugEnabled) {
				//Substituting Parameters
				String userName = "Test";
				Date userBirthday = new Date();
				logger.debug("Logging in user " + userName + " with birthday " + userBirthday);
				logger.debug("Logging in user {} with birthday {}", userName, userBirthday); //as we use place holders we its default formatting for dates, which is in ISO 8601 
				
				//below will not work as we have LogManager.getLogger this uses default
				logger.debug("Logging in user %s with birthday %s", userName, userBirthday);
				//To mix Logger with LogFormatter we can use printf
				logger.printf(Level.INFO, "Logging in user %s with birthday %s", userName, userBirthday);
			}
			
			markerExample("Marker Test");

			
			throw new Exception();
		} catch (Exception e) {
			//exampleException();
			logger.error("Unable to process request due to {}", e.getMessage(), e);
		}
	}
	
	
	public static void exampleException() {
		//The Logger class offers essential methods like entry(), exit(), throwing(), and catching() to facilitate comprehensive logging of method execution flow. 
        logger.entry();
        //OutPut : 2024-02-18 12:14:51.026 [TRACE] [com.sample.Log4j2AdvancedClient] [exampleException:46] - Enter
        try {
            String msg = messages[messages.length];
            logger.error("An exception should have been thrown");
        //2024-02-18 12:14:51.027 [ERROR] [com.sample.Log4j2AdvancedClient] [exampleException:51] - Catching
        } catch (Exception ex) {
            logger.catching(ex);
        }
        logger.exit();
    }
	
	
	public static String markerExample(String text) {
        logger.traceEntry("Marker Entry Traces");
        logger.debug(TEST_MARKER,  "{}", text);
        logger.debug(TEST_CHILD_MARKER, "{}", text);
        String result = "Output Marker";
        return logger.traceExit(result);
    }
 
}
