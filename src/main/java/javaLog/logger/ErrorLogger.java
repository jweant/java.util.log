package javaLog.logger;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javaLog.formatters.HtmlFormatter;

public class ErrorLogger {
	
	public static final String name = new String("ERROR");
	
	public static Logger getLogger() {
		return Logger.getLogger(name);
	}
	
    static private FileHandler fileTxt;
    static private SimpleFormatter formatterTxt;

    static private FileHandler fileHTML;
    static private Formatter formatterHTML;

    // Output to System.err
    //static private ConsoleHandler consoleHandler;
    //static private SimpleFormatter consoleFormatterTxt;
    
    static public void setup(String directory) throws IOException {

        // get the logger to configure it
        Logger logger = Logger.getLogger(name);

        logger.setLevel(Level.FINEST);
        String formatName1 = String.format("%s\\Error.txt", directory);
        String formatName2 = String.format("%s\\Error.html", directory);
        fileTxt = new FileHandler(formatName1);
        fileHTML = new FileHandler(formatName2);
       // consoleHandler = new ConsoleHandler();
        
       // consoleFormatterTxt = new SimpleFormatter();
       // consoleHandler.setFormatter(consoleFormatterTxt);
       // logger.addHandler(consoleHandler);
        
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
