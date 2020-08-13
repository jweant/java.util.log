package javaLog;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.logging.Logger;

import javaLog.logger.ErrorLogger;
import javaLog.logger.NamedLoggerTextHtml;

public class AnotherClass {

	private final static Logger log = Logger.getLogger(AnotherClass.class.getName());

	AnotherClass() {
		try {
			NamedLoggerTextHtml.setup(AnotherClass.class.getName(), App.logDirectory);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.throwing(AnotherClass.class.getName(), 
					AnotherClass.class.getEnclosingMethod().getName(), e);
			ErrorLogger.getLogger().severe(String.format("I couldn't set up the logger for %s",AnotherClass.class.getName()));
		}
		ErrorLogger.getLogger().info(String.format("I've created %s", AnotherClass.class.getName()));
	}
	
	public void doSomething() {
		// I don't know how to get the function name...
		log.entering(AnotherClass.class.getName(), "doSomething");
		log.info("I'm in this function now...");
		System.out.println("Doing something...");
		log.exiting(AnotherClass.class.getName(), "doSomething");
	}
}
