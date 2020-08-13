package javaLog.logger;


import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.XMLFormatter;

import javaLog.formatters.HtmlFormatter;


// NOTE: This logger is set up for GLOBAL_LOGGER_NAME 
public class LoggerTextXml {
    static private FileHandler fileTxt;
    static private SimpleFormatter formatterTxt;

    static private FileHandler fileXML;
    static private Formatter formatterXML;

    static private ConsoleHandler consoleTxt;
    
    static public void setup(String directory) throws IOException {

        // get the global logger to configure it
        Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

        // don't suppress the logging output to the console
        //Logger rootLogger = Logger.getLogger("");
        //Handler[] handlers = rootLogger.getHandlers();
        //if (handlers[0] instanceof ConsoleHandler) {
        //    rootLogger.removeHandler(handlers[0]);
        //}

        logger.setLevel(Level.FINER);
        fileTxt = new FileHandler(directory + "\\MyLogging2.txt");
        fileXML = new FileHandler(directory + "\\MyLogging2.xml");

        consoleTxt = new ConsoleHandler();
        
        // create a TXT formatter
        formatterTxt = new SimpleFormatter();
        fileTxt.setFormatter(formatterTxt);
        logger.addHandler(fileTxt);

        // create an HTML formatter
        formatterXML = new XMLFormatter();
        fileXML.setFormatter(formatterXML);
        logger.addHandler(fileXML);
        
        consoleTxt.setFormatter(new SimpleFormatter());
        logger.addHandler(consoleTxt);
    }
}
