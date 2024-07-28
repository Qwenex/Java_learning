package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App
{
    public static Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        logger.info("Info log message");
        logger.warn("Warn log message");
        logger.error("Error log message");
        logger.debug("Debug log message");
        logger.trace("Trace log message");
    }
}
