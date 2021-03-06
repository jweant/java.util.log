package javalog.logger;


import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javalog.formatters.HtmlFormatter;

//NOTE: This logger is set up for GLOBAL_LOGGER_NAME 
public class NamedLoggerTextHtml {

	private NamedLoggerTextHtml() {}
	
    public static void setup(String name, String directory) throws IOException {

    	Formatter formatterHTML;
    	FileHandler fileHTML;
    	
    	FileHandler fileTxt;
    	SimpleFormatter formatterTxt;
    	
        // get the logger to configure it
        Logger logger = Logger.getLogger(name);

        logger.setLevel(Level.FINEST);
        String formatName1 = String.format("%s\\%slog.txt", directory, name);
        String formatName2 = String.format("%s\\%slog.html", directory, name);
        fileTxt = new FileHandler(formatName1);
        fileHTML = new FileHandler(formatName2);

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
