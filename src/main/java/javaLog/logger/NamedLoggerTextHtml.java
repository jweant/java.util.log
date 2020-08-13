package javaLog.logger;


import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javaLog.formatters.HtmlFormatter;

//NOTE: This logger is set up for GLOBAL_LOGGER_NAME 
public class NamedLoggerTextHtml {
    static private FileHandler fileTxt;
    static private SimpleFormatter formatterTxt;

    static private FileHandler fileHTML;
    static private Formatter formatterHTML;

    static public void setup(String name, String directory) throws IOException {

        // get the logger to configure it
        Logger logger = Logger.getLogger(name);

        // suppress the logging output to the console
       // Logger rootLogger = Logger.getLogger("");
        //Handler[] handlers = logger.getHandlers();
       // if (handlers[0] instanceof ConsoleHandler) {
       // 	logger.removeHandler(handlers[0]);
       // }

        logger.setLevel(Level.FINEST);
        String formatName1 = String.format("%s\\MyLogger%s.txt", directory, name);
        String formatName2 = String.format("%s\\MyLogger%s.html", directory, name);
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