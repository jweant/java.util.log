/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package javalog;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javalog.logger.ErrorLogger;
import javalog.logger.LoggerTextXml;
import javalog.logger.NamedLoggerTextHtml;


public class App {
	
	public static final String LOGDIRECTORY = "log";
	
	// Find or create a logger for a named subsystem. If a logger has already been created with the given name it is returned. Otherwise a new logger is created.
	private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	// Create a local logger for ConfigBuilder: this is generally how I've seen loggers used....
	private static final Logger cbLogger = Logger.getLogger(App.class.getName());
	// Create an error handler for errors
	
    public String getGreeting() {
    	String greeting = "Hello world";
    	// This is commented out to show that you shouldn't do things this way...
    	//   SonarQube complained; the compliant solution is below
    	//   SQ complained since no matter what the level the String.format is called
    	//cbLogger.info(String.format("Greeting is %s", greeting)); // NOSONAR
    	cbLogger.log(Level.INFO, () -> "Greeting is: " + greeting);
    	
    	return greeting;
    }
    	
    	
    	
    	

    public static void setupMyLogs() {
    	
    	// Set my local logger to FINEST
    	cbLogger.setLevel(Level.FINEST);
    	// Set global to WARN
    	LOGGER.setLevel(Level.WARNING);
    	// Set to FINER to print out
    	ErrorLogger.getLogger().setLevel(Level.FINER);
    	
		try {
			// Creates a log file called globalLog.txt and globalLog.xml in the working directory
			//   There is a console handler here that prints it out to screen
			LoggerTextXml.setup(LOGDIRECTORY);
			// Initialize the local logger
			//   Local logger is called 
			NamedLoggerTextHtml.setup(cbLogger.getName(),LOGDIRECTORY);
			// Set up a separate error logger, I've set this up as an example of a self-contained logger...
			//   this self-contained logger is just set up as a class...
			//   Name is Error.txt and Error.html
			//   You can also just log all your errors at level ERROR....
			ErrorLogger.setup(LOGDIRECTORY);
			
		} catch (IOException e1) {
			e1.printStackTrace();
			// throwing logs at the FINER level
			cbLogger.throwing(App.class.getName(),"main", e1);
			ErrorLogger.getLogger().throwing(App.class.getName(), "main", e1);
		}	
		
		// MyLoggingT
		
		
    }
    
    public static void main(String[] args) {
    	AnotherClass ac = new AnotherClass();
    	setupMyLogs();

    	// entering logs at FINER level
		cbLogger.entering(App.class.getName(), "main");
		
		// Using convenience methods for logging on these loggers
		LOGGER.severe("Global SEVERE log");
		LOGGER.warning("Global WARNING log");
		LOGGER.info("Global INFO log");
		LOGGER.fine("Global FINE log");
		LOGGER.finer("Global FINER log");
		LOGGER.finest("Global FINEST log");
		
		cbLogger.severe("cbLogger SEVERE log");
		cbLogger.warning("cbLogger WARNING log");
		cbLogger.info("cbLogger INFO log");
		cbLogger.fine("cbLogger FINE msg");
		cbLogger.finer("cbLogger FINER log");
		cbLogger.finest("cbLogger FINEST log");
		
		ErrorLogger.getLogger().info("Error Log: OMG its an INFO error");
		ErrorLogger.getLogger().warning("Error Log: This is just a warning");
		ErrorLogger.getLogger().severe("Error Log: OMG its severe!");
		
		// This is example code and doesn't matter, SQ complains about no magic numbers here, 
		//   so I am ignoring it
		ac.doSomething(5); // NOSONAR
		// SQ complains about not using a log here, I'm ignoring that
        System.out.println(new App().getGreeting()); // NOSONAR
        
        // This prints FINER: RETURN in the MyLoggerjavaLog.App
        cbLogger.exiting(App.class.getName(), "main");
    }
}
