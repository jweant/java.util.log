package javalog;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javalog.logger.ErrorLogger;
import javalog.logger.NamedLoggerTextHtml;

public class AnotherClass {

	private static final Logger log = Logger.getLogger(AnotherClass.class.getName());

	AnotherClass() {
		try {
			NamedLoggerTextHtml.setup(AnotherClass.class.getName(), App.logDirectory);
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
	
	public void doSomething() {
		// I don't know how to get the function name...
		log.entering(AnotherClass.class.getName(), "doSomething");
		log.info("I'm in this function now...");
	
		System.out.println("Doing something..."); // NOSONAR
	
		ErrorLogger.getLogger().log(Level.INFO, ()->"doing Something " + AnotherClass.class.getName());
		
		log.exiting(AnotherClass.class.getName(), "doSomething");
	}
}
