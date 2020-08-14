package javalog.logger;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javalog.formatters.HtmlFormatter;

public class ErrorLogger {
	
	public static final String NAME = "ERROR";
	
	private ErrorLogger() {}
	
	public static Logger getLogger() {
		return Logger.getLogger(NAME);
	}
	


    // Output to System.err
    //   This is left here because initially I thought we had to add a ConsoleHandler
    //    by hand, but if you add this you get 2 ConsoleHandlers, so I've left it here
    //static private ConsoleHandler consoleHandler; // NOSONAR; its complaining about commented out code
    //static private SimpleFormatter consoleFormatterTxt; // NOSONAR
    
    
    public static void setup(String directory) throws IOException {
        FileHandler fileTxt;
        SimpleFormatter formatterTxt;

        FileHandler fileHTML;
        Formatter formatterHTML;
        
        // get the logger to configure it
        Logger logger = Logger.getLogger(NAME);

        logger.setLevel(Level.FINEST);
        String formatName1 = String.format("%s\\Error.txt", directory);
        String formatName2 = String.format("%s\\Error.html", directory);
        fileTxt = new FileHandler(formatName1);
        fileHTML = new FileHandler(formatName2);
        
       // consoleHandler = new ConsoleHandler(); // NOSONAR
       // consoleFormatterTxt = new SimpleFormatter(); // NOSONAR
       // consoleHandler.setFormatter(consoleFormatterTxt); // NOSONAR
       // logger.addHandler(consoleHandler); // NOSONAR
        
        // create a TXT formatter
        formatterTxt = new SimpleFormatter();
        fileTxt.setFormatter(formatterTxt);
        logger.addHandler(fileTxt);

        // create an HTML formatter
        formatterHTML = new HtmlFormatter();
        fileHTML.setFormatter(formatterHTML);
        logger.addHandler(fileHTML);
    }
}
