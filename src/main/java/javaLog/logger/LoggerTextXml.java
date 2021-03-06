package javalog.logger;


import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.XMLFormatter;


// NOTE: This logger is set up for GLOBAL_LOGGER_NAME 
public class LoggerTextXml {

	private LoggerTextXml() {}
    
	// When you create these loggers and add handlers, you automatically
	//   have a handler to output to the Console (System.err), if you don't
	//   want it to output to System.err, you must manually remove it
    public static void setup(String directory) throws IOException {

    	Formatter formatterXML;
    	FileHandler fileXML;
    	
    	FileHandler fileTxt;
    	SimpleFormatter formatterTxt;
    	
        // get the global logger to configure it
        Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

        logger.setLevel(Level.FINER);
        fileTxt = new FileHandler(directory + "\\globalLog.txt");
        fileXML = new FileHandler(directory + "\\globalLog.xml");
        
        // create a TXT formatter
        formatterTxt = new SimpleFormatter();
        fileTxt.setFormatter(formatterTxt);
        logger.addHandler(fileTxt);

        // create an HTML formatter
        formatterXML = new XMLFormatter();
        fileXML.setFormatter(formatterXML);
        logger.addHandler(fileXML);
    }
}
