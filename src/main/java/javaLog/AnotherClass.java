package javalog;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javalog.logger.ErrorLogger;
import javalog.logger.NamedLoggerTextHtml;

public class AnotherClass {

	// Local logger, set up to log as defined in NamedLoggerTextHtml.setup
	private static final Logger log = Logger.getLogger(AnotherClass.class.getName());
	// Global logger; set up via LoggerTextXml.setup (previously)
	private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	AnotherClass() {
		try {
			NamedLoggerTextHtml.setup(AnotherClass.class.getName(), App.LOGDIRECTORY);
		} catch (IOException e) {

			e.printStackTrace();
			log.throwing(AnotherClass.class.getName(), 
					AnotherClass.class.getEnclosingMethod().getName(), e);
			ErrorLogger.getLogger().severe(String.format("I couldn't set up the logger for %s", AnotherClass.class.getName()));
		}
		// This doesn't print to error log because error log isn't initialized yet to have 
		//   actual log files...look at the order of operations in App
		ErrorLogger.getLogger().log(Level.INFO, ()-> "I've created " + AnotherClass.class.getName());
	}
	
	public int doSomething(int aVariable) {
		int result = 3; // NOSONAR
		// I don't know how to get the function name...
		log.entering(AnotherClass.class.getName(), "doSomething", aVariable);
		log.info("I'm in this function now...");
	
			// I'm using the SonarQube Eclipse plugin and this (the NOSONAR) makes it shut up for this line
		System.out.println("Doing something..."); // NOSONAR
		LOGGER.info("Look global logger, I'm in the doSomething class");
		
		ErrorLogger.getLogger().log(Level.INFO, ()->"doing Something " + AnotherClass.class.getName());
		
		result++;
		log.exiting(AnotherClass.class.getName(), "doSomething", result);
		return result;
	}
}
