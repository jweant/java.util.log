package javaLog;

import java.util.logging.Logger;

public class AnotherClass {
	// Find or create a logger for a named subsystem. If a logger has already been created with the given name it is returned. Otherwise a new logger is created.
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	// Create a local logger for ConfigBuilder: this is generally how I've seen loggers used....
	private final static Logger cbLogger = Logger.getLogger(App.class.getName());
	
}
